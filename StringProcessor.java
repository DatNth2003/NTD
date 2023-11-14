import java.util.HashMap;
import java.util.Map;

public class StringProcessor {
    private String inputString;

    public StringProcessor(String inputString) {
        this.inputString = inputString;
    }
  // Chuyển đổi sang chữ hoa
    public String toUpperCase() {
        return inputString.toUpperCase();
    }

    // Chuyển đổi sang chữ thường
    public String toLowerCase() {
        return inputString.toLowerCase();
    }

    // Đảo ngược chuỗi
    public String reverseString() {
        return new StringBuilder(inputString).reverse().toString();
    }

    // Tìm kiếm chuỗi con và trả về vị trí đầu tiên
    public int findSubstring(String substring) {
        return inputString.indexOf(substring);
    }

    // Trích xuất chuỗi con từ vị trí đầu đến cuối
    public String extractSubstring(int start, int end) {
        if (start < 0 || end > inputString.length() || start > end) {
            return ""; // hoặc có thể ném một ngoại lệ (Exception) tùy theo yêu cầu của bạn
        }
        return inputString.substring(start, end);
    }

    // Thay thế chuỗi con trong chuỗi
    public String replaceSubstring(String oldSubstring, String newSubstring) {
        return inputString.replace(oldSubstring, newSubstring);
    }

    // Kiểm tra chuỗi có phải là chuỗi đối xứng hay không
    public boolean isPalindrome() {
        // Loại bỏ khoảng trắng và chuyển đổi sang chữ thường để kiểm tra chuỗi đối xứng
        String processedString = inputString.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = processedString.length() - 1;

        while (left < right) {
            if (processedString.charAt(left) != processedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Đếm số lượng từ trong chuỗi
    public int countWords() {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        String[] words = inputString.split("\\s+");
        return words.length;
    }

    // Đếm tần suất xuất hiện của mỗi ký tự trong chuỗi
    public Map<Character, Integer> characterFrequency() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }
        return frequencyMap;
    }
    
  // Getter, setter cho inputString
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
    
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor("Java mãi đỉnh! xD");
        System.out.println("Original String: " + processor.getInputString());
        System.out.println("Is Palindrome? " + processor.isPalindrome());
        System.out.println("Number of Words: " + processor.countWords());
        System.out.println("Character Frequency: " + processor.characterFrequency());
    }
}
