import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, TreeSet<String>> obterHobbiesPorCargo(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        Collectors.flatMapping(
                                p -> p.getHobbies().stream(),
                                Collectors.toCollection(TreeSet::new)
                        )
                ));
    }

}
