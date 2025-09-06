import java.util.ArrayList;

public class ListaTodo {
    private ArrayList<Tarefa> tarefas;

    // Construtor
    public ListaTodo() {
        tarefas = new ArrayList<>();
    }

    // Adicionar tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == tarefa.getIdentificador()) {
                throw new IllegalArgumentException(
                    "Tarefa com identificador " + tarefa.getIdentificador() + " ja existente na lista"
                );
            }
        }
        tarefas.add(tarefa);
    }

    // Marcar tarefa como feita
    public boolean marcarTarefaFeita(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setFeita(true);
                return true;
            }
        }
        return false;
    }

    // Desfazer tarefa
    public boolean desfazerTarefa(int identificador) {
        for (Tarefa t : tarefas) {
            if (t.getIdentificador() == identificador) {
                t.setFeita(false);
                return true;
            }
        }
        return false;
    }

    // Marcar todas como não feitas
    public void desfazerTodas() {
        for (Tarefa t : tarefas) {
            t.setFeita(false);
        }
    }

    // Marcar todas como feitas
    public void fazerTodas() {
        for (Tarefa t : tarefas) {
            t.setFeita(true);
        }
    }

    // Listar todas
    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            String status = t.isEstahFeita() ? "[X]" : "[ ]";
            System.out.println(
                String.format("%s  Id: %d - Descricao: %s", status, t.getIdentificador(), t.getDescricao())
            );
        }
    }
}
