package domain.video;

import java.util.Objects;

public class TVShows extends Video {

    String tvShowName;

    public TVShows(Long id, String type, Integer year, String tvShowName) {
        super(id, type, year);
        this.tvShowName = tvShowName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TVShows tvShows = (TVShows) o;
        return Objects.equals(tvShowName, tvShows.tvShowName);
    }

}
