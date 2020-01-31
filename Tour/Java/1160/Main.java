
import java.util.Scanner;


/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            String[] caso = scan.nextLine().split(" ");
            int PA = Integer.parseInt(caso[0]);
            int PB = Integer.parseInt(caso[1]);
            Double G1 = Double.parseDouble(caso[2]);
            Double G2 = Double.parseDouble(caso[3]);
            int ano = 0;

            while (PA <= PB && ano < 102) {
                PA = PA + (int) (PA * (G1 / 100));
                PB = PB + (int) (PB * (G2 / 100));
                ano++;
            }
            if (ano < 101)
                System.out.println(ano + " anos.");
            else
                System.out.println("Mais de 1 seculo.");
        }
        scan.close();
    }
}