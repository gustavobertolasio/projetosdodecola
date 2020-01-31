import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> DDD = Arrays.asList("Brasilia", "Salvador", "Sao Paulo", "Rio de Janeiro", "Juiz de Fora", "Campinas",
        "Vitoria", "Belo Horizonte");
       List<Integer> num= Arrays.asList(61, 71, 11, 21, 32, 19, 27, 31);
            int valor = scan.nextInt();
            if(num.contains(valor) )
                System.out.println(DDD.get(num.indexOf(valor)));
                else
                System.out.println("DDD nao cadastrado");
        scan.close();
    }
}