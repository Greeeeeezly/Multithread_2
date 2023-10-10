import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class FileReaderMultithread {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
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

        AtomicInteger totalResult= new AtomicInteger();

        Thread[] threads = new Thread[fileNames.length];

        for (int i = 0; i < fileNames.length; i++) {
            final String fileName = fileNames[i]; // Сделаем fileName final
            Thread thread = new Thread(() -> {
                int result = readFile(fileName);
                totalResult.addAndGet(result);
            });
            thread.start();
            threads[i] = thread;
        }

// Дождемся завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        System.out.println("Сумма чисел из всех файлов: " + totalResult);
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime - startTime) + " миллисекунд");
    }

    private static int readFile(String filename) {
        File file = new File(filename);
        int result = 0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                result += number;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла: " + filename);
        }
        return result;
    }
}
