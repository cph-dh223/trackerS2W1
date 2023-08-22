package src;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;

public class ReadFile {
    private File file;

    public ReadFile(String path){
        file = new File(path);
    }

    public List<String> getAll() {
        List<String> input = new ArrayList<>();
        Scanner scanner;
        try{
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            
        } catch (Exception e){
            System.out.println("something went wrong");
        }
        return input;
    }

    /**
     * this is the lazy way to do this, a bedere way is to split every line when reading and end when right date is hit
     * 
     * @param date
     * @return
     */
    public String getByDate(Date date) {
        List<String[]> lines = new ArrayList<>();
        for(String s : getAll()){
            ;
            lines.add(s.replace("date: ","").replace("note: ", "").split(", "));
        }
        boolean found = false;
        int index = 0;
        int stepsize = lines.size()/2;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        while(!found){ //Binary seach
            String[] line = lines.get(index);
            try {
                if(date.equals(dateFormat.parse(line[0]))) {return line[1];}
                if(date.before(dateFormat.parse(line[0]))){
                    index -= stepsize;
                } else {
                    index += stepsize;
                }
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (stepsize == 0 || index < 0) {return "Date not found";}
            stepsize /=2 ;
        }
        return "Date not found";
    }
}
