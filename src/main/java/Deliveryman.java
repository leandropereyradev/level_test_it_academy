public class Deliveryman {
    private String name;
    private boolean available = true;

    public Deliveryman(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}
