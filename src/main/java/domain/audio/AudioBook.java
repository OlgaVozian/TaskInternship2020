package domain.audio;

import java.util.Objects;

public class AudioBook extends Audio {

    String audioBookName;

    public AudioBook(Long id, String type, Integer year, String audioBookName) {
        super(id, type, year);
        this.audioBookName = audioBookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AudioBook audioBook = (AudioBook) o;
        return Objects.equals(audioBookName, audioBook.audioBookName);
    }

}
