import menu.MainMenuOption;

import java.util.*;

public class App {
    private List<Order> orders = new ArrayList<>();
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

                handleMenuOption(option, scanner);

            } catch (InputMismatchException e) {
                System.out.println("Invalid Option");
                scanner.nextLine();
                option = 0;

            }
        } while (option != 5);

    }

    private void printMainMenu() {
        System.out.println("1. New order");
        System.out.println("2. Mark order as delivered");
        System.out.println("3. List pending orders");
        System.out.println("4. List Delivered Orders");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    private void printProductOptions() {
        PRODUCTS.forEach(product -> {
            System.out.println(product.getID() + ". " + product.getProduct());
        });

        System.out.print("Select an option: ");
    }

    private void handleMenuOption(int option, Scanner scanner) {
        switch (option) {
            case MainMenuOption.ADD_ORDER -> addOrder();
            case MainMenuOption.MARK_DELIVERED -> System.out.println("ENTREGADO!");
            case MainMenuOption.LIST_PENDINGS -> listPendingOrder();
            case MainMenuOption.LIST_DELIVERS -> System.out.println("ENTREGADOS!");
            case MainMenuOption.EXIT -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void addOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean addOther;

        if (DELIVERYMEN.stream().noneMatch(Deliveryman::isAvailable)) {
            System.out.println("There are no delivery drivers available.");
            return;
        }

        List<Product> selectedProducts = new ArrayList<>();

        System.out.println("Customer name: ");
        String customer_name = scanner.nextLine();

        System.out.println("Customer address: ");
        String customer_address = scanner.nextLine();

        Customer customer = new Customer(customer_name, customer_address);

        Random random = new Random();
        int index = random.nextInt(DELIVERYMEN.size());

        DELIVERYMEN.get(index).setAvailable(false);

        do {
            System.out.println("Select a product: ");
            printProductOptions();
            int productID = scanner.nextInt();

            selectedProducts.add(PRODUCTS.get(productID - 1));

            Order order = new Order(customer, selectedProducts, DELIVERYMEN.get(index));

            this.orders.add(order);

            System.out.println("Product added");

            System.out.println("Do you want to add another product? (1. Add another / 2. Return)");
            int option = scanner.nextInt();
            addOther = (option == 1);

            scanner.nextLine();

        } while (addOther);

        System.out.println("Order created");
    }

    private void listPendingOrder() {
        orders.forEach(order -> {
            if(!order.getDelivered()){
                System.out.println(order);
            }
        });
    }
}
