package cap3;

import java.util.Scanner;

public class bai2 {

    // Biến toàn cục để lưu chỉ số bắt đầu và độ dài của chuỗi con dài nhất
    private int startIndex = 0;
    private int maxLength = 0;

    /**
     * Hàm chính tìm chuỗi con đối xứng dài nhất.
     * @param s Chuỗi đầu vào.
     * @return Chuỗi con đối xứng dài nhất.
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // Lặp qua tất cả các ký tự để coi chúng là tâm
        for (int i = 0; i < s.length(); i++) {
            // Trường hợp 1: Tâm là một ký tự (độ dài lẻ, ví dụ: "aba")
            expandAroundCenter(s, i, i);
            
            // Trường hợp 2: Tâm là giữa hai ký tự (độ dài chẵn, ví dụ: "abba")
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    /**
     * Hàm phụ trợ để mở rộng từ một tâm cho trước.
     * @param s Chuỗi đầu vào.
     * @param left Con trỏ trái.
     * @param right Con trỏ phải.
     */
    private void expandAroundCenter(String s, int left, int right) {
        // Mở rộng ra hai bên chừng nào các ký tự còn khớp và không vượt quá biên
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Tính độ dài của chuỗi đối xứng vừa tìm được
        int currentLength = right - left - 1;

        // Nếu chuỗi này dài hơn chuỗi dài nhất đã lưu, cập nhật kết quả
        if (currentLength > maxLength) {
            maxLength = currentLength;
            // Cập nhật lại chỉ số bắt đầu của chuỗi dài nhất
            startIndex = left + 1;
        }
    }

    /**
     * Hàm main để nhận chuỗi từ người dùng và in kết quả.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập chuỗi từ người dùng
        System.out.print("Nhập một chuỗi: ");
        String inputString = scanner.nextLine();

        // 2. Tạo đối tượng và gọi hàm xử lý
        bai2 solver = new bai2();
        String result = solver.longestPalindrome(inputString);

        // 3. In kết quả
        System.out.println("Chuỗi con đối xứng dài nhất là: " + result);

        scanner.close();
    }
}