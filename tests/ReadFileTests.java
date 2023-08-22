package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import src.ReadFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReadFileTests {
    ReadFile reader;


    @BeforeEach
    public void setup(){
        reader = new ReadFile("./tests/testData/test1.txt");
    }

    @Test
    public void getAll(){

        String[] expected = {"date: 20-08-2023, note: note 1", "date: 21-08-2023, note: note 2", "date: 22-08-2023, note: note 3", "date: 23-08-2023, note: note 4"};
        String[] actual = {};
    
        actual = reader.getAll().toArray(actual);
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {
                    "20-08-2023, note 1",
                    "21-08-2023, note 2",
                    "22-08-2023, note 3",
                    "23-08-2023, note 4"
    })
    public void getSpesificLine(String stringDate, String expected){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        
        String actual = null;
        try {
            actual = reader.getByDate(dateFormat.parse(stringDate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void getNonexsitantDate(){
        String expected = "Date not found";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        String actual = null;
        try {
            Date date = dateFormat.parse("01-08-2023");
            actual = reader.getByDate(date);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertEquals(expected, actual);
    }
}
