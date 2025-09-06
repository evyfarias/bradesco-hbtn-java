import java.util.*;

public class Blog {

    private List<Post> posts;

    public Blog() {
        posts = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {
        for (Post p : posts) {
            if (p.getAutor().equals(post.getAutor()) && p.getTitulo().equals(post.getTitulo())) {
                throw new RuntimeException("Postagem jah existente");
            }
        }
        posts.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        TreeSet<Autor> autores = new TreeSet<>();
        for (Post post : posts) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new LinkedHashMap<>();
        // Adiciona as categorias na ordem desejada
        contagem.put(Categorias.DEVOPS, 0);
        contagem.put(Categorias.DESENVOLVIMENTO, 0);
        contagem.put(Categorias.DATA_SCIENCE, 0);

        for (Post post : posts) {
            contagem.put(post.getCategoria(), contagem.get(post.getCategoria()) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        TreeSet<Post> resultado = new TreeSet<>();
        for (Post post : posts) {
            if (post.getAutor().equals(autor)) {
                resultado.add(post);
            }
        }
        return resultado;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        TreeSet<Post> resultado = new TreeSet<>();
        for (Post post : posts) {
            if (post.getCategoria() == categoria) {
                resultado.add(post);
            }
        }
        return resultado;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new LinkedHashMap<>();
        map.put(Categorias.DEVOPS, obterPostsPorCategoria(Categorias.DEVOPS));
        map.put(Categorias.DESENVOLVIMENTO, obterPostsPorCategoria(Categorias.DESENVOLVIMENTO));
        map.put(Categorias.DATA_SCIENCE, obterPostsPorCategoria(Categorias.DATA_SCIENCE));
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new TreeMap<>();
        for (Autor autor : obterTodosAutores()) {
            map.put(autor, obterPostsPorAutor(autor));
        }
        return map;
    }
}
