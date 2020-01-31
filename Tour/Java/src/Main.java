package src;
import src.World;

public class Main {
    public static void main(String args[]) {

   World  a = new World("IHI");
    System.out.print(a.getName());

    PessoaFisica pessoa = new PessoaFisica();
        printPessoa(pessoa);
    PessoaJuridica pessoaj = new PessoaJuridica();
        printPessoa(pessoaj);

    }

    public static void printPessoa(PessoaBase pessoa)
    {
        System.out.println(pessoa.metodoConcreto());

        System.out.println(pessoa.Nani());
    }

}