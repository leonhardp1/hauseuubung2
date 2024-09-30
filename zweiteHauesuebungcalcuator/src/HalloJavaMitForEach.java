import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class HalloJavaMitForEach {
    public static void main(String[] args) {
        List<String> liste = Arrays.asList("Hallo", "Java", "mit", "forEach");

        for (String s : liste) {
            System.out.println(s);
        }

        System.out.println("-----");

        liste.forEach((String s) -> System.out.println(s));

        System.out.println("-----");

        liste.forEach(System.out::println);

        System.out.println("-----");

        Consumer<String> consumer = (String s) -> System.out.println(s);
        liste.forEach(consumer);
    }
}
