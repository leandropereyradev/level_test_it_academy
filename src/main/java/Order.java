import java.util.List;

public class Order {
    private static int lastAssignedID;
    private final int ID;
    private final Customer CUSTOMER;
    private final List<Product> PRODUCTS;
    private final Deliveryman DELIVERYMAN;
    private boolean delivered;
    private final double SUBTOTAL;
    private final double TOTAL_PRICE;

    public Order(
            Customer customer,
            List<Product> products,
            Deliveryman deliveryman,
            double subtotal,
            double total_price
    ) {
        lastAssignedID++;
        ID = lastAssignedID;

        CUSTOMER = customer;
        PRODUCTS = products;
        DELIVERYMAN = deliveryman;
        SUBTOTAL = subtotal;
        TOTAL_PRICE = total_price;
    }

    public boolean getDeliveryStatus() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getID() {
        return ID;
    }

    public Deliveryman getDELIVERYMAN() {
        return DELIVERYMAN;
    }

    @Override
    public String toString() {
        return "\nOrder # " + ID + ": " +
                "\n\t" + CUSTOMER + "\n" +
                "\n\tProducts: " + PRODUCTS +
                "\n\t" + DELIVERYMAN +
                "\n\tDelivered: " + (delivered ? "delivered" : "undelivered") +
                "\n\n\tSubtotal: " + String.format("%.2f", SUBTOTAL) + "€" +
                "\n\tDelivery cost: " + String.format("%.2f", TOTAL_PRICE - SUBTOTAL) + "€" +
                "\n\n\tTotal price: " + String.format("%.2f", TOTAL_PRICE) + "€";
    }
}
