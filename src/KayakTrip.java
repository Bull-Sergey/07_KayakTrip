import java.util.Arrays;
import java.util.Scanner;

public class KayakTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение количества людей N и вес
        System.out.print("Введите количество человек (N):");
        int n = scanner.nextInt();
        int[] masses = new int[n];
        System.out.println("Введите вес людей (в кг) через пробел:");
        for (int i = 0; i < n; i++) {
            masses[i] = scanner.nextInt();
        }

        // Чтение грузоподъемности D
        System.out.print("Введите грузоподъемность одной байдарки (D):");
        int d = scanner.nextInt();

        // Сортировка масс по возрастанию
        Arrays.sort(masses);

        int lightWeight = 0;
        int heavyWeight = n - 1;
        int kayaksCount = 0;

        while (lightWeight <= heavyWeight) {
            // Если самый легкий и самый тяжелый могут плыть вместе
            if (masses[lightWeight] + masses[heavyWeight] <= d) {
                lightWeight++; // Легкий садится в байдарку
                heavyWeight--; // Тяжелый садится в ту же байдарку (или они вдвоем)
            } else {
                // Тяжелый не может плыть с легким, он плывет один
                heavyWeight--;
            }
            kayaksCount++; // Байдарка использована
        }

        System.out.println("Минимальное количество байдарок:" + kayaksCount);

        scanner.close();
    }
}
