package domain;

import domain.audio.Audio;
import domain.printed.Printed;
import domain.video.Video;
import exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Library<T extends Printed, E extends Audio, S extends Video> {

    private static Logger logger = LoggerFactory.getLogger(Library.class);

    List<T> printedCollection = new ArrayList<>();
    List<E> audioCollection = new ArrayList<>();
    List<S> videoCollection = new ArrayList<>();

    public List<T> getPrintedCollection() {
        return printedCollection;
    }

    public List<E> getAudioCollection() {
        return audioCollection;
    }

    public List<S> getVideoCollection() {
        return videoCollection;
    }

    public boolean addItemToPrintedCollection(T t) {
        if (printedCollection.contains(t)) {
            throw new ItemAlreadyInCollectionException("The item to be added is already present in collection ");
        }
        return printedCollection.add(t);
    }

    public boolean addItemToAudioCollection(E e) {
        if (audioCollection.contains(e)) {
            throw new ItemAlreadyInCollectionException("The item to be added is already present in collection ");
        }
        return audioCollection.add(e);
    }

    public boolean addItemToVideoCollection(S s) {
        if (videoCollection.contains(s)) {
            throw new ItemAlreadyInCollectionException("The item to be added is already present in collection ");
        }
        return videoCollection.add(s);
    }

    public boolean removeItemFromPrintedCollection(T t) {
        if (!printedCollection.contains(t)) {
            throw new ItemIsNotPresentException("The item to be deleted is not present in collection");
        }
        return printedCollection.remove(t);
    }

    public boolean removeItemFromAudioCollection(E e) {
        if (!audioCollection.contains(e)) {
            throw new ItemIsNotPresentException("The item to be deleted is not present in collection");
        }
        return audioCollection.remove(e);
    }

    public boolean removeItemFromVideoCollection(S s) {
        if (!videoCollection.contains(s)) {
            throw new ItemIsNotPresentException("The item to be deleted is not present in collection");
        }
        return videoCollection.remove(s);
    }

    public void removeAllItemFromPrintedCollection() {
        printedCollection.clear();
    }

    public void removeAllItemFromAudioCollection() {
        audioCollection.clear();
    }

    public void removeAllItemFromVideoCollection() {
        videoCollection.clear();
    }

    public T getPrintedCollectionById(Long id) {
        return printedCollection.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundPrintedCollectionException("The item  is not found in printed collection"));
    }

    public E getAudioCollectionById(Long id) {
        return audioCollection.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new ItemNotFoundAudioCollectionException("The item  is not found in audio collection"));
    }

    public S getVideoCollectionById(Long id) {
        return videoCollection.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new ItemNotFoundVideoCollectionException("The item  is not found in video collection"));
    }

    public void printPrintedCollectionInfo() {
        logger.info("Printed collection contains: " + printedCollection.size() + " items, where: ");
        IntStream.range(0, printedCollection.size())
                .forEach(i -> logger.info(i + " element : " + printedCollection.get(i).toString()));
    }

    public void printAudioCollection() {
        logger.info("Audio collection contains: " + audioCollection.size() + " items, where: ");
        IntStream.range(0, audioCollection.size())
                .forEach(i -> logger.info(i + " element : " + audioCollection.get(i).toString()));
    }

    public void printVideoCollection() {
        logger.info("Video collection contains: " + videoCollection.size() + " items, where: ");
        IntStream.range(0, videoCollection.size())
                .forEach(i -> logger.info(i + " element : " + videoCollection.get(i).toString()));
    }

    public void printAllCollections() {
        logger.info("Library contains following collections: printed - " + printedCollection.size() +
                " video- " + videoCollection.size() + " audio- " + audioCollection);
    }
}
