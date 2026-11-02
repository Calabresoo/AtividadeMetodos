package Exercicio_07;

import java.util.Scanner;

public class SistemaVendas {
// Perdao professor mas isso aqui eu nao consegui fazer sozinho, eu tentei de tudo e nao consegui, entao eu dei uma olhada na resolucao do exercicio e tentei fazer. mas eu nao entendi nada do que foi feito, entao se puder relevar o uso de ia, eu agradeço
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        int totalVendas = 0;
        int totalProdutos = 0;
        double somaSubtotais = 0;
        double faturamento = 0;
        double totalDescontos = 0;
        double maiorVenda = 0;
        String clienteMaiorVenda = "";

        while (opcao != 2) {
            mostrarMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do cliente: ");
                String cliente = sc.nextLine();
                System.out.print("Nome do produto: ");
                String produto = sc.nextLine();
                System.out.print("Preço unitário: ");
                double preco = sc.nextDouble();
                System.out.print("Quantidade: ");
                int quantidade = sc.nextInt();
                System.out.print("Cliente VIP (1-Sim / 2-Não): ");
                int vip = sc.nextInt();
                System.out.print("Pagamento por PIX (1-Sim / 2-Não): ");
                int pix = sc.nextInt();

                // Se algo estiver errado, a venda é cancelada e não entra no relatório
                if (!dadosValidos(preco, quantidade, vip, pix)) {
                    continue;
                }

                double subtotal = calcularSubtotal(preco, quantidade);
                double desconto = calcularDescontoFaixa(subtotal);
                double descontoVip = calcularDescontoVip(subtotal, vip);
                double descontoPix = calcularDescontoPix(subtotal - desconto - descontoVip, pix);
                double total = subtotal - desconto - descontoVip - descontoPix;

                totalVendas++;
                totalProdutos += quantidade;
                somaSubtotais += subtotal;
                faturamento += total;
                totalDescontos += desconto + descontoVip + descontoPix;

                if (total > maiorVenda) {
                    maiorVenda = total;
                    clienteMaiorVenda = cliente;
                }

                mostrarComprovante(cliente, produto, quantidade, subtotal,
                        desconto, descontoVip, descontoPix, total);

            } else if (opcao != 2) {
                System.out.println("Opção inválida!");
            }
        }

        mostrarRelatorio(totalVendas, totalProdutos, somaSubtotais, faturamento,
                totalDescontos, maiorVenda, clienteMaiorVenda);
        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE VENDAS ===");
        System.out.println("1 - Nova venda");
        System.out.println("2 - Encerrar");
        System.out.print("Escolha: ");
    }

    // Confere se os dados digitados estão certos. Devolve true ou false.
    public static boolean dadosValidos(double preco, int quantidade, int vip, int pix) {
        if (preco <= 0 || quantidade <= 0) {
            System.out.println("Dados inválidos!");
            return false;
        }
        if (vip != 1 && vip != 2) {
            System.out.println("Opção de VIP inválida!");
            return false;
        }
        if (pix != 1 && pix != 2) {
            System.out.println("Opção de pagamento inválida!");
            return false;
        }
        return true;
    }

    // Preço x quantidade.
    public static double calcularSubtotal(double preco, int quantidade) {
        return preco * quantidade;
    }

    // Desconto por faixa: 15% (500 ou mais), 10% (200 ou mais), 5% (100 ou mais).
    public static double calcularDescontoFaixa(double subtotal) {
        double desconto = 0;

        if (subtotal >= 500) {
            desconto = subtotal * 0.15;
        } else if (subtotal >= 200) {
            desconto = subtotal * 0.10;
        } else if (subtotal >= 100) {
            desconto = subtotal * 0.05;
        }

        return desconto;
    }

    // 5% do subtotal se o cliente for VIP (vip == 1).
    public static double calcularDescontoVip(double subtotal, int vip) {
        double descontoVip = 0;

        if (vip == 1) {
            descontoVip = subtotal * 0.05;
        }

        return descontoVip;
    }

    // 3% sobre o valor que sobrou depois dos outros descontos, se pagar no PIX (pix == 1).
    public static double calcularDescontoPix(double valorAposDescontos, int pix) {
        double descontoPix = 0;

        if (pix == 1) {
            descontoPix = valorAposDescontos * 0.03;
        }

        return descontoPix;
    }

    // Mostra o comprovante da venda.
    public static void mostrarComprovante(String cliente, String produto, int quantidade,
                                          double subtotal, double desconto, double descontoVip,
                                          double descontoPix, double total) {
        System.out.println("\n===== COMPROVANTE =====");
        System.out.println("Cliente: " + cliente);
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade: " + quantidade);
        System.out.printf("Subtotal: R$ %.2f%n", subtotal);
        System.out.printf("Desconto: R$ %.2f%n", desconto);
        System.out.printf("Desconto VIP: R$ %.2f%n", descontoVip);
        System.out.printf("Desconto PIX: R$ %.2f%n", descontoPix);
        System.out.printf("Total: R$ %.2f%n", total);
    }

    // Mostra o relatório final.
    public static void mostrarRelatorio(int totalVendas, int totalProdutos, double somaSubtotais,
                                        double faturamento, double totalDescontos,
                                        double maiorVenda, String clienteMaiorVenda) {
        System.out.println("\n===== RELATÓRIO FINAL =====");
        System.out.println("Total de vendas: " + totalVendas);
        System.out.println("Produtos vendidos: " + totalProdutos);
        System.out.printf("Faturamento: R$ %.2f%n", faturamento);
        System.out.printf("Descontos: R$ %.2f%n", totalDescontos);
        System.out.printf("Maior venda: R$ %.2f%n", maiorVenda);
        System.out.println("Cliente: " + clienteMaiorVenda);

        if (totalVendas > 0) {
            System.out.printf("Ticket médio: R$ %.2f%n", faturamento / totalVendas);
            System.out.printf("Média de produtos por venda: %.2f%n", (double) totalProdutos / totalVendas);
            System.out.printf("Percentual de descontos: %.2f%%%n", totalDescontos / somaSubtotais * 100);
        }
    }
}
