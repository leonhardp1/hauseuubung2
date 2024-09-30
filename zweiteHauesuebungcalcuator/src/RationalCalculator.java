public class RationalCalculator extends AbstractCalculator {

    public RationalCalculator() {
        super(
                (x, y) -> new Number(x.getA() + y.getA(), x.getB() + y.getB()), // Addition
                (x, y) -> new Number(x.getA() - y.getA(), x.getB() - y.getB()), // Subtraktion
                (x, y) -> new Number(x.getA() * y.getA(), x.getB() * y.getB()), // Multiplikation
                (x, y) -> new Number(x.getA() / y.getA(), x.getB() / y.getB())  // Division
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
