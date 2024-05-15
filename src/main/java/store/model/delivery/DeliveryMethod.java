package store.model.delivery;

public enum DeliveryMethod {
    MOTORCYCLE(1, "Motorcycle", 1.02, "2%"),
    BICYCLE(2, "Bicycle", 1.01, "1%"),
    FOOT(3, "Foot", 1, "No shipping cost");

    private final int OPTION;
    private final String METHOD;
    private final double EXTRA;
    private final String PERCENTAGE;

    DeliveryMethod(int option, String method, double extra, String percentage) {
        OPTION = option;
        METHOD = method;
        EXTRA = extra;
        PERCENTAGE = percentage;
    }

    public int getOPTION() {
        return OPTION;
    }

    public String getMETHOD() {
        return METHOD;
    }

    public double getEXTRA() {
        return EXTRA;
    }

    public String getPERCENTAGE() {
        return PERCENTAGE;
    }
}
