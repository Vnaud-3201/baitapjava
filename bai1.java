package cap1;
import java.util.Scanner;
public class bai1{

    // Hàm kiểm tra ký tự có phải là nguyên âm không
    public static boolean laNguyenAm(char c) {
        c = Character.toLowerCase(c); // Không phân biệt hoa thường
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Hàm xóa nguyên âm khỏi chuỗi
    public static String xoaNguyenAm(String chuoiGoc) {
        String ketQua = "";
        for (int i = 0; i < chuoiGoc.length(); i++) {
            char kyTu = chuoiGoc.charAt(i);
            if (!laNguyenAm(kyTu)) {
                ketQua += kyTu; // Nối ký tự không phải nguyên âm
            }
        }
        return ketQua;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập chuỗi từ người dùng
        System.out.print("Nhập chuỗi: ");
        String dauVao = scanner.nextLine();

        // Gọi hàm xử lý và in kết quả
        String ketQua = xoaNguyenAm(dauVao);
        System.out.println("Chuỗi sau khi xóa nguyên âm: " + ketQua);

        scanner.close();
    }
}
