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
        int cmp = this.toString().compareTo(outro.toString());
        return cmp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Autor)) return false;
        Autor autor = (Autor) obj;
        return this.nome.equals(autor.nome) && this.sobrenome.equals(autor.sobrenome);
    }

    @Override
    public int hashCode() {
        return (nome + sobrenome).hashCode();
    }
}
