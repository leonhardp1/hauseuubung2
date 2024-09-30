import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NumberTester {

    private NumberTest oddEvenTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private String fileName;

    public NumberTester(String fileName) {
        this.fileName = fileName;
    }

    public void setOddEvenTester(NumberTest oddTester) {
        this.oddEvenTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int numberOfTests = Integer.parseInt(reader.readLine());

            for (int i = 0; i < numberOfTests; i++) {
                String[] parts = reader.readLine().split(" ");
                int testType = Integer.parseInt(parts[0]);
                int number = Integer.parseInt(parts[1]);

                switch (testType) {
                    case 1:
                        if (oddEvenTester.testNumber(number)) {
                            System.out.println("EVEN");
                        } else {
                            System.out.println("ODD");
                        }
                        break;
                    case 2:
                        if (primeTester.testNumber(number)) {
                            System.out.println("PRIME");
                        } else {
                            System.out.println("NO PRIME");
                        }
                        break;
                    case 3:
                        if (palindromeTester.testNumber(number)) {
                            System.out.println("PALINDROME");
                        } else {
                            System.out.println("NO PALINDROME");
                        }
                        break;
                    default:
                        System.out.println("Invalid test type");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NumberTester tester = new NumberTester("5.txt");

        tester.setOddEvenTester((int number) -> number % 2 == 0);

        tester.setPrimeTester((int number) -> {
            if (number < 2) return false;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) return false;
            }
            return true;
        });

        tester.setPalindromeTester((int number) -> {
            String str = Integer.toString(number);
            return str.equals(new StringBuilder(str).reverse().toString());
        });

        tester.testFile();
    }
}



