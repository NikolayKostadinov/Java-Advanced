package P09CatLady;

public class Siamese extends Cat{
    double earSize;
    public Siamese(String name, double earSize) {
        super("Siamese", name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.earSize);
    }
}
