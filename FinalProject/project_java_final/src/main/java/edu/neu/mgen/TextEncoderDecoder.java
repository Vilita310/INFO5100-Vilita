package edu.neu.mgen;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import java.io.*;
import java.util.Base64;

public class TextEncoderDecoder extends Application {
    private TextArea inputTextArea;
    private TextArea outputTextArea;
    private ChoiceBox<String> encodingChoice;
    private String uploadedText;

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
        encodingChoice.getItems().addAll("Hexadecimal", "Base64");
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
                uploadedText = text.toString();
                inputTextArea.clear(); // Clear the input text area to hide the uploaded content
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void encodeText() {
        String text = (uploadedText != null && !uploadedText.isEmpty()) ? uploadedText : inputTextArea.getText();
        String encodingType = encodingChoice.getValue();
        String encodedText = "";

        switch (encodingType) {
            case "Hexadecimal":
                encodedText = bytesToHex(text.getBytes());
                break;
            case "Base64":
                encodedText = Base64.getEncoder().encodeToString(text.getBytes());
                break;
        }

        outputTextArea.setText(encodedText);
    }

    private void decodeText() {
        String text = (uploadedText != null && !uploadedText.isEmpty()) ? uploadedText : inputTextArea.getText();
        String encodingType = encodingChoice.getValue();
        String decodedText = "";

        switch (encodingType) {
            case "Hexadecimal":
                decodedText = new String(hexStringToByteArray(text));
                break;
            case "Base64":
                decodedText = new String(Base64.getDecoder().decode(text));
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
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = HEX_ARRAY[v >>> 4];
            hexChars[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
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
}

