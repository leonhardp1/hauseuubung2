public class ComplexCalculator extends AbstractCalculator {

    public ComplexCalculator() {
        super(
                (x, y) -> new Number(x.getA() + y.getA(), x.getB() + y.getB()), // Addition
                (x, y) -> new Number(x.getA() - y.getA(), x.getB() - y.getB()), // Subtraktion
                // Multiplikation von komplexen Zahlen
                (x, y) -> new Number(x.getA() * y.getA() - x.getB() * y.getB(),
                        x.getA() * y.getB() + x.getB() * y.getA()),
                // Division von komplexen Zahlen
                (x, y) -> {
                    double denominator = y.getA() * y.getA() + y.getB() * y.getB();
                    return new Number(
                            (x.getA() * y.getA() + x.getB() * y.getB()) / denominator,
                            (x.getB() * y.getA() - x.getA() * y.getB()) / denominator
                    );
                }
        );
    }

    @Override
    public Number add(Number a, Number b) {
        return add.calc(a, b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return subtract.calc(a, b);
    }

    @Override
    public Number multiply(Number a, Number b) {
        return multiply.calc(a, b);
    }

    @Override
    public Number divide(Number a, Number b) {
        return divide.calc(a, b);
    }
}
