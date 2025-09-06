import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    // Adiciona uma postagem ao blog
    public void adicionarPostagem(Post postagem) {
        postagens.add(postagem);
    }

    // Retorna um Set com autores ordenados pelo nome
    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    // Retorna contagem de postagens por categoria, ordenado pelo nome da categoria
    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post post : postagens) {
            String categoria = post.getCategoria();
            contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
        }
        return contagem;
    }
}
