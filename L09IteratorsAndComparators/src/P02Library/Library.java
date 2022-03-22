package P02Library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public Book get(int index) {
        return this.books.get(index);
    }

    public int count() {
        return this.books.size();
    }


    @Override
    public Iterator<Book> iterator() {
        return new Iterator<Book>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < books.size();
            }

            @Override
            public Book next() {
                return books.get(index++);
            }
        };
    }
}
