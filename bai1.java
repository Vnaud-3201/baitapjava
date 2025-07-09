package cap3;

import java.util.Arrays;
import java.util.Scanner;

public class bai1 {

    /**
     * Hàm này tìm hai số trong mảng đã sắp xếp có tổng bằng target.
     * @param numbers Mảng số nguyên đã được sắp xếp tăng dần.
     * @param target  Số nguyên mục tiêu.
     * @return Một mảng chứa hai chỉ số (bắt đầu từ 1) của hai số tìm thấy.
     */
    public static int[] timHaiSo(int[] numbers, int target) {
        // Khởi tạo hai con trỏ
        int left = 0;
        int right = numbers.length - 1;

        // Lặp trong khi con trỏ trái nhỏ hơn con trỏ phải
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                // Tìm thấy, trả về chỉ số (cộng 1 theo yêu cầu)
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                // Tổng quá nhỏ, dịch con trỏ trái sang phải để tăng tổng
                left++;
            } else {
                // Tổng quá lớn, dịch con trỏ phải sang trái để giảm tổng
                right--;
            }
        }

        // Trường hợp không tìm thấy (theo đề bài thì luôn có lời giải)
        // Ném ra ngoại lệ để báo lỗi nếu không có cặp nào thỏa mãn
        throw new IllegalArgumentException("Không tìm thấy cặp số nào có tổng bằng target.");
    }

    /**
     * Hàm main để chạy chương trình, nhận đầu vào từ người dùng.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập mảng từ người dùng
        System.out.println("Nhập các số của mảng, cách nhau bởi dấu cách (ví dụ: 2 7 11 15):");
        String line = scanner.nextLine();
        String[] numberStrs = line.split(" ");
        int[] numbers = new int[numberStrs.length];
        for (int i = 0; i < numberStrs.length; i++) {
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }

        // 2. Nhập số target từ người dùng
        System.out.print("Nhập số target: ");
        int target = scanner.nextInt();

        // 3. Gọi hàm xử lý và nhận kết quả
        try {
            int[] ketQua = timHaiSo(numbers, target);
            System.out.println("Chỉ số của hai số là: " + Arrays.toString(ketQua));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close(); // Đóng scanner sau khi dùng xong
        }
    }
}
