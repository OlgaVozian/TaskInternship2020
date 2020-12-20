package domain;

import domain.audio.Audio;
import domain.audio.AudioBook;
import domain.audio.Songs;
import domain.printed.Book;
import domain.printed.Magazine;
import domain.printed.Printed;
import domain.video.Movie;
import domain.video.TVShows;
import domain.video.Video;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LibraryTest {

    @Test
    void testLibrary() {
        Library library = new Library();

        Audio audioBook = new AudioBook(1l, "mp3", 2020, "Learn automation testing");
        Audio song = new Songs(2l, "mp3", 2020, "Flying to the sky");
        Printed book = new Book(1l, "IT", 2020, "DBA for dummies");
        Printed magazine = new Magazine(2l, "IT", 2020, "Magazine1");
        Video movie = new Movie(1l, "video type", 2020, "movieName1");
        Video tvShows = new TVShows(2l, "some tvShows", 2020, "showName");

        library.addItemToAudioCollection(audioBook);
        library.addItemToAudioCollection(song);

        library.addItemToPrintedCollection(book);
        library.addItemToPrintedCollection(magazine);

        library.addItemToVideoCollection(movie);
        library.addItemToVideoCollection(tvShows);

        Assertions.assertEquals(List.of(audioBook, song), library.getAudioCollection());
        Assertions.assertEquals(List.of(book, magazine), library.getPrintedCollection());
        Assertions.assertEquals(List.of(movie, tvShows), library.getVideoCollection());

        Assertions.assertEquals(audioBook, library.getAudioCollectionById(1l));
        Assertions.assertEquals(magazine, library.getPrintedCollectionById(2l));
        Assertions.assertEquals(movie, library.getVideoCollectionById(1l));

        Assertions.assertEquals(2, library.getAudioCollection().size());
        library.removeItemFromAudioCollection(audioBook);
        Assertions.assertEquals(1, library.getAudioCollection().size());

        Assertions.assertEquals(2, library.getVideoCollection().size());
        library.removeAllItemFromVideoCollection();
        Assertions.assertEquals(0, library.getVideoCollection().size());
    }
}
