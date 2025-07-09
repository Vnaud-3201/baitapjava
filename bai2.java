package cap1;
import java.util.Scanner;

public class bai2 {

    public static int TimLonThuHai(int[] arr) {
        if (arr.length < 2) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }

        return (secondMax == Integer.MIN_VALUE) ? Integer.MIN_VALUE : secondMax;
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

        int ketQua = TimLonThuHai(arr);
        if (ketQua == Integer.MIN_VALUE) {
            System.out.println("Không tồn tại giá trị lớn thứ hai.");
        } else {
            System.out.println("Giá trị lớn thứ hai trong mảng là: " + ketQua);
        }

        scanner.close();
    }
}
