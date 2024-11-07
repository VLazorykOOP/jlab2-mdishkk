import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть назву вхідного файлу: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Введіть назву вихідного файлу: ");
        String outputFileName = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        int validLineCount = 0;
        long sum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    numbers.add(number);
                    validLineCount++;
                    sum += number;
                } catch (NumberFormatException e) {
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + inputFileName);
            return;
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + inputFileName);
            return;
        }

        if (validLineCount == 0) {
            System.out.println("У файлі немає валідних цілих чисел.");
            return;
        }

        double average = (double) sum / validLineCount;

        List<Integer> lessThanAverage = numbers.stream()
                .filter(n -> n < average)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> greaterOrEqualAverage = numbers.stream()
                .filter(n -> n >= average)
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Integer num : lessThanAverage) {
                writer.write(num.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + outputFileName);
            return;
        }

        System.out.println("Числа, які не менші за середнє (" + average + "):");
        for (Integer num : greaterOrEqualAverage) {
            System.out.println(num);
        }

        System.out.println("Кількість валідних рядків: " + validLineCount);
        System.out.println("Середнє арифметичне: " + average);
    }
}
