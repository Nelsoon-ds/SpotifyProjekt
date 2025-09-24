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
    ArrayList<Song> playList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

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

    // 0 Diskuter flowet af programmet
    // 1 UML-Diagram
    // 2 Fyld metoderne ud


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
               playSong();
                // Print all songs
                break;
            case 7:
                endProgram();
                // Exit program
                break;
        }
    }

    public void playSong() {
        System.out.println(playList.toString());
    };

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
    }
    private void deleteSong() {
        System.out.print("Indtast titlen på sangen der skal fjernes: ");
        String titel = scan.nextLine();

        for (int i = 0; i < playList.size(); i++) {
            if (playList.get(i).getTitle().equalsIgnoreCase(titel)) {
                System.out.println("🗑️ Sletning: " + playList.get(i));
                playList.remove(i);
                System.out.println("✅ Sangen er fjernet.");
                return;
            }
        }
        System.out.println("🚫 Sangen blev ikke fundet.");
    }


    public void clearPlaylist() {
       // playList.clear();
        // Fjerner alt på playlisten
    }

    public void editSong () {
        System.out.println("Choose the number of the song in the playlist you want to edit: ");
        int numberInPlaylist = scan.nextInt() - 1;
        scan.nextLine();
        System.out.println("What is the title of the new song? ");
        String titleOfSong = scan.nextLine();
        System.out.println("What is the genre of the new song? ");
        String genreInput = scan.nextLine().toUpperCase();
        Genre genreOfSong = Genre.valueOf(genreInput);
        Song newSong = new Song(titleOfSong,genreOfSong);
        playList.set(numberInPlaylist, newSong);
        System.out.println("Your song " + titleOfSong + " has been added to #" + numberInPlaylist + 1 + " spot on your playlist" );
        // playList.set();
    }
    public void searchSong() {
        //playList.get();
    }
    public void endProgram() {
        //
    }
}
