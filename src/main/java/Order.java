import java.util.List;

public class Order {
    private int ID = 0;
    private Customer customer;
    private List<Product> products;
    private Deliveryman deliveryman;
    private boolean delivered = false;
    private double total_price = 0;

    public Order(Customer customer, List<Product> products, Deliveryman deliveryman) {
        this.ID ++;
        this.customer = customer;
        this.products = products;
        this.deliveryman = deliveryman;
    }

    public boolean getDelivered() {
        return this.delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    @Override
    public String toString() {
        return "Order: " +
                "\n\t" + customer +
                "\n\t" + products +
                "\n\t" + deliveryman +
                ", delivered=" + delivered +
                ", total_price=" + total_price +
                '}';
    }
}
