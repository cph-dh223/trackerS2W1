package src;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 1 for new entry, type 2 to read eantry");
        String input = scanner.nextLine();

        if(input.equals("1")){
            //TODO: add saveFile calls
        } else {
            ReadFile reader = new ReadFile("../data/data.txt");
            System.out.println("pres enter to read all, give date in\"dd-mm-yyyy\" format");
            input = scanner.nextLine();
            if(input.length() == 0){
                System.out.println(reader.getAll());
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
                try {
                    reader.getByDate(dateFormat.parse(input));
                } catch (ParseException e) {
                    System.out.println("date was in wrong format");
                }
            }
        }
    }
}