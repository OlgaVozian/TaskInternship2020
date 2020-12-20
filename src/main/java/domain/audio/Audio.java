package domain.audio;

import domain.common.CommonFeatures;

import java.util.Objects;

public class Audio extends CommonFeatures {

    public Audio(Long id, String type, Integer year) {
        this.id = id;
        this.type = type;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audio audio = (Audio) o;
        return Objects.equals(id, audio.id) &&
                Objects.equals(type, audio.type) &&
                Objects.equals(year, audio.year);
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }
}
