
package cap1;
import java.util.Scanner; 
public class bai4 {

    /**
     * Đếm số từ trong một chuỗi.
     * Các từ được phân tách bởi một hoặc nhiều khoảng trắng.
     *
     * @param text Chuỗi đầu vào.
     * @return Số lượng từ trong chuỗi.
     */
    public static int countWords(String text) {
        // Kiểm tra xem chuỗi có rỗng hoặc chỉ chứa khoảng trắng không
        if (text == null || text.trim().isEmpty()) {
            return 0; // Trả về 0 nếu không có từ nào
        }

        // Sử dụng phương thức split để chia chuỗi thành các từ dựa trên khoảng trắng.
        // \\s+ nghĩa là một hoặc nhiều ký tự khoảng trắng (space, tab, newline, v.v.).
        String[] words = text.trim().split("\\s+");

        // Số lượng phần tử trong mảng chính là số từ
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner

        System.out.println("Vui lòng nhập một chuỗi để đếm số từ:");
        String inputString = scanner.nextLine(); // Đọc toàn bộ dòng mà người dùng nhập

        int wordCount = countWords(inputString); // Gọi hàm để đếm từ
        System.out.println("Số từ trong chuỗi là: " + wordCount);

        scanner.close(); // Đóng đối tượng Scanner
    }
}