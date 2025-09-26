import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {
    // Required Objects
    FileHandler fh = new FileHandler();
    Scanner scan = new Scanner(System.in);
    // User session
    private User currentUser;
    // Creates a playlist from our filehandler
    // Currently it grabs a playlist.csv file from the src directory
    ArrayList<Song> playList = fh.createPlaylist();

    /**
     * <p>
     * This is the main entry point of the MusicPlayer program.
     * </p>
     * <p>
     * It creates a {@link MusicPlayer} instance and starts the program
     * by calling the {@link #startProgram()} method.
     * </p>
     * <p>
     * The pr   ogram's core functionality is managed through a menu-driven interface,
     * allowing users to interact with a playlist of songs. The primary methods called
     * in a typical session include:
     * <ul>
     * <li>{@link #testSongs()} - Adds a predefined list of songs for testing.</li>
     * <li>{@link #startProgram()} - Initiates the main program loop and menu.</li>
     * <li>{@link #chooseUser()} - Prompts the user to select their account type (Free or Premium).</li>
     * <li>{@link #printHomeMenu()} - Displays the main menu options.</li>
     * </ul>
     * Depending on the user's choice, it will call other methods like {@link #addSong()},
     * {@link #deleteSong()}, {@link #searchSong()}, {@link #editSong()}, {@link #clearPlaylist()},
     * and {@link #playSong()}.
     * </p>
     *
     * @param args Command-line arguments.
     * @see #startProgram()
     * @see #testSongs()
     * @see #addSong()
     * @see #deleteSong()
     * @see #playSong()
     */
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.startProgram();
    }



    public void startProgram() {
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
                showAllSongs();
                break;
            case 8:
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
            System.out.println("Playing song: " + playList.get(userInput).title);

            for (Song song : playList) {
                if (song.getTitle().equalsIgnoreCase(song.title)){
                    if (currentUser.hasAds()){
                        System.out.println("!ADDS! Upgrade to preimium");
                    }
                }
            }
            // print menuen for at få brugeren tilbage
        } catch (IndexOutOfBoundsException e) {
            System.out.print("Invalid input.");
        }
    }

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
        System.out.println("What is the title of the song you want to find?");
        String titleOfSong = scan.nextLine().trim();

        boolean found = false;

        for (Song s : playList) {
            if (s.getTitle().trim().equalsIgnoreCase(titleOfSong)) {
                System.out.println("Sangen " + s.getTitle() + " " + s.getGenre() + " blev fundet");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Your song coulnd't be found.");
        }
    }
    public void showAllSongs() {
        if (playList.isEmpty()){
            System.out.println("Your playlist is empty");
            return;
        }
        System.out.println("Your songs: ");
        for (Song song : playList) {
            System.out.println("- " + song);
        }
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
                "\nPress 5 to clear the playlist.\nPress 6 to play songs.\nPress 7 show all songs.\nPress 8 to end program.");
        System.out.println("**************************************");
    }

    public void createNewPlaylist(){
        fh.createPlaylist();
    }


    public void testSongs() {
        Song s1 = new Song("Dior", Genre.ROCK);
        Song s2 = new Song("Lost", Genre.POP);
        Song s3 = new Song("Westworld", Genre.TECHNO);
        Song s4 = new Song("F THA POLICE", Genre.RAP);
        Song s5 = new Song("Bohemian Rhapsody", Genre.ROCK);
        Song s6 = new Song("Keyboard", Genre.JAZZ);
        Song s7 = new Song("Für Elise", Genre.CLASSIC);
        playList.add(s1);
        playList.add(s2);
        playList.add(s3);
        playList.add(s4);
        playList.add(s5);
        playList.add(s6);
        playList.add(s7);
    }
}
