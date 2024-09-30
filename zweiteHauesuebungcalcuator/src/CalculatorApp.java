import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AbstractCalculator calculator = null;

        while (true) {
            System.out.println("Choose calculator:");
            System.out.println("1 = Rational calculator");
            System.out.println("2 = Vector calculator");
            System.out.println("3 = Complex calculator");
            System.out.println("4 = Exit program");
            System.out.print("> ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting program.");
                break;
            }

            switch (choice) {
                case 1:
                    calculator = new RationalCalculator();
                    break;
                case 2:
                    calculator = new VectorCalculator();
                    break;
                case 3:
                    calculator = new ComplexCalculator();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            System.out.print("Enter number x a> ");
            double xa = scanner.nextDouble();
            System.out.print("Enter number x b> ");
            double xb = scanner.nextDouble();
            System.out.print("Enter number y a> ");
            double ya = scanner.nextDouble();
            System.out.print("Enter number y b> ");
            double yb = scanner.nextDouble();

            Number x = new Number(xa, xb);
            Number y = new Number(ya, yb);

            while (true) {
                System.out.println("Choose operation:");
                System.out.println("1 = add");
                System.out.println("2 = subtract");
                System.out.println("3 = multiply");
                System.out.println("4 = divide");
                System.out.println("5 = enter numbers again");
                System.out.print("> ");
                int operation = scanner.nextInt();

                if (operation == 5) {
                    break;
                }

                Number result = null;

                switch (operation) {
                    case 1:
                        result = calculator.add(x, y);
                        break;
                    case 2:
                        result = calculator.subtract(x, y);
                        break;
                    case 3:
                        result = calculator.multiply(x, y);
                        break;
                    case 4:
                        result = calculator.divide(x, y);
                        break;
                    default:
                        System.out.println("Invalid operation. Try again.");
                        continue;
                }

                System.out.println("=========================");
                System.out.println("Solution:");
                System.out.println(result);
                System.out.println("=========================");
            }
        }

        scanner.close();
    }
}
