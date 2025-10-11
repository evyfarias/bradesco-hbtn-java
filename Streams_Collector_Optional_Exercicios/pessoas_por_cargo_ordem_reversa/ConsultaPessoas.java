import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {
        Comparator<Pessoa> pessoaComparator = Comparator.comparingInt(Pessoa::getCodigo);

        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        () -> new TreeMap<>(Comparator.reverseOrder()),        // cargos em ordem reversa
                        Collectors.toCollection(() -> new TreeSet<>(pessoaComparator)) // TreeSet com comparator por código
                ));
    }
}
