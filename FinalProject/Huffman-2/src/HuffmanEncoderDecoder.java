import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}

public class HuffmanEncoderDecoder {
    public static Map<Character, String> encodeHuffman(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            pq.offer(parent);
        }

        HuffmanNode root = pq.poll();
        Map<Character, String> codeMap = new HashMap<>();
        generateCodes(root, "", codeMap);
        return codeMap;
    }

    private static void generateCodes(HuffmanNode node, String code, Map<Character, String> codeMap) {
        if (node == null)
            return;
        if (node.data != '\0') {
            codeMap.put(node.data, code);
        }
        generateCodes(node.left, code + "0", codeMap);
        generateCodes(node.right, code + "1", codeMap);
    }

    public static String decodeHuffman(String encodedText, Map<Character, String> codeMap) {
        StringBuilder decodedText = new StringBuilder();
        StringBuilder code = new StringBuilder();
        for (char c : encodedText.toCharArray()) {
            code.append(c);
            for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
                if (entry.getValue().equals(code.toString())) {
                    decodedText.append(entry.getKey());
                    code.setLength(0);
                    break;
                }
            }
        }
        return decodedText.toString();
    }
}
