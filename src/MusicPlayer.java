import java.util.ArrayList;
import java.util.Scanner;
/**
 * Tilføje sange til listen
 * Fjerne sange
 * Finde sange baseret på titel
 * Vise alle sange i listen
 * Interagere med programmet gennem en tekstmenu
 */
public class MusicPlayer {
    ArrayList<Song> playList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    private User currentUser;

    Song s1 = new Song("Dior", Genre.ROCK);
    Song s2 = new Song("Lost", Genre.POP);
    Song s3 = new Song("Westworld", Genre.TECHNO);
    Song s4 = new Song("F THA POLICE", Genre.RAP);
    Song s5 = new Song("Bohemian Rhapsody", Genre.ROCK);
    Song s6 = new Song("Keyboard", Genre.JAZZ);
    Song s7 = new Song("Für Elise", Genre.CLASSIC);

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.testSongs();
        player.startProgram();
    }



    /**
     * <p>
     *     This is the main entry point of the program
     * </p>
     */
    public void startProgram() {
        // Vores test sange
        // Initialize variables
        boolean isDone = false;
        chooseUser();

        while (!isDone) {
            printHomeMenu();
            int userChoice = scan.nextInt();
            scan.nextLine();
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

    private void chooseUser() {
        System.out.print("Enter your username: ");
        String username = scan.nextLine();

        System.out.print("Are you a Premium-user (yes/no): ");
        String userResponse = scan.next().toLowerCase();

        if (userResponse.equals("yes")) {
            currentUser = new PremiumUser(username, true);
        } else {
            currentUser = new FreeUser(username, false);
        }
        System.out.println("Logged in as: " + currentUser);
    }


    /**
     * @author Heya <br>
     * <b>Precondition:</b> <p>Prompts user for song ID</p>
     * <b>Postcondition:</b> <p>Plays the song at index song</p>
     * @throws IndexOutOfBoundsException
     */
    public void playSong() {
        // skal have brugerens input til at vælge en sang
        try {
            // Hvis playlisten er tom skal du tilbage
            if (playList.isEmpty()) {
                System.out.println("Your playlist is empty.");
                return;
            }
            printPlaylist();
            System.out.println("Choose a song to play: ");
        int userInput = scan.nextInt();
        // To ensure it doesent eat up
        scan.nextLine();
        System.out.println(playList.get(userInput));
        // print menuen for at få brugeren tilbage
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid input.");
        }
    }

    /**
     * <b>Pri</b>
     */
    public void printPlaylist() {
        System.out.println("Songlist");
        System.out.println("*****************");
        for (int i = 0; i < playList.size(); i++) {
            System.out.println("ID:" + i + "\n" + playList.get(i));
        }
    }

    public void addSong() {
       // Hvis brugeren ikke er premium så gå tilbage til menuen.
        if (!currentUser.canAddSongs()) {
            return;
        }
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
    }
    private void deleteSong() {
        printPlaylist();
        System.out.print("Choose the number of the song on the playlist, you want to remove.");
        int songId = scan.nextInt();
        scan.nextLine();

        try {
            playList.remove(songId);
            System.out.println("The song with ID #" + songId + " was removed.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid input.");
        } catch(IllegalArgumentException e) {
            System.out.println("This song doesn't exist.");

        }
    }


    public void clearPlaylist() {
         playList.clear();
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
    }

    public void searchSong() {
        //playList.get();
    }
    /*
    Skal den ikke bare gemme vores playlist
     */
    public void endProgram() {
        System.exit(0) ;
    }

    public void printHomeMenu() {
        System.out.println();
        System.out.println("Welcome to your Fake Spotify Service!");
        System.out.println("**************************************");
        System.out.println("Press 1 to add a song.\nPress 2 to delete a song.\nPress 3 to search for a song.\nPress 4 to edit song." +
                "\nPress 5 to clear the playlist.\nPress 6 to play songs.\nPress 7 to end the program.");
        System.out.println("**************************************");
    }

    public void testSongs() {
        playList.add(s1);
        playList.add(s2);
        playList.add(s3);
        playList.add(s4);
        playList.add(s5);
        playList.add(s6);
        playList.add(s7);
    }
}
