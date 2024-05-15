package store.services;

import store.exception.NoValidOptionException;
import store.menu.OrderMenu;
import store.menu.ProductMenu;
import store.model.customer.Customer;
import store.model.delivery.*;
import store.model.order.Order;
import store.model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static store.services.NextInt.getNextInt;

public class AddOrderService {
    public static void addOrder(
            Scanner scanner,
            List<Deliveryman> deliverymen,
            List<Product> products,
            List<Order> orders
    ) {
        boolean addOther;
        DeliveryMethod deliveryMethodSelected = null;
        boolean isDeliveryMethodSelected = false;
        boolean productSelected = false;

        if (deliverymen.stream().noneMatch(Deliveryman::isAvailable)) {
            System.out.println("There are no delivery drivers available.");
            return;
        }

        List<Product> selectedProducts = new ArrayList<>();

        System.out.println("\tCustomer name: ");
        String customer_name = scanner.nextLine();

        System.out.println("\tCustomer address: ");
        String customer_address = scanner.nextLine();

        Customer customer = new Customer(customer_name, customer_address);

        System.out.println("Select a delivery method:");
        OrderMenu.printDeliveryMethodOptions();

        while (!isDeliveryMethodSelected) {
            try {
                deliveryMethodSelected = selectDeliveryMethod(scanner);

                if (deliveryMethodSelected != null) {
                    isDeliveryMethodSelected = true;
                } else {
                    throw new NoValidOptionException("Invalid delivery method. Please select a valid option:");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid order number.");
            } catch (NoValidOptionException e) {
                System.out.println(e.getMessage());
            }
        }

        do {
            System.out.println("\nSelect a product: ");
            ProductMenu.printProductOptions(products);

            while (!productSelected) {
                try {
                    int productID = getNextInt(scanner);
                    selectedProducts.add(products.get(productID - 1));

                    productSelected = true;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please enter a valid order number: ");
                }
            }

            System.out.println("\tProduct added");

            System.out.println("\tDo you want to add another product? (1. Add another / 2. Return)");
            int option = getNextInt(scanner);
            addOther = (option == 1);

            scanner.nextLine();

        } while (addOther);

        Random random = new Random();
        int index = random.nextInt(deliverymen.size());

        Deliveryman deliverymanSelected = deliverymen.get(index);
        deliverymanSelected.setAvailable(false);
        deliverymanSelected.setMethod(deliveryMethodSelected);

        double subtotal = 0;

        for (Product product : selectedProducts) {
            subtotal += product.getPrice();
        }

        double total_price = subtotal * deliveryMethodSelected.getEXTRA();

        Order order = new Order(
                customer,
                selectedProducts,
                deliverymen.get(index),
                subtotal,
                total_price
        );
        orders.add(order);

        System.out.println("\tOrder created:");

        System.out.println(order);
    }

    private static DeliveryMethod selectDeliveryMethod(Scanner scanner) {
        int option = getNextInt(scanner);

        DeliveryMethod selectedMethod = null;
        for (DeliveryMethod method : DeliveryMethod.values()) {
            if (method.getOPTION() == option) {
                selectedMethod = method;
                break;
            }
        }

        if (selectedMethod != null) {
            System.out.println("\tDelivery method selected: " + selectedMethod.getMETHOD());
            System.out.println("\tAdditional cost on the total: " + selectedMethod.getPERCENTAGE());
        }

        scanner.nextLine();

        return selectedMethod;
    }
}
