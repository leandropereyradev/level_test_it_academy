package store.app;

import store.exception.NoValidOptionException;
import store.menu.*;
import store.model.delivery.*;
import store.model.order.*;
import store.model.product.*;

import java.util.*;

import static store.services.AddOrderService.*;
import static store.services.ListOrder.*;
import static store.services.MarkDeliveredOrder.*;

public class App {
    private static final List<Order> ORDERS = new ArrayList<>();
    private static final List<Product> PRODUCTS = new ArrayList<>();
    private static final List<Deliveryman> DELIVERYMEN = new ArrayList<>();

    static {
        for (ProductType product : ProductType.values()) {
            PRODUCTS.add(new Product(
                    product.getIndex(),
                    product.getType(),
                    product.getPrice(),
                    product.getGift()
            ));
        }

        DELIVERYMEN.add(new Deliveryman("Delivery man 1"));
        DELIVERYMEN.add(new Deliveryman("Delivery man 2"));
        DELIVERYMEN.add(new Deliveryman("Delivery man 3"));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        do {
            MainMenu.printMainMenu();

            try {
                option = scanner.nextInt();
                scanner.nextLine();

                handleMenuOption(option, scanner);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();

            } catch (NoValidOptionException e) {
                System.out.println(e.getMessage());
            }

        } while (option != 5);
    }


    private void handleMenuOption(int option, Scanner scanner) throws NoValidOptionException {
        try {
            switch (option) {
                case MainMenuOption.ADD_ORDER -> addOrder(scanner, DELIVERYMEN, PRODUCTS, ORDERS);
                case MainMenuOption.MARK_DELIVERED -> markDelivered(scanner, ORDERS);
                case MainMenuOption.PENDINGS_LIST -> listPendingOrders(ORDERS);
                case MainMenuOption.DELIVERED_LIST -> listDeliveredOrders(ORDERS);
                case MainMenuOption.EXIT -> System.out.println("Goodbye!");
                default -> throw new NoValidOptionException("Invalid option. Please try again.");
            }

        } catch (NoValidOptionException e) {
            System.out.println(e.getMessage());
        }

    }

}
