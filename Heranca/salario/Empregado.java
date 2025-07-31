import java.math.BigDecimal;
import java.math.RoundingMode;

public class Empregado {
    protected double salarioFixo;

    public Empregado(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            BigDecimal salarioBD = new BigDecimal(String.format("%.2f", salarioFixo));
            BigDecimal bonus = salarioBD.multiply(new BigDecimal("0.10"));
            bonus = bonus.setScale(2, RoundingMode.HALF_UP);
            return bonus.doubleValue();
        }
        return 0.0;
    }

    public double calcularSalarioTotal(Departamento departamento) {
        double bonus = calcularBonus(departamento);
        BigDecimal salarioBD = new BigDecimal(String.format("%.2f", salarioFixo));
        BigDecimal bonusBD = new BigDecimal(String.format("%.2f", bonus));
        BigDecimal total = salarioBD.add(bonusBD);
        total = total.setScale(2, RoundingMode.HALF_UP);
        return total.doubleValue();
    }

}
