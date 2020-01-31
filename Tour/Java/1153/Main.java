import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int fat=1;
        for (int i = N; i > 1; i--) {
            fat = fat * i;
        }
        System.out.println(fat);
        scan.close();
    }
}