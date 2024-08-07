package edu.neu.mgen;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import java.io.*;

public class Primer Application {
    private TextArea inputTextArea;
    private TextArea outputTextArea;
    private ChoiceBox<String> encodingChoice;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Encoder/Decoder");

        // Input area
        inputTextArea = new TextArea();
        inputTextArea.setPromptText("Enter or upload text here");
        inputTextArea.setWrapText(true);

        Button uploadButton = new Button("Upload File");
        uploadButton.setOnAction(e -> uploadFile(primaryStage));

        // Encoding choice
        encodingChoice = new ChoiceBox<>();
        encodingChoice.getItems().addAll("Hexadecimal", "Base64", "Binary", "Morse Code");
        encodingChoice.setValue("Hexadecimal");

        // Encode and Decode buttons
        Button encodeButton = new Button("Encode");
        encodeButton.setOnAction(e -> encodeText());
        Button decodeButton = new Button("Decode");
        decodeButton.setOnAction(e -> decodeText());

        Button saveButton = new Button("Save Output");
        saveButton.setOnAction(e -> saveOutputToFile(primaryStage));

        HBox encodingBox = new HBox(10, new Label("Encoding:"), encodingChoice, encodeButton, decodeButton, saveButton);
        encodingBox.setPadding(new Insets(10));

        // Output area
        outputTextArea = new TextArea();
        outputTextArea.setPromptText("Result will be shown here");
        outputTextArea.setWrapText(true);
        outputTextArea.setEditable(false);

        // Layout
        VBox layout = new VBox(10, inputTextArea, uploadButton, encodingBox, outputTextArea);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void uploadFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Text File");
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                inputTextArea.setText(text.toString());
                showAlert(Alert.AlertType.INFORMATION, "File Uploaded", "File has been successfully uploaded.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void encodeText() {
        String text = inputTextArea.getText();
        String encodingType = encodingChoice.getValue();
        String encodedText = "";

        switch (encodingType) {
            case "Hexadecimal":
                encodedText = bytesToHex(text.getBytes());
                break;
            case "Base64":
                encodedText = Base64.getEncoder().encodeToString(text.getBytes());
                break;
            case "Binary":
                encodedText = textToBinary(text);
                break;
            case "Morse Code":
                encodedText = textToMorse(text);
                break;
        }

        outputTextArea.setText(encodedText);
    }

    private void decodeText() {
        String text = inputTextArea.getText();
        String encodingType = encodingChoice.getValue();
        String decodedText = "";

        switch (encodingType) {
            case "Hexadecimal":
                decodedText = new String(hexStringToByteArray(text));
                break;
            case "Base64":
                decodedText = new String(Base64.getDecoder().decode(text));
                break;
            case "Binary":
                decodedText = binaryToText(text);
                break;
            case "Morse Code":
                decodedText = morseToText(text);
                break;
        }

        outputTextArea.setText(decodedText);
    }

    private void saveOutputToFile(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Output File");
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.println(outputTextArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexChars = new StringBuilder();
        for (byte aByte : bytes) {
            int v = aByte & 0xFF;
            hexChars.append(HEX_ARRAY[v >>> 4]).append(HEX_ARRAY[v & 0x0F]);
        }
        return hexChars.toString();
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    private static String textToBinary(String text) {
        StringBuilder binary = new StringBuilder();
        for (char c : text.toCharArray()) {
            String binString = Integer.toBinaryString(c);
            while (binString.length() < 8) {
                binString = "0" + binString; // Add leading zeros if needed
            }
            binary.append(binString).append(" "); // Separate each byte with a space
        }
        return binary.toString().trim(); // Remove trailing space
    }

    private static String binaryToText(String binary) {
        StringBuilder text = new StringBuilder();
        String[] binaryBytes = binary.split(" ");
        for (String binByte : binaryBytes) {
            int charCode = Integer.parseInt(binByte, 2);
            text.append((char) charCode);
        }
        return text.toString();
    }

    private static final Map<Character, String> morseCodeMap = new HashMap<>();
    static {
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put(' ', " "); // Space separator
    }

    private static String textToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (morseCodeMap.containsKey(c)) {
                morse.append(morseCodeMap.get(c)).append(" "); // Separate each letter with a space
            }
        }
        return morse.toString().trim(); // Remove trailing space
    }

    private static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] morseWords = morse.split("   "); // Words are separated by 3 spaces in Morse code
        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.split(" ");
            for (String morseLetter : morseLetters) {
                for (Map.Entry<Character, String> entry : morseCodeMap.entrySet()) {
                    if (entry.getValue().equals(morseLetter)) {
                        text.append(entry.getKey());
                        break;
                    }
                }
            }
            text.append(" "); // Space between words
        }
        return text.toString().trim(); // Remove leading and trailing spaces
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
