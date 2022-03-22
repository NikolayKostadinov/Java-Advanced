package P04RawData;

public class Cargo {
    int weight;
    String type;
    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
