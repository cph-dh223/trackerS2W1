import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
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




    public String dateAndNoteForFile(String userInput){

        String note = userInput;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String dateFormatted = formatter.format(date);

        System.out.println("\nFollowing is registered: \n");

        String dateAndNoteRegistered = "date: " + dateFormatted + ", note: " + note;
        System.out.println(dateAndNoteRegistered);

        return dateAndNoteRegistered;
    }

    public void saveDateAndNote(String path, String userInput){

        String dateAndNote = dateAndNoteForFile(userInput);

        FileWriter fileWriter = null;

        ReadFile filereader = new ReadFile();

        try{
            List<String> allRegisteredNotes = filereader.getAll();

            fileWriter = new FileWriter(path);

            if (allRegisteredNotes.size() == 0){
                fileWriter.write(dateAndNote);
            }
            else {
                String allNotes = "";

                for (String s : allRegisteredNotes){
                    allNotes += s + "\n";
                }
                fileWriter.write(dateAndNote + "\n" + allNotes);
            }
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("Something went wrong with saving the data");
        }
    }
}
