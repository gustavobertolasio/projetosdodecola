import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       
        int palavras = Integer.parseInt(scan.nextLine());        

        for (int i = 0; i < palavras; i++) {
            String[] texto = scan.nextLine().split(" ");
            String palavrasAProcurar = scan.nextLine();
            int distancia = 0;
            String achados = "";
            for (String string : texto) {
                if (palavrasAProcurar.equals(string)) {
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