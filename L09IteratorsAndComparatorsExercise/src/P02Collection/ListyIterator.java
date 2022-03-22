package P02Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator<String>, Iterable<String> {
    private static int currentIndex = 0;
    private final List<String> list;

    public ListyIterator(List<String> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return this.list.size() - 1 > currentIndex;
    }

    @Override
    public String next() {
        return this.list.get(currentIndex++);
    }

    public boolean Move(){
        boolean result = this.hasNext();
        if (result) {
            currentIndex++;
        }
        return result;
    }

    public void print(){
        if (this.list.isEmpty()) throw new IllegalStateException("Invalid Operation!");
        System.out.println(this.list.get(currentIndex));
    }

    public void printAll() {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }
}
