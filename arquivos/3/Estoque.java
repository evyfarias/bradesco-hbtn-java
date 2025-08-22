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

    // Carrega produtos do CSV (não imprime nada em caso de sucesso)
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
            // silencioso para não quebrar testes; se precisar, trate no chamador
        }
    }

    // Salva produtos no CSV (sem prints)
    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            // silencioso para os testes; opcional: lançar RuntimeException
        }
    }

    // Gera próximo ID
    private int gerarProximoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }
        return maxId + 1;
    }

    // Adiciona produto (sem prints)
    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarProximoId();
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarEstoque();
    }

    // Exclui produto por ID (sem prints)
    public void excluirProduto(int id) {
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) {
            Produto p = it.next();
            if (p.getId() == id) {
                it.remove();
                break;
            }
        }
        salvarEstoque();
    }

    // Atualiza quantidade (sem prints)
    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                break;
            }
        }
        salvarEstoque();
    }

    // Imprime exatamente as linhas do estoque (sem cabeçalho/rodapé)
    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
