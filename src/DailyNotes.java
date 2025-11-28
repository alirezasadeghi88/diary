import java.io.*;
import java.util.Scanner;

public class DailyNotes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filename =  "notes.txt";

        System.out.println("1) نوشتن یادداشت جدید");
        System.out.println("2)خواندن یادداشت ");
        System.out.println("نتخاب کنید :");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            System.out.println("یادداشت خود را وارد کنید: ");
            String note = input.nextLine();

            try(FileWriter writer = new FileWriter(filename, true)) {
                writer.write(note + "\n");
                System.out.println("یادداشت ذخیره شد.✓");
            }catch(IOException e) {
                System.out.println("خطا در ذخیره فایل!");
            }
        }else if (choice == 2) {
            try (BufferedReader reader = new BufferedReader(new
                    FileReader(filename))){
                String line;
                System.out.println("یادداشت های شما");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }catch (FileNotFoundException e) {
                System.out.println("فایلی پیدا نشد! هنوز یادداشتی ذخیره نکردی.");
            }
            catch (IOException e) {
                System.out.println("خطا در خواندن فایل!");
            }
        }else {
            System.out.println("انتخاب نامعتبر");
        }
    }
}
