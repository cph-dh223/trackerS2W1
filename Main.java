import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner;

        System.out.println("Enter your note and press enter");
        scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        SaveFile fileSaver = new SaveFile();

        fileSaver.saveDateAndNote("data/tmp.txt", input);
    }

}

