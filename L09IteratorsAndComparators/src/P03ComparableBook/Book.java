package P03ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }


    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.getTitle());
        if (result == 0) {
            result = Integer.compare(this.year, o.getYear());
        }
        return result;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
