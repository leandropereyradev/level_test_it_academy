import menu.MainMenuOption;

import java.util.*;

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
            printMainMenu();

            try {
                option = scanner.nextInt();
                scanner.nextLine();

                handleMenuOption(option);

            } catch (InputMismatchException e) {
                System.out.println("Invalid Option");
                scanner.nextLine();
                option = 0;

            }
        } while (option != 5);

    }

    private void printMainMenu() {
        System.out.println("\n1. New order");
        System.out.println("2. Mark order as delivered");
        System.out.println("3. List pending orders");
        System.out.println("4. List Delivered Orders");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    private void printProductOptions() {
        PRODUCTS.forEach(product -> {
            System.out.println("\t" + product.getID() + ". " + product.getProduct());
        });

        System.out.print("Select an option: ");
    }

    private void printDeliveryMethodOptions() {
        for (DeliveryMethod method : DeliveryMethod.values())
            System.out.println("\t" + method.getOPTION() + ". " +
                    method.getMETHOD() +
                    "\n\tAdditional cost on the total: " + method.getPERCENTAGE() + "\n"
            );

        System.out.print("Select an option: ");
    }

    private void handleMenuOption(int option) {
        switch (option) {
            case MainMenuOption.ADD_ORDER -> addOrder();
            case MainMenuOption.MARK_DELIVERED -> markDelivered();
            case MainMenuOption.LIST_PENDINGS -> listPendingOrders();
            case MainMenuOption.LIST_DELIVERS -> listDeliveredOrders();
            case MainMenuOption.EXIT -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void addOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean addOther;
        DeliveryMethod deliveryMethodSelected = null;
        boolean isDeliveryMethodSelected = false;

        if (DELIVERYMEN.stream().noneMatch(Deliveryman::isAvailable)) {
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
        printDeliveryMethodOptions();

        while (!isDeliveryMethodSelected) {
            try {
                deliveryMethodSelected = selectDeliveryMethod();

                if (deliveryMethodSelected != null) {
                    isDeliveryMethodSelected = true;
                } else {
                    System.out.println("Invalid delivery method. Please select a valid option:");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid order number.");
            }
        }

        do {
            System.out.println("\nSelect a product: ");
            printProductOptions();
            int productID = getNextInt(scanner);

            selectedProducts.add(PRODUCTS.get(productID - 1));

            System.out.println("\tProduct added");

            System.out.println("\tDo you want to add another product? (1. Add another / 2. Return)");
            int option = getNextInt(scanner);
            addOther = (option == 1);

            scanner.nextLine();

        } while (addOther);

        Random random = new Random();
        int index = random.nextInt(DELIVERYMEN.size());

        Deliveryman deliverymanSelected = DELIVERYMEN.get(index);
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
                DELIVERYMEN.get(index),
                subtotal,
                total_price
        );
        ORDERS.add(order);

        System.out.println("\tOrder created:");

        System.out.println(order);
    }

    private DeliveryMethod selectDeliveryMethod() {
        Scanner scanner = new Scanner(System.in);

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

    private boolean listPendingOrders() {
        if (ORDERS.stream().allMatch(Order::getDeliveryStatus)) {
            System.out.println("There are no pending orders to display.");

            return false;
        }

        ORDERS.forEach(order -> {
            if (!order.getDeliveryStatus())
                System.out.println(order);

        });

        return true;
    }

    private void listDeliveredOrders() {
        if (ORDERS.stream().noneMatch(Order::getDeliveryStatus)) {
            System.out.println("There are no delivered orders to display.");

            return;
        }

        ORDERS.forEach(order -> {
            if (order.getDeliveryStatus())
                System.out.println(order);

        });

    }

    private void markDelivered() {

        while (listPendingOrders()) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose the order number to mark as delivered:");

            int orderNumber;

            try {
                orderNumber = getNextInt(scanner);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid order number.");
                continue;
            }

            for (Order order : ORDERS) {
                if (order.getID() == orderNumber) {
                    order.setDelivered(true);
                    order.getDELIVERYMAN().setAvailable(true);

                    System.out.println("Order marked as delivered.");
                    scanner.nextLine();
                    return;
                }
            }

            System.out.println("Order not found: " + orderNumber);
            scanner.nextLine();
        }
    }

    private int getNextInt(@org.jetbrains.annotations.NotNull Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Invalid input. Please enter a valid integer.");
        }

        return scanner.nextInt();
    }

}
