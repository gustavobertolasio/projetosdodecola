import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < N; i++) {

            String frase = "";
            String[] palavras = scan.nextLine().trim().split(" ");

            for (String a : palavras) {
                if(a.trim().length()> 0)
                {
                    frase+= a.trim().charAt(0);
                }
            }
            System.out.println(frase);

        }
        scan.close();
    }
}