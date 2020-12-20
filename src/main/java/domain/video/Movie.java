package domain.video;

import java.util.Objects;

public class Movie extends Video {

    String movieName;

    public Movie(Long id, String type, Integer year, String movieName) {
        super(id, type, year);
        this.movieName = movieName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieName, movie.movieName);
    }

}
