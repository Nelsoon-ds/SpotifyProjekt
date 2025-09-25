import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

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

        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    // Metode til at write i en  fil
    public void writeFile(String filename) {
        try {
            // Create a FileWriter (will create file if it does not exist)
            FileWriter writer = new FileWriter(filename);
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