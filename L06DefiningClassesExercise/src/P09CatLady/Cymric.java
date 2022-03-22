package P09CatLady;

public class Cymric extends Cat {
    double furLength;

    public Cymric(String name, double furLength) {
        super("Cymric", name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.furLength);
    }
}
