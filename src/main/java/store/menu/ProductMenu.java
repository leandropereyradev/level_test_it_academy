package store.menu;

import store.model.product.Product;

import java.util.List;

public class ProductMenu {

    public static void printProductOptions(List<Product> products) {
        products.forEach(product -> {
            System.out.println("\t" + product.getID() + ". " + product.getProduct());
        });

        System.out.print("Select an option: ");
    }
}
