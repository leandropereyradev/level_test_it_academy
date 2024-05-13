public class Product {

    private int ID;
    private String product;
    private double price;
    private String gift;

    public Product(int id, String product, double price, String gift) {
        this.ID = id;
        this.product = product;
        this.price = price;
        this.gift = gift;
    }

    public String getProduct(){
        return this.product;
    }

    public double getPrice() {
        return this.price;
    }

    public int getID(){
        return this.ID;
    }

    @Override
    public String toString() {
        return "Product: " + product +
                "\nPrice: " + price +
                "\nGift: " + gift;
    }
}
