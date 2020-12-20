package domain.printed;

import java.util.Objects;

public class Book extends Printed {

    String bookName;

    public Book(long id, String type, Integer year, String bookName) {
        super(id, type, year);
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(bookName, book.bookName);
    }

}
