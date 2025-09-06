public class PedidoCookie {
    private String sabor;
    private int quantidadeCaixas;

    // Construtor
    public PedidoCookie(String sabor, int quantidadeCaixas) {
        this.sabor = sabor;
        this.quantidadeCaixas = quantidadeCaixas;
    }

    // Getters
    public String getSabor() {
        return sabor;
    }

    public int getQuantidadeCaixas() {
        return quantidadeCaixas;
    }
}
