package cap2;

import java.util.Scanner; // Import lớp Scanner để đọc input từ người dùng

public class bai2 {

    /**
     * Kiểm tra xem một chuỗi có phải là chuỗi đối xứng (palindrome) không.
     * Hàm này bỏ qua khoảng trắng và không phân biệt chữ hoa, chữ thường.
     *
     * @param text Chuỗi đầu vào.
     * @return true nếu chuỗi là đối xứng, false nếu không.
     */
    public static boolean isPalindrome(String text) {
        // Xử lý trường hợp chuỗi null hoặc rỗng
        if (text == null || text.trim().isEmpty()) {
            return true; // Một chuỗi rỗng hoặc chỉ chứa khoảng trắng được coi là palindrome
        }

        // 1. Chuẩn hóa chuỗi:
        //    - Chuyển tất cả về chữ thường để không phân biệt hoa/thường.
        //    - Loại bỏ tất cả các ký tự không phải chữ cái hoặc số (nếu cần, ở đây chỉ loại bỏ khoảng trắng).
        //    Cách đơn giản nhất: loại bỏ khoảng trắng và chuyển về chữ thường.
        String cleanedText = text.toLowerCase().replaceAll("\\s+", "");

        // 2. Kiểm tra đối xứng
        int left = 0;
        int right = cleanedText.length() - 1;

        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false; // Nếu có bất kỳ cặp ký tự nào không khớp, không phải palindrome
            }
            left++;  // Di chuyển con trỏ trái sang phải
            right--; // Di chuyển con trỏ phải sang trái
        }

        return true; // Nếu vòng lặp kết thúc, chuỗi là palindrome
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Tạo một đối tượng Scanner

        System.out.println("Vui lòng nhập một chuỗi để kiểm tra tính đối xứng:");
        String inputString = scanner.nextLine(); // Đọc toàn bộ dòng mà người dùng nhập

        // Gọi hàm kiểm tra
        boolean isPal = isPalindrome(inputString);

        // In kết quả
        if (isPal) {
            System.out.println("Chuỗi \"" + inputString + "\" là một chuỗi đối xứng.");
        } else {
            System.out.println("Chuỗi \"" + inputString + "\" KHÔNG phải là một chuỗi đối xứng.");
        }

        scanner.close(); // Đóng đối tượng Scanner
    }
}
