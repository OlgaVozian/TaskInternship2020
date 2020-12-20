package domain.printed;

import domain.common.CommonFeatures;

import java.util.Objects;

public class Printed extends CommonFeatures {

    public Printed(long id, String type, Integer year) {
        this.id = id;
        this.type = type;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Printed printed = (Printed) o;
        return id == printed.id &&
                Objects.equals(type, printed.type) &&
                Objects.equals(year, printed.year);
    }

    @Override
    public String toString() {
        return "Printed{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }
}
