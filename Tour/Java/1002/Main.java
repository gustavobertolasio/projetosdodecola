import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0000");
        Double raio = scan.nextDouble();
        Double area = 3.14159 *Math.pow(raio, 2);
        System.out.println("A=" +  df.format(area));
        scan.close();
    }

}
