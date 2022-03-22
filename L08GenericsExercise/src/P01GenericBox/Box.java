package P01GenericBox;

public class Box <T>{
    T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String className = this.value.getClass().getName();
        return String.format("%s: %s", className, value);
    }
}
