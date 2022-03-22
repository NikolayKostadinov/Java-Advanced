package P02GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class ArrayCreator {
    public static <T> T[] create(int length, T defaultValue) {
        return create(defaultValue.getClass(), length, defaultValue);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> clazz, int length, T defaultValue) {
        T[] arr = (T[]) Array.newInstance(clazz, length);
        IntStream.range(0, length).forEach(i -> arr[i] = defaultValue);
        return arr;
    }
}
