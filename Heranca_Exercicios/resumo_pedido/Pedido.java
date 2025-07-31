import java.util.Locale;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        return total * (1 - percentualDesconto);
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0;

        for (ItemPedido item : itens) {
            String tipo = item.getProduto().getClass().getSimpleName();
            String titulo = item.getProduto().getTitulo();
            double precoUnitario = item.getProduto().obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = precoUnitario * quantidade;

            totalProdutos += totalItem;

            System.out.printf(Locale.forLanguageTag("pt-BR"),
                    "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, titulo, precoUnitario, quantidade, totalItem);
        }

        double desconto = totalProdutos * percentualDesconto;
        double totalPedido = totalProdutos - desconto;

        System.out.println("----------------------------");
        System.out.printf(Locale.forLanguageTag("pt-BR"), "DESCONTO: %.2f\n", desconto);
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }

}
