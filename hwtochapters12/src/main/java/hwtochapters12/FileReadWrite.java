package hwtochapters12;
import java.io.*;
import java.util.Scanner;

public class FileReadWrite {
    public static void main(String[] args) {
        String filePath = "my_test_file.txt";
        
        // Read the file content and print it to the Java terminal
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String content;
            while ((content = reader.readLine()) != null) {
                System.out.println("Read from the file: " + content);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file was not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        
        // Get user input from the Java terminal
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the phrase 'Java write test': ");
        String userPhrase = scanner.nextLine();
        
        // Append the new phrase to the file without overwriting the existing content
        try (FileWriter writer = new FileWriter(filePath, true); // 'true' to append data
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bufferedWriter)) {
            out.println(userPhrase);
            System.out.println("Your phrase has been appended to " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}