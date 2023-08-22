import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SaveFile {

    private File file;

    private Scanner scanner;

    public SaveFile() {


    }

    public void message(String msg){
        System.out.println(msg);
    }


    private String userInput(){

        this.scanner = new Scanner(System.in);

        message("Enter your note and press enter");

        String input = this.scanner.nextLine();

        return input;
    }

    public String dateAndNoteForFile(){

        String note = userInput();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateFormatted = formatter.format(date);

        System.out.println("\nFollowing is registered: \n");

        String dateAndNoteRegistered = "date: " + dateFormatted + " note: " + note;
        System.out.println(dateAndNoteRegistered);

        return dateAndNoteRegistered;
    }

    public void saveDateAndNote(String path){

        String dateAndNote = dateAndNoteForFile();

        FileWriter fileWriter = null;

        try{
            List<String> allRegisteredNotes = SaveFile.getAll();

            fileWriter = new FileWriter(path);

            if (allRegisteredNotes.size() == 0){
                fileWriter.write(dateAndNote);
            }

            else {
                String allNotes = "";

                for (String s : allRegisteredNotes){
                    allNotes += s + "\n";
                }

                fileWriter.write(dateAndNote+ "\n" + allNotes);
            }

            fileWriter.close();

        }
        catch (IOException e){
            System.out.println("Something went wrong with writing to file");
        }



    }





}
