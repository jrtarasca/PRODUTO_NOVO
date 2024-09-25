import java.util.Scanner;

class Produto {
    String nome;
    String Fab;  // Data de fabricação
    String Val;  // Data de validade
    double custo;
    double Venda;
    Scanner scan = new Scanner(System.in);

    // Método para cadastrar o produto completo
    public void cadastrarProdutoCompleto() {
        System.out.print("Digite o nome do produto: ");
        nome = scan.nextLine();

        System.out.print("Digite o preço de custo do produto: ");
        custo = scan.nextDouble();
        scan.nextLine(); // Consumir o '\n' deixado pelo nextDouble()

        System.out.print("Digite o preço de venda do produto: ");
        Venda = scan.nextDouble();
        scan.nextLine(); // Consumir o '\n' deixado pelo nextDouble()

        System.out.print("Digite a data de fabricação (ddMMyyyy): ");
        Fab = scan.nextLine();

        calcularValidade();
    }

    // Método para cadastrar o produto apenas com nome e custo
    public void cadastrarProdutoSimples() {
        System.out.print("Digite o nome do produto: ");
        nome = scan.nextLine();

        System.out.print("Digite o preço de custo do produto: ");
        custo = scan.nextDouble();
        scan.nextLine(); // Consumir o '\n' deixado pelo nextDouble()

        // Calcula o preço de venda (10% a mais sobre o preço de custo)
        Venda = custo * 1.10;

        System.out.print("Digite a data de fabricação (ddMMyyyy): ");
        Fab = scan.nextLine();

        calcularValidade();
    }

    // Método para calcular a validade (1 mês após a fabricação)
    private void calcularValidade() {
        String dia = Fab.substring(0, 2);
        String mes = Fab.substring(2, 4);
        String ano = Fab.substring(4, 8);
        int mesInt = Integer.parseInt(mes);
        int anoInt = Integer.parseInt(ano);

        mesInt++;
        if (mesInt > 12) {
            mesInt = 1;
            anoInt++;
        }
        mes = String.format("%02d", mesInt);
        Val = dia + mes + anoInt;  // Nova data de validade
    }

    // Método para exibir os detalhes do produto
    public void exibirDetalhes() {
        System.out.println("\n--- Detalhes do Produto ---");
        System.out.println("Nome: " + nome);
        System.out.println("Preço de custo: R$ " + custo);
        System.out.println("Preço de venda: R$ " + Venda);
        System.out.println("Data de fabricação: " + formatarData(Fab));
        System.out.println("Data de validade: " + formatarData(Val));
    }

    // Formatar a data de ddMMyyyy para dd/MM/yyyy
    private String formatarData(String data) {
        return data.substring(0, 2) + "/" + data.substring(2, 4) + "/" + data.substring(4, 8);
    }
}

public class MostrarProduto {
    public static void main(String[] args) {
        Produto produto = new Produto();

        produto.cadastrarProdutoCompleto();
        produto.exibirDetalhes();
    }
}
