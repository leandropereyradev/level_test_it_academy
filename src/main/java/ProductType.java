public enum ProductType {
    PIZZA("Pizza", 1, 7.9, "Pin"),
    BURRITO("Burrito", 2, 6.5, "Gorra"),
    KEBAB("Kebab", 3, 4.5, ""),
    HAMBURGUER("Hamburguesa", 4, 8.9, "");

    private final String TYPE;
    private final int INDEX;
    private final double PRICE;
    private final String GIFT;

    ProductType(String type, int index, double price, String gift) {
        this.TYPE = type;
        this.INDEX = index;
        this.PRICE = price;
        this.GIFT = gift;
    }

    public String getType() {
        return TYPE;
    }

    public int getIndex() {
        return INDEX;
    }

    public double getPrice() {
        return PRICE;
    }

    public String getGift() {
        return GIFT;
    }
}
