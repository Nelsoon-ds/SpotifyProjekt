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

    /**
     * <p>
     *     This is the main entry point of the program
     * </p>
     */
    public void startProgram() {
        // Initialize variables
        boolean isDone = false;
        printMenu();

        while (!isDone) {
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
                break;
            case 7:
                isDone = true;
                endProgram();
                break;
        }
            }
    }

    public void playSong() {
        // skal have brugerens input til at vælge en sang
        printPlaylist();
        System.out.println("Choose a song to play: ");
        int userInput = scan.nextInt();
        // To ensure it doesent eat up
        scan.nextLine();
        System.out.println(playList.get(userInput));
        // print menuen for at få brugeren tilbage
        printMenu();
    }

    public void printPlaylist() {
        System.out.println("*****************");
        System.out.println("Songlist");
        System.out.println("*****************");
        for (int i = 0; i < playList.size(); i++) {
            System.out.println("ID:" + i + "\n" + playList.get(i));
        }
        System.out.println("**************** ");
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
        try {
            // Convert the String to enum
            genreEnum = Genre.valueOf(userGenre.toUpperCase());
            // Add the song to the playlist by calling playList.add
            Song userSong = new Song(songTitle, genreEnum);
            playList.add(userSong);
            // Tell the user the song has been added
            System.out.println("Song added with title: " + songTitle + " and genre: " + genreEnum);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid genre entered. Please try again with a valid genre.");
        }
        printMenu();

    }
    private void deleteSong() {
        System.out.print("Insert the tile of the song that should be removed: ");
        String title = scan.nextLine();


        boolean removed = playList.removeIf(song -> song.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println(title + " was removed from the playlist.") ;
            }
        else {
            System.out.println(title + " was not found on the playlist.");
            }

    }



    public void clearPlaylist() {
       // playList.clear();
        // Fjerner alt på playlisten
    }

    public void editSong () {
        // Vælg nummeret på den plads det skal ændres
        System.out.println("Choose the number of the song in the playlist you want to edit: ");
        int numberInPlaylist = scan.nextInt();
        scan.nextLine();
        System.out.println("What is the title of the new song? ");
        String titleOfSong = scan.nextLine();
        System.out.println(numberInPlaylist);

        try {
            System.out.println("What is the genre of the new song? ");
            String genreInput = scan.nextLine().toUpperCase();
            Genre genreOfSong = Genre.valueOf(genreInput);
            Song newSong = new Song(titleOfSong,genreOfSong);
            playList.set(numberInPlaylist, newSong);
            System.out.println("Your song " + titleOfSong + " has been added to #" + numberInPlaylist  + " spot on your playlist" );

        } catch (IllegalArgumentException e) {
            System.out.println("Not eligible genre");
        }


        // playList.set();
    }
    public void searchSong() {
        //playList.get();
    }
    public void endProgram() {
        System.exit(0) ;
    }

    public void printMenu() {
        System.out.println("**************************************");
        System.out.println("Welcome to your Fake Spotify Service!");
        System.out.println("**************************************");
        System.out.println("Press 1 to add a song.\nPress 2 to delete a song.\nPress 3 to search for a song.\nPress 4 to edit song." +
                "\nPress 5 to clear the playlist.\nPress 6 to play songs.\nPress 7 to end the program.");
        System.out.println("**************************************");
    }
}
