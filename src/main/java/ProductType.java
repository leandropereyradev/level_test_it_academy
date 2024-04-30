public enum ProductType {
    PIZZA("Pizza", 1, 7.9, "Pin"),
    BURRITO("Burrito", 2, 6.5, "Gorra"),
    KEBAB("Kebab", 3, 4.5, ""),
    HAMBURGUER("Hamburguesa", 4, 8.9, "");

    private final String type;
    private final int index;
    private final double price;
    private final String gift;

    ProductType(String type, int index, double price, String gift) {
        this.type = type;
        this.index = index;
        this.price = price;
        this.gift = gift;
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public double getPrice() {
        return price;
    }

    public String getGift() {
        return gift;
    }
}
