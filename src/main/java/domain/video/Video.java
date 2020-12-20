package domain.video;

import domain.common.CommonFeatures;

import java.util.Objects;

public class Video extends CommonFeatures {

    public Video(Long id, String type, Integer year) {
        this.id = id;
        this.type = type;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(id, video.id) &&
                Objects.equals(type, video.type) &&
                Objects.equals(year, video.year);
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }
}
