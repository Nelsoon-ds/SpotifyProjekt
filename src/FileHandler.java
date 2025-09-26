import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    // Global Attributes needed
    public static final String COMMA_DELIMITER = ",";

    // Brug filepath her til brug i metoden saveFile
    public static final String filePath = "something.csv";


    public ArrayList<Song> createPlaylist() {
        ArrayList<Song> playList = new ArrayList<>();
        ArrayList<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("something.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split(COMMA_DELIMITER);

                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].trim();
                }
                records.add(Arrays.asList(values));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (List<String> record : records) {
            String title = record.get(0);
            Genre genre = Genre.valueOf(record.get(1).toUpperCase());
            Song song = new Song(title, genre);
            playList.add(song);
        }
        System.out.println(records);
        return playList;
    }

    // Metode til at oprette en ny fil
    public void createFile(String filename) {
        try {
            File file = new File(filename); // Fil-objekt

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                System.out.println("Absolute path: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists at: " + file.getAbsolutePath());
            }
        } catch(FileNotFoundException e) {
            System.out.println("Could not locate file location.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    // Metode til at write i en  fil
    public void writeFile(String filename) {
        try (FileWriter writer = new FileWriter(filename);){
            // Create a FileWriter (will create file if it does not exist)
            // Write some text to the file
            writer.write("Hello from Java!\n");
            writer.write("This file was created and written using FileWriter.\n");

            // Always close the writer to save changes
            writer.close();

            System.out.println("File created and text written successfully!");

        } catch (IOException e) {
            System.out.println("⚠️ An error occurred: " + e.getMessage());
        }
    }

    public void saveFile(ArrayList<Song> playList) {

        // Get the content that I want to save to my file
        try (FileWriter writer = new FileWriter(filePath)){
            // Create a FileWriter (will create file if it does not exist)
            // Write some text to the file
            for (Song song : playList) {
                writer.write(song.getTitle() + COMMA_DELIMITER + song.getGenre() + "\n");
            }
            // Always close the writer to save changes
            writer.close();

            System.out.println("File created and text written successfully!");

        } catch (IOException e) {
            System.out.println("⚠️ An error occurred: " + e.getMessage());
        }


    }

    public String readFileAsString(String filePath) {
        StringBuilder content = new StringBuilder();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            // Læs filen linje for linje
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("⚠️ File not found: " + e.getMessage());
        }

        return content.toString();
    }


}