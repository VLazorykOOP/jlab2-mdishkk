import java.io.*;
import java.util.*;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть назви текстових файлів через пробіл: ");
        String input = scanner.nextLine();
        String[] fileNames = input.split("\\s+");

        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("Файл не знайдено: " + fileName);
                continue;
            }
            if (!file.isFile()) {
                System.out.println("Не є файлом: " + fileName);
                continue;
            }

            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                int c;
                while ((c = reader.read()) != -1) {
                    if (!isIgnoredCharacter(c)) {
                        charCount++;
                    }
                }
            } catch (IOException e) {
                System.out.println("Помилка читання файлу: " + fileName);
                continue;
            }

            System.out.println("Файл: " + fileName + " - Кількість символів: " + charCount);
        }

        scanner.close();
    }

    private static boolean isIgnoredCharacter(int c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }
}
