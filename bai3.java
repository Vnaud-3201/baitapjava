package cap3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bai3 {

    public String minWindow(String s, String t) {
        if (t == null || t.isEmpty()) {
            return "";
        }
        if (s == null || s.isEmpty()) {
            return "";
        }

        // Bản đồ tần suất ký tự cho chuỗi t
        Map<Character, Integer> targetChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetChars.put(c, targetChars.getOrDefault(c, 0) + 1);
        }

        // Bản đồ tần suất ký tự trong cửa sổ hiện tại
        Map<Character, Integer> windowChars = new HashMap<>();

        int left = 0;
        int matchedChars = 0; // Số lượng ký tự của t đã khớp trong cửa sổ
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);
            windowChars.put(charRight, windowChars.getOrDefault(charRight, 0) + 1);

            // Nếu ký tự hiện tại là một trong các ký tự chúng ta cần từ 't'
            // và số lượng của nó trong cửa sổ vẫn chưa vượt quá số lượng cần thiết
            if (targetChars.containsKey(charRight) && windowChars.get(charRight) <= targetChars.get(charRight)) {
                matchedChars++;
            }

            // Khi tất cả các ký tự của 't' đã được khớp trong cửa sổ hiện tại
            while (matchedChars == t.length()) {
                // Cập nhật độ dài nhỏ nhất và vị trí bắt đầu
                int currentWindowLen = right - left + 1;
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIndex = left;
                }

                char charLeft = s.charAt(left);
                windowChars.put(charLeft, windowChars.get(charLeft) - 1);

                // Nếu ký tự bị loại bỏ là một phần của 't'
                // và số lượng của nó trong cửa sổ trở nên ít hơn số lượng cần thiết
                if (targetChars.containsKey(charLeft) && windowChars.get(charLeft) < targetChars.get(charLeft)) {
                    matchedChars--;
                }

                left++; // Thu hẹp cửa sổ từ bên trái
            }
        }

        if (startIndex == -1) {
            return ""; // Không tìm thấy chuỗi con nào
        } else {
            return s.substring(startIndex, startIndex + minLen);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi s: ");
        String s = scanner.nextLine();

        System.out.print("Nhập chuỗi t: ");
        String t = scanner.nextLine();

        bai3 solver = new bai3();
        String result = solver.minWindow(s, t);

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy chuỗi con chứa tất cả các ký tự của '" + t + "'.");
        } else {
            System.out.println("Chuỗi con nhỏ nhất chứa tất cả các ký tự của '" + t + "' là: \"" + result + "\"");
        }

        scanner.close();
    }
}
