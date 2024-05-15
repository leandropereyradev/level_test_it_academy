package store.model.delivery;

public class Deliveryman {
    private final String NAME;
    private DeliveryMethod method;
    private boolean available = true;

    public Deliveryman(String name) {
        NAME = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setMethod(DeliveryMethod method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "\n\tDelivery name: " + NAME +
                "\n\tDelivery method: " + method.getMETHOD();
    }
}
