import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tilføje sange til listen
 * Fjerne sange 😁😁
 * Finde sange baseret på titel
 * Vise alle sange i listen
 * Interagere med programmet gennem en tekstmenu
 */
public class MusicPlayer {
    Scanner scan = new Scanner(System.in);
    ArrayList<Song> playList = new ArrayList<>();

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.startProgram();




        /**
         * MusicPlayer --> Prompter brugeren for Song
         *
         * PremiumUsers toString uden reklamer // FreeUser toString med reklamer
         * Premium / FreeUser kan ikke tilføje sange
         *
         *
         *
         */

    }


    /**
     * <p>
     *     This is the main entry point of the program
     * </p>
     */
    public void startProgram() {
        System.out.println("**************************************");
        System.out.println("Welcome to your Fake Spotify Service!");
        System.out.println("**************************************");
        System.out.println("Press 1 to add a song.\nPress 2 to delete a song.\nPress 3 to search for a song.\nPress 4 to edit song." +
                "\nPress 5 to clear the playlist.\nPress 6 to play songs.\nPress 7 to end the program.");
        System.out.println("**************************************");

        int userChoice = scan.nextInt();

        switch (userChoice) {
            case 1:
                addSong();
                break;
            case 2:
                deleteSong();
                break;
            case 3:
                searchSong();
                break;
            case 4:
                editSong();
                break;
            case 5:
                clearPlaylist();
                break;
            case 6:
               // playSong();
                // Print all songs
                break;
            case 7:
                endProgram();
                // Exit program
                break;
        }
    }


    public void addSong() {
        String userGenre;
        Genre genreEnum;
        String songTitle;
        // Ask the user for a title
        System.out.println("Please enter the title of the song: ");
        songTitle = scan.next();
        // Ask the user for a genre
        System.out.println("Please enter the genre of the song: ");
        userGenre = scan.next();
        System.out.println(userGenre.toUpperCase());
        // Convert the String to enum
        genreEnum = Genre.valueOf(userGenre);
        // Add the song to the playlist by calling playList.add
        Song userSong = new Song(songTitle, genreEnum);
        playList.add(userSong);
        // Tell the user the song has been added
        System.out.println("Song added with title: " + songTitle + " and genre: " + genreEnum);
        // Testing playsong
        playSong();

    }


    public void playSong() {
        System.out.println(playList.toString());
    };

    public void deleteSong() {
      //  playList.remove();
        // Fjerner på index
    }

    public void clearPlaylist() {
        playList.clear();
        // Fjerner alt på playlisten
    }

    public void editSong () {
        // playList.set();
    }

    public void searchSong() {
        //playList.get();
    }

    public void endProgram() {
        //
    }

}
