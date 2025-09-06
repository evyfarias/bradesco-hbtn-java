public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    // Construtor
    public Tarefa(String descricao, int identificador) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = descricao;
        this.identificador = identificador;
        this.estahFeita = false; // por padrão, começa como não feita
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public boolean isEstahFeita() {
        return estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    // Modificar descrição
    public void modificarDescricao(String novaDescricao) {
        if (novaDescricao == null || novaDescricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        }
        this.descricao = novaDescricao;
    }

    // Marcar como feita
    public void setFeita(boolean feita) {
        this.estahFeita = feita;
    }
}
