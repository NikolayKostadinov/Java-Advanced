package P09CatLady;

public abstract class Cat {
    private String bread;
    private String name;

    public Cat(String bread, String name) {
        this.bread = bread;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.bread + " " + this.name;
    }
}
