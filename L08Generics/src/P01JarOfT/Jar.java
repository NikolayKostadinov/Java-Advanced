package P01JarOfT;
import java.util.ArrayDeque;

public class Jar <T>{
    private final ArrayDeque<T> jarStack;

    public Jar() {
        this.jarStack = new ArrayDeque<> ();
    }

    public void add(T element){
        this.jarStack.push(element);
    }

    public T remove (){
        return this.jarStack.pop();
    }
}
