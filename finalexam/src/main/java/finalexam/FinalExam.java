package finalexam;
import java.io.*;

public class FinalExam {
    public static void main(String[] args) {
        // Correct the path for macOS
        String filePath = System.getProperty("user.home") + "/Desktop/myFile.txt";

        // Read from the file and print to the terminal
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Write a new string to the file without overwriting the existing content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.newLine(); // Add a new line to separate the new string
            writer.write("A new string");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
