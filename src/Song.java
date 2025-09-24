/**
Tilføj dokumentation
 Du kan sætte genre og titel
 Du kan gette genre og titel
 */

public class Song {

    String title;
    Genre genre;


    // Constructor
    public Song(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Genre genre) {
        // Lav en exception handling:
//        try {
//
//        } catch (
//
//        )
//
        this.genre = genre;
    }


    public String getTitle () {
        return this.title;
    }

    public Genre getGenre () {
        return this.genre;
    }


    public String toString() {
        return super.toString();
    }

}
