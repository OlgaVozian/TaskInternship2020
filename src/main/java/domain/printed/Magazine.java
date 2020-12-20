package domain.printed;

import java.util.Objects;

public class Magazine extends Printed {

    String magazineName;

    public Magazine(long id, String type, Integer year, String magazineName) {
        super(id, type, year);
        this.magazineName = magazineName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(magazineName, magazine.magazineName);
    }

}
