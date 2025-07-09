package cap1;
import java.util.Scanner; // Import lớp Scanner để đọc input từ người dùng

public class bai5 {

    /**
     * Trích xuất các chữ cái đầu tiên của mỗi từ trong một chuỗi.
     *
     * @param text Chuỗi đầu vào.
     * @return Một chuỗi chứa các chữ cái đầu tiên của mỗi từ, cách nhau bởi dấu cách.
     * Trả về chuỗi rỗng nếu chuỗi đầu vào null hoặc trống.
     */
    public static String getFirstLetters(String text) {
        if (text == null || text.trim().isEmpty()) {
            return ""; // Trả về chuỗi rỗng nếu không có từ nào
        }

        StringBuilder result = new StringBuilder(); // Sử dụng StringBuilder để xây dựng chuỗi hiệu quả
        String[] words = text.trim().split("\\s+"); // Chia chuỗi thành các từ

        for (String word : words) {
            if (!word.isEmpty()) { // Đảm bảo từ không rỗng sau khi chia (có thể xảy ra với regex phức tạp hơn)
                result.append(word.charAt(0)); // Lấy ký tự đầu tiên của từ
                result.append(" "); // Thêm dấu cách để phân tách các chữ cái
            }
        }

        // Loại bỏ khoảng trắng cuối cùng nếu có
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner

        System.out.println("Vui lòng nhập một chuỗi:");
        String inputString = scanner.nextLine(); // Đọc toàn bộ dòng mà người dùng nhập

        // Xử lý trực tiếp trong main (gọi hàm đã tạo)
        String firstLetters = getFirstLetters(inputString);

        if (firstLetters.isEmpty()) {
            System.out.println("Không có chữ cái đầu nào để hiển thị.");
        } else {
            System.out.println("Các chữ cái đầu tiên của mỗi từ là: " + firstLetters);
        }

        scanner.close(); // Đóng đối tượng Scanner
    }
}