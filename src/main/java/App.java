import menu.MainMenuOption;

import java.util.*;

public class App {
    private List<Pedido> orders = new ArrayList<>();
    private static final List<Producto> PRODUCTOS = new ArrayList<>();
    private static final List<Repartidor> REPARTIDORES = new ArrayList<>();

    static {
        PRODUCTOS.add(new Producto(ProductType.BURRITO.getType(), ProductType.BURRITO.getPrice(), ProductType.BURRITO.getGift()));
        PRODUCTOS.add(new Producto(ProductType.KEBAB.getType(), ProductType.KEBAB.getPrice(), ProductType.KEBAB.getGift()));
        PRODUCTOS.add(new Producto(ProductType.PIZZA.getType(), ProductType.PIZZA.getPrice(), ProductType.PIZZA.getGift()));
        PRODUCTOS.add(new Producto(ProductType.HAMBURGUER.getType(), ProductType.HAMBURGUER.getPrice(), ProductType.HAMBURGUER.getGift()));

        REPARTIDORES.add(new Repartidor("Repartidor 1"));
        REPARTIDORES.add(new Repartidor("Repartidor 2"));
        REPARTIDORES.add(new Repartidor("Repartidor 3"));
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
        PRODUCTOS.forEach(product -> {
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
        List<Producto> selectedProducts = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Customer name: ");
        String customer_name = scanner.nextLine();

        System.out.println("Customer address: ");
        String customer_address = scanner.nextLine();

        Cliente cliente = new Cliente(customer_name, customer_address);

        System.out.println("Select a product: ");
        printProductOptions();
        int product = scanner.nextInt();

        selectedProducts.add(PRODUCTOS.get(product));

        Random random = new Random();
        int index = random.nextInt(REPARTIDORES.size());

        Pedido order = new Pedido(cliente, selectedProducts, REPARTIDORES.get(index));

        this.orders.add(order);

    }

    private void listPendingOrder() {

    }
}
