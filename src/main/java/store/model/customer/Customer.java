package store.model.customer;

public class Customer {
    private final String NAME;
    private final String ADDRESS;

    public Customer(String name, String address) {
        NAME = name;
        ADDRESS = address;
    }

    @Override
    public String toString() {
        return "Name: " + NAME + '\n' +
                "\tAddress: " + ADDRESS;
    }
}
