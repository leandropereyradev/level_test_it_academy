import java.util.List;

public class Order {
    private int ID;
    private Customer customer;
    private List<Product> products;
    private Deliveryman deliveryman;
    private boolean delivered;
    private double total_price;

    public Order(Customer customer, List<Product> products, Deliveryman deliveryman) {
        this.ID ++;
        this.customer = customer;
        this.products = products;
        this.deliveryman = deliveryman;
    }

    public boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getID() {
        return ID;
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
