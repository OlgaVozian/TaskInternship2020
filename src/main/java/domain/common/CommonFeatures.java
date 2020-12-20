package domain.common;

public abstract class CommonFeatures {
    public Long id;
    public String type;
    public Integer year;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Integer getYear() {
        return year;
    }
}
