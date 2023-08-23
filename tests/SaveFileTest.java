import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveFileTest {

    SaveFile saveFile;
    @BeforeEach
    void setUp() {
        saveFile = new SaveFile();
    }

    @Test
    void dateAndNoteForFile() {

        String expected = "date: 23-08-2023, note: tr";

        String actual = saveFile.dateAndNoteForFile("tr");

        assertEquals(expected, actual);

    }

    @Test
    void saveDateAndNote() {
    }
}