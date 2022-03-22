package P09CatLady;

public class StreetExtraordinaire extends Cat{
    double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super("StreetExtraordinaire", name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.decibelsOfMeows);
    }
}
