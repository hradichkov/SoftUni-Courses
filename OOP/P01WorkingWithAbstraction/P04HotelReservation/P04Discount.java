package P01WorkingWithAbstraction.P04HotelReservation;

public enum P04Discount {
    VIP(0.80),
    SECOND_VISIT(0.90),
    NONE(1);

    private double priceReductionFactor;

    P04Discount(double priceReductionFactor) {
        this.priceReductionFactor = priceReductionFactor;
    }

    public double getPriceReductionFactor() {
        return priceReductionFactor;
    }

    public static P04Discount parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value " + str);
        }
    }
}
