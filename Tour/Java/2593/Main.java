import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] texto = scan.nextLine().split(" ");
        int palavras = Integer.parseInt(scan.nextLine());
        String[] palavrasAProcurar = scan.nextLine().split(" ");

        for (int i = 0; i < palavras; i++) {

            int distancia = 0;
            String achados = "";
            for (String string : texto) {

                if (palavrasAProcurar[i].equals(string)) {
                    achados += distancia + " ";
                }
                distancia += string.length() + 1;
            }
            if (achados.equals(""))
                achados = "-1";

            System.out.println(achados.trim());
        }
        scan.close();
    }
}