import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

public class EncodingDecodingGUI extends JFrame {
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JComboBox<String> encodingComboBox;
    private JButton processButton;
    private JButton uploadButton;

    public EncodingDecodingGUI() {
        super("Text Encoder/Decoder");

        inputArea = new JTextArea(10, 40);
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        encodingComboBox = new JComboBox<>(new String[]{"Base64 Encode", "Base64 Decode", "Huffman Encode", "Huffman Decode", "Hexadecimal Encode", "Hexadecimal Decode"});

        processButton = new JButton("Process");
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processText();
            }
        });

        uploadButton = new JButton("Upload File");
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                        StringBuilder text = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            text.append(line).append("\n");
                        }
                        reader.close();
                        inputArea.setText(text.toString());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Input:"));
        panel.add(inputScrollPane);
        panel.add(uploadButton);
        panel.add(encodingComboBox);
        panel.add(processButton);
        panel.add(new JLabel("Output:"));
        panel.add(outputScrollPane);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void processText() {
        String inputText = inputArea.getText();
        String outputText = "";

        String selectedOption = (String) encodingComboBox.getSelectedItem();
        switch (selectedOption) {
            case "Base64 Encode":
                outputText = EncoderDecoder.encodeBase64(inputText);
                break;
            case "Base64 Decode":
                outputText = EncoderDecoder.decodeBase64(inputText);
                break;
            case "Huffman Encode":
                Map<Character, String> codeMap = HuffmanEncoderDecoder.encodeHuffman(inputText);
                StringBuilder encodedText = new StringBuilder();
                for (char c : inputText.toCharArray()) {
                    encodedText.append(codeMap.get(c));
                }
                outputText = encodedText.toString();
                break;
            case "Huffman Decode":
                Map<Character, String> decodeCodeMap = HuffmanEncoderDecoder.encodeHuffman(inputArea.getText());
                outputText = HuffmanEncoderDecoder.decodeHuffman(inputText, decodeCodeMap);
                break;
            case "Hexadecimal Encode":
                outputText = toHex(inputText.getBytes());
                break;
            case "Hexadecimal Decode":
                outputText = fromHex(inputText);
                break;
        }

        outputArea.setText(outputText);
    }

    private String toHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    private String fromHex(String hexString) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexString.length(); i += 2) {
            String str = hexString.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EncodingDecodingGUI();
            }
        });
    }
}

