package P01WorkingWithAbstraction.P04HotelReservation;

public class P04PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private P04Season season;
    private P04Discount discount;

    public P04PriceCalculator(double pricePerDay, int numberOfDays, P04Season season, P04Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice(){
        return pricePerDay * numberOfDays * season.getMultiplayer() * discount.getPriceReductionFactor();
    }
}
