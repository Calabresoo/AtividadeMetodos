# Desafio 7 - Métodos criados

| Método | Recebe | Devolve | O que faz |
|---|---|---|---|
| `mostrarMenu` | nada | nada (`void`) | Mostra o menu |
| `dadosValidos` | preço, quantidade, vip, pix | `boolean` | Confere se os dados estão certos |
| `calcularSubtotal` | preço, quantidade | `double` | Preço x quantidade |
| `calcularDescontoFaixa` | subtotal | `double` | Desconto de 5%, 10% ou 15% conforme o valor |
| `calcularDescontoVip` | subtotal, vip | `double` | 5% se for cliente VIP |
| `calcularDescontoPix` | valor após descontos, pix | `double` | 3% se pagar no PIX |
| `mostrarComprovante` | dados da venda | nada (`void`) | Imprime o comprovante |
| `mostrarRelatorio` | totais das vendas | nada (`void`) | Imprime o relatório final |

O `main` guarda os totais, repete o menu com o `while` e chama os métodos.
