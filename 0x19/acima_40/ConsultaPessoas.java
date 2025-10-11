import java.util.*;
import java.util.stream.*;

public class ConsultaPessoas {

    // 0. Agrupa pessoas por cargo
    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(Pessoa::getCargo));
    }

    // 1. Lista idades das pessoas agrupadas por cargo
    public static Map<String, List<Integer>> obterIdadePorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.mapping(Pessoa::getIdade, Collectors.toList())
            ));
    }

    // 2. Agrupa pessoas por cargo e filtra idade >= 40
    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.filtering(p -> p.getIdade() >= 40, Collectors.toList())
            ));
    }

    // 3. Conta quantidade de pessoas por cargo com idade >= 40 (opcional, se precisar)
    public static Map<String, Long> obterQuantidadePorCargoAcimaDe40anos(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.filtering(p -> p.getIdade() >= 40, Collectors.counting())
            ));
    }
}
