import java.util.*;
import java.util.Objects;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private List<String> hobbies;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public int getIdade() { return idade; }
    public double getSalario() { return salario; }
    public List<String> getHobbies() { return hobbies; }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %d R$ %.6f", codigo, nome, cargo, idade, salario).replace('.', ',');
    }

    @Override
    public int compareTo(Pessoa outra) {
        int cmp = this.nome.compareTo(outra.nome);
        if (cmp != 0) return cmp;
        return Integer.compare(this.codigo, outra.codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return codigo == pessoa.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
