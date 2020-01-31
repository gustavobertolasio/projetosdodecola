import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        String tauto = "";
        Scanner scan = new Scanner(System.in);
        String[] palavras = scan.nextLine().trim().toLowerCase().replaceAll("( )+", " ").split(" ");
        while (!(palavras[0].equals("*"))) {
            if (palavras.length > 1) {
                tauto = "Y";
                char primeiraLetra = palavras[0].charAt(0);
                for (String palavra : palavras) {
                    if (primeiraLetra != palavra.charAt(0))
                        tauto = "N";
                }
            } else
                tauto = "Y";
            System.out.println(tauto);
            palavras = scan.nextLine().trim().toLowerCase().replaceAll(" +", " ").split(" ");

        }
        scan.close();
    }
}