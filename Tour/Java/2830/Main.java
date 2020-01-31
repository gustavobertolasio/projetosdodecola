import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int K = Integer.parseInt(scan.nextLine());
        int L = Integer.parseInt(scan.nextLine());

        String msg = (K >= 9 && L <= 8) || (K <= 8 && L >= 9) ? "final"
                : ((K >= 5 && L <= 4) || (K <= 12 && L >= 13) || (L >= 5 && K <= 4) || (L <= 12 && K >= 13))
                        ? "semifinal"
                        : ((K % 2 == 0 && K - 1 == L) || (K % 2 == 1 && K + 1 == L)) ? "oitavas" : "quartas";

        System.out.println(msg);
        scan.close();
    }
}