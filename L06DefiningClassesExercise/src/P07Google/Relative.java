package P07Google;

public class Relative {
    private String name;
    private String birthDay;

    public Relative(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthDay;
    }
}
