import model.Cliente;
import model.Conta;
import repository.ContaRepository;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o numero da conta:");
        int numeroPesquisado = scanner.nextInt();

        // Clientes
        Cliente cliente1 = new Cliente("Joao", "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria", "987.654.321-00");
        Cliente cliente3 = new Cliente("Pedro", "456.789.123-00");

        // Contas dos clientes
        Conta conta1 = new Conta(1001, 5000.0, cliente1);
        Conta conta2 = new Conta(1002, 3000.0, cliente2);
        Conta conta3 = new Conta(1003, 7000.0, cliente3);

        // Repositorio de contas
        ContaRepository repository = new ContaRepository();
        repository.adicionarConta(conta1);
        repository.adicionarConta(conta2);
        repository.adicionarConta(conta3);

        Conta resultado = repository.buscarPorNumero(numeroPesquisado);

        if (resultado != null) {
            System.out.println("Conta encontrada:" +
                    "\nNumero da conta: " + resultado.getNumero() +
                    "\nSaldo: " + resultado.getSaldo() +
                    "\nCliente: " + resultado.getCliente().getNome() +
                    "\nCPF: " + resultado.getCliente().getCpf());
        } else {
            System.out.println("Conta nao encontrada.");
        }
    }
}