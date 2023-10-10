import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        long startTime =System.currentTimeMillis();
        String[] fileNames = {
                "files/numbers1.txt",
                "files/numbers2.txt",
                "files/numbers3.txt",
                "files/numbers4.txt",
                "files/numbers5.txt",
                "files/numbers6.txt",
                "files/numbers7.txt",
                "files/numbers8.txt",
                "files/numbers9.txt",
                "files/numbers10.txt",
                "files/numbers11.txt",
                "files/numbers12.txt",
                "files/numbers13.txt",
                "files/numbers14.txt",
                "files/numbers15.txt",
                "files/numbers16.txt",
                "files/numbers17.txt",
                "files/numbers18.txt",
                "files/numbers19.txt",
                "files/numbers20.txt",
                "files/numbers21.txt",
                "files/numbers22.txt",
                "files/numbers23.txt"

        };

        int totalResult = 0;

        for (String fileName : fileNames) {
            File file = new File(fileName);
            int result = 0;

            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    result += number;
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Ошибка чтения файла " + fileName);
            }

            totalResult += result;
        }

        System.out.println("Сумма чисел из всех файлов: " + totalResult);
        long endTime=System.currentTimeMillis();
        System.out.println("Время выполнения программы:"+ (endTime-startTime) + " милисекунд");
    }
}