import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            Integer valor = scan.nextInt();
            String msg = "";
            if (valor != 0) {
                if (valor % 2 == 0)
                    msg += "EVEN ";
                else
                    msg += "ODD ";

                if (valor > 0)
                    msg += "POSITIVE";
                else
                    msg += "NEGATIVE";
            } else
                msg = "NULL";

            System.out.println(msg);            
        }
        scan.close();
    }
}