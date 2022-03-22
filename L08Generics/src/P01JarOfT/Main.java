package P01JarOfT;

import L08Generics.P01JarOfT.Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(2);
        jar.add(3);

        System.out.println(jar.remove());
        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
