package cap2;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class bai3 {

    /**
     * Xóa các ký tự lặp lại trong chuỗi, chỉ giữ lại ký tự xuất hiện đầu tiên của mỗi loại.
     * Thứ tự của các ký tự còn lại sẽ được bảo toàn.
     *
     * @param text Chuỗi đầu vào.
     * @return Chuỗi mới không chứa ký tự lặp lại. Trả về chuỗi rỗng nếu đầu vào null hoặc trống.
     */
    public static String removeDuplicates(String text) {
        if (text == null || text.isEmpty()) {
            return ""; // Trả về chuỗi rỗng nếu đầu vào null hoặc rỗng
        }

        // LinkedHashSet:
        // - Là một Set (đảm bảo các phần tử là duy nhất).
        // - Là Linked (duy trì thứ tự chèn của các phần tử).
        // Điều này rất quan trọng vì chúng ta muốn giữ lại ký tự xuất hiện đầu tiên
        // và bảo toàn thứ tự của các ký tự không lặp lại.
        Set<Character> seenCharacters = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        // Duyệt qua từng ký tự trong chuỗi
        for (char ch : text.toCharArray()) {
            // Nếu ký tự này chưa từng được thấy (chưa có trong Set)
            if (seenCharacters.add(ch)) { // add() trả về true nếu phần tử được thêm vào (chưa tồn tại)
                result.append(ch); // Thêm ký tự đó vào chuỗi kết quả
            }
            // Nếu ký tự đã có trong Set, add() sẽ trả về false và chúng ta không làm gì cả (bỏ qua nó)
        }

        return result.toString(); // Chuyển StringBuilder thành String và trả về
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner

        System.out.println("Vui lòng nhập một chuỗi:");
        String inputString = scanner.nextLine(); // Đọc toàn bộ dòng mà người dùng nhập

        // Gọi hàm để xóa các ký tự lặp lại
        String stringWithoutDuplicates = removeDuplicates(inputString);

        // In kết quả
        System.out.println("Chuỗi gốc: \"" + inputString + "\"");
        System.out.println("Chuỗi sau khi xóa ký tự lặp lại: \"" + stringWithoutDuplicates + "\"");

        scanner.close(); // Đóng đối tượng Scanner
    }
}