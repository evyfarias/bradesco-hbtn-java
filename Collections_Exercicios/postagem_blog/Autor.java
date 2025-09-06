public class Autor implements Comparable<Autor> {
    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public int compareTo(Autor outro) {
        int resultado = this.nome.compareTo(outro.nome);
        if (resultado == 0) {
            resultado = this.sobrenome.compareTo(outro.sobrenome);
        }
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Autor)) return false;
        Autor outro = (Autor) obj;
        return nome.equals(outro.nome) && sobrenome.equals(outro.sobrenome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + 31 * sobrenome.hashCode();
    }
}
