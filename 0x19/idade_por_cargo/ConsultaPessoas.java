import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static Map<String, List<Integer>> obterIdadePorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo, // agrupa por cargo
                Collectors.mapping(Pessoa::getIdade, Collectors.toList()) // pega apenas a idade
            ));
    }
}
