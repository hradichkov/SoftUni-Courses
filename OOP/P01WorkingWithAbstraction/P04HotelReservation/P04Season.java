package P01WorkingWithAbstraction.P04HotelReservation;

public enum P04Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multiplayer;

    P04Season(int multiplayer) {
        this.multiplayer = multiplayer;
    }

    public int getMultiplayer() {
        return multiplayer;
    }

    public static P04Season parse(String str){
        return P04Season.valueOf(str.toUpperCase());
    }
}
