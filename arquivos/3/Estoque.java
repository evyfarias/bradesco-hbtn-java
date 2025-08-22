import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Estoque {
    private String fileName;
    private List<Produto> produtos;

    public Estoque(String fileName) {
        this.fileName = fileName;
        this.produtos = new ArrayList<>();
        carregarEstoque();
    }

    private void carregarEstoque() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    String[] campos = linha.split(",");
                    int id = Integer.parseInt(campos[0]);
                    String nome = campos[1];
                    int quantidade = Integer.parseInt(campos[2]);
                    double preco = Double.parseDouble(campos[3]);
                    produtos.add(new Produto(id, nome, quantidade, preco));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o estoque: " + e.getMessage());
        }
    }

    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    private int gerarProximoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarProximoId();
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarEstoque();
        System.out.println("Produto adicionado com sucesso!");
    }

    public void excluirProduto(int id) {
        Iterator<Produto> iterator = produtos.iterator();
        boolean encontrado = false;
        while (iterator.hasNext()) {
            Produto p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            salvarEstoque();
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    // Atualizar Quantidade
    public void atualizarQuantidade(int id, int novaQuantidade) {
        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            salvarEstoque();
            System.out.println("Quantidade atualizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
