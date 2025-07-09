package cap1;
import java.util.Scanner;
public class bai3 {

    // Hàm kiểm tra ký tự có phải là nguyên âm không
    public static int Tinhtong(int n ) {
        int tong = 0;
        for (int i = 0; i <=n; i++) {
            tong += i; // Cộng dồn các phần tử trong mảng
        }
        return tong;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int Tong = Tinhtong(n);
        System.out.println("Tổng các phần tử trong mảng là: " + Tong);

    }
}