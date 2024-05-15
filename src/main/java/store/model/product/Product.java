package store.model.product;

public class Product {

    private final int ID;
    private final String PRODUCT;
    private final double PRICE;
    private final String GIFT;

    public Product(int id, String product, double price, String gift) {
        ID = id;
        PRODUCT = product;
        PRICE = price;
        GIFT = gift;
    }

    public String getProduct(){
        return PRODUCT;
    }

    public double getPrice() {
        return PRICE;
    }

    public int getID(){
        return this.ID;
    }

    @Override
    public String toString() {
        return "\n\t\tProduct: " + PRODUCT +
                "\n\t\tPrice: " + PRICE + "€" +
                "\n\t\tGift: " + GIFT + "\n\t";
    }
}
