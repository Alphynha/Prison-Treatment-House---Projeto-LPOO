import enums.GrauPericulosidade;
import enums.Sexo;
import enums.StatusCela;
import model.Cela;
import model.Pessoa;
import model.Presidiario;

import java.time.LocalDate;

public class Main {

    //Inicialmente essa classe será utilizada para realizar testes de desenvolvimento
    public static void main(String[] args) {

        //Criando cela
        Cela cela = new Cela("C01", 1, 0, StatusCela.DESOCUPADA);

        System.out.println(cela);
        System.out.println();

        //Criando o primeiro presidiario
        Presidiario p1 = new Presidiario(
                "Alphynha",
                "12334095",
                LocalDate.of(1999, 2, 20),
                Sexo.M,
                "P001",
                LocalDate.now(),
                GrauPericulosidade.ALTO
        );

        System.out.println("--- Presidiario Criado ---");
        System.out.println(p1);
        System.out.println();

        //Testando alocação
        if (cela.alocarPreso()) {
            p1.setCelaAlocada(cela);
        }

        System.out.println("--- Após alocação ---");
        System.out.println(p1);
        System.out.println(cela);
        System.out.println();

        //Criando segundo presidiario

        System.out.println("--- Testando segundo presidiário ---");
        System.out.println();

        Presidiario p2 = new Presidiario(
                "Flaky",
                "1239895021",
                LocalDate.of(2000, 9, 29),
                Sexo.F,
                "P002",
                LocalDate.now(),
                GrauPericulosidade.BAIXO
        );

        //Tentando alocar em uma cela cheia
        System.out.println("--- Tentando alocar na cela cheia---");
        System.out.println();

        if (cela.alocarPreso()) {
            p2.setCelaAlocada(cela);
        }

        //Fim do teste
        System.out.println("Fim do teste!");
    }
}
