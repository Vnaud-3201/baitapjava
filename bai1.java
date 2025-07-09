package cap2;
import java.util.InputMismatchException;
import java.util.Scanner;
public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double annualIncome = 0; // Thu nhập hàng năm

        System.out.println("--- Chương Trình Tính Thuế Thu Nhập Cá Nhân ---");
        System.out.println("Lưu ý: Đơn vị tính là triệu đồng.");

        // Yêu cầu người dùng nhập thu nhập hàng năm
        while (true) {
            System.out.print("Vui lòng nhập tổng thu nhập hàng năm của bạn (triệu đồng): ");
            try {
                annualIncome = scanner.nextDouble();
                if (annualIncome < 0) {
                    System.out.println("Thu nhập không thể là số âm. Vui lòng nhập lại.");
                } else {
                    break; // Thoát vòng lặp nếu nhập hợp lệ
                }
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Đầu vào không hợp lệ. Vui lòng nhập một số.");
                scanner.next(); // Đọc bỏ đầu vào không hợp lệ để tránh vòng lặp vô hạn
            }
        }

        // Tính thuế
        double tax = calculateTax(annualIncome);

        // Xuất số thuế phải trả
        System.out.printf("\nTổng thu nhập hàng năm của bạn: %.2f triệu đồng%n", annualIncome);
        System.out.printf("Số thuế thu nhập cá nhân bạn phải trả là: %.2f triệu đồng%n", tax);

        scanner.close(); // Đóng Scanner
    }

    /**
     * Hàm tính thuế thu nhập cá nhân dựa trên thu nhập hàng năm và các bậc thuế.
     *
     * @param income Thu nhập chịu thuế hàng năm (triệu đồng).
     * @return Số thuế phải trả (triệu đồng).
     */
    public static double calculateTax(double income) {
        double taxAmount = 0;

        // Bậc 1: Đến 5 triệu đồng, thuế 5%
        if (income > 0) { // Đảm bảo income dương mới tính thuế
            double taxableAmount = Math.min(income, 5); // Phần thu nhập thuộc bậc này
            taxAmount += taxableAmount * 0.05;
            income -= taxableAmount; // Giảm thu nhập đã tính thuế
        }

        // Bậc 2: Trên 5 triệu đến 10 triệu đồng, thuế 10%
        if (income > 0) {
            double taxableAmount = Math.min(income, 5); // 10 - 5 = 5 triệu
            taxAmount += taxableAmount * 0.10;
            income -= taxableAmount;
        }

        // Bậc 3: Trên 10 triệu đến 18 triệu đồng, thuế 15%
        if (income > 0) {
            double taxableAmount = Math.min(income, 8); // 18 - 10 = 8 triệu
            taxAmount += taxableAmount * 0.15;
            income -= taxableAmount;
        }

        // Bậc 4: Trên 18 triệu đến 32 triệu đồng, thuế 20%
        if (income > 0) {
            double taxableAmount = Math.min(income, 14); // 32 - 18 = 14 triệu
            taxAmount += taxableAmount * 0.20;
            income -= taxableAmount;
        }

        // Bậc 5: Trên 32 triệu đến 52 triệu đồng, thuế 25%
        if (income > 0) {
            double taxableAmount = Math.min(income, 20); // 52 - 32 = 20 triệu
            taxAmount += taxableAmount * 0.25;
            income -= taxableAmount;
        }

        // Bậc 6: Trên 52 triệu đến 80 triệu đồng, thuế 30%
        if (income > 0) {
            double taxableAmount = Math.min(income, 28); // 80 - 52 = 28 triệu
            taxAmount += taxableAmount * 0.30;
            income -= taxableAmount;
        }

        // Bậc 7: Trên 80 triệu đồng, thuế 35%
        if (income > 0) {
            taxAmount += income * 0.35; // Phần còn lại thuộc bậc cao nhất
        }

        return taxAmount;
    }
    
}
