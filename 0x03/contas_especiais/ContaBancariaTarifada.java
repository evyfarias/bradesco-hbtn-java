import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        this.quantidadeTransacoes++;
        try {
            super.sacar(0.10);
        } catch (OperacaoInvalidaException e) {
        }
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        this.quantidadeTransacoes++;
        try {
            super.sacar(0.10);
        } catch (OperacaoInvalidaException e) {
        }
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }
}
