import java.util.ArrayList;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    // Construtor inicializa a lista
    public Pedido() {
        cookies = new ArrayList<>();
    }

    // Adicionar novo pedido
    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        cookies.add(pedidoCookie);
    }

    // Retorna total de caixas encomendadas
    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pc : cookies) {
            total += pc.getQuantidadeCaixas();
        }
        return total;
    }

    // Remove todos os pedidos de um sabor específico e retorna total removido
    public int removerSabor(String sabor) {
        int totalRemovido = 0;

        // percorre lista e acumula quantidade removida
        for (PedidoCookie pc : new ArrayList<>(cookies)) {
            if (pc.getSabor().equals(sabor)) {
                totalRemovido += pc.getQuantidadeCaixas();
                cookies.remove(pc);
            }
        }

        return totalRemovido;
    }
}
