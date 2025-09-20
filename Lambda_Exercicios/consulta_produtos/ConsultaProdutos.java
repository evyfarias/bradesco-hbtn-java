import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {
        List<Produto> filtrados = new ArrayList<>();
        for (Produto p : produtos) {
            if (criterio.testar(p)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }
}
