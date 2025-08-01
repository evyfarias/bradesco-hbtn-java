package provedores;

public class Loggi implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double porcentagem = (peso > 5000) ? 0.12 : 0.04;
        return new Frete(valor * porcentagem, TipoProvedorFrete.LOGGI);
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }
}
