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

        switch (userInputInt) {
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

    public void deleteSong(Scanner scanner) {
        System.out.print("Name the song you wise to remove: ");
        String title = scanner.nextLine();

        boolean removed = false;

        //Fjerne sang fra PremiumPlayliste
        for (int i = 0; i < premiumPlaylist.size(); i++)
            if (premiumPlaylist.get(i).getName().equalsIgnoreCase(title)) {
                premiumPlaylist.remove(i);
                System.out.println("Sangen: " + title + " er fjernet fra din playliste");
                removed = true;
                break;
            }

        }

        if (!removed)

    {

        System.out.println("Sangen med titlen: " + title + " blev ikke fundet")

    }

    }


    public void clearPlaylist() {
       // playList.clear();
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
