import enums.Sexo;
import model.Pessoa;

public class Main {

    //Inicialmente essa classe será utilizada para realizar testes de desenvolvimento
    public static void main(String[] args) {

        Pessoa p = new Pessoa("Alphynha", "12345678900", java.time.LocalDate.of(2000, 1, 10), Sexo.M) {};

        System.out.println(p);
        System.out.println("Nome: " + p.getNome());
        System.out.println("Sexo: " + p.getSexo());
    }
}
