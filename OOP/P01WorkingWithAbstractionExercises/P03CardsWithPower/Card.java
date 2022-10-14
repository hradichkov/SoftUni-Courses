package P01WorkingWithAbstractionExercises.P03CardsWithPower;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    public int getPower(){
        return rank.getRankPower() + suit.getSuitPower();
    }
}
