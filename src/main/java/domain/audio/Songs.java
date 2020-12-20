package domain.audio;

import java.util.Objects;

public class Songs extends Audio {

    String songName;

    public Songs(Long id, String type, Integer year, String songName) {
        super(id, type, year);
        this.songName = songName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Songs songs = (Songs) o;
        return Objects.equals(songName, songs.songName);
    }

}
