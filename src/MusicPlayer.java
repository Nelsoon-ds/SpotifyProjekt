import java.util.ArrayList;
import java.util.Scanner;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles.title;

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
        player.editSong();
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

        // userInput --> Scanner

        switch (0) {
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
        boolean isDone = false;

//        while (!isDone) {
//
//            if (userInput.equalsIgnorecase("Finished"))
//
//        }


        // playList.add();
        // Her skal vi bruge vores userinput
    }
    private void fjernSang() {
        System.out.print("Indtast titlen på sangen der skal fjernes: ");
        String titel = scanner.nextLine();

        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).getName().equalsIgnoreCase(titel)) {
                System.out.println("🗑️ Sletning: " + playlist.get(i));
                playlist.remove(i);
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
