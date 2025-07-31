import java.math.BigDecimal;
import java.math.RoundingMode;

public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            BigDecimal salarioBD = new BigDecimal(String.format("%.2f", salarioFixo));
            BigDecimal vintePorcento = salarioBD.multiply(new BigDecimal("0.20"));

            double diferenca = departamento.getValorAtingidoMeta() - departamento.getValorMeta();
            BigDecimal diferencaBD = new BigDecimal(String.format("%.2f", diferenca));

            BigDecimal umPorcentoDiferenca = diferencaBD.multiply(new BigDecimal("0.01"));

            BigDecimal bonusTotal = vintePorcento.add(umPorcentoDiferenca);
            bonusTotal = bonusTotal.setScale(2, RoundingMode.HALF_UP);

            return bonusTotal.doubleValue();
        }
        return 0.0;
    }
}
