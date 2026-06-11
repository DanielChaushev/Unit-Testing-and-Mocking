package bg.sofia.uni.fmi.mjt.file.step;

import bg.sofia.uni.fmi.mjt.file.File;
import bg.sofia.uni.fmi.mjt.file.exception.EmptyFileException;
import bg.sofia.uni.fmi.mjt.file.step.UpperCaseFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UpperCaseFileTest {

    @Test
    void testProcess() {
        File file = new File("abcd");
        UpperCaseFile upperCaseFile = new UpperCaseFile();
        File result = upperCaseFile.process(file);
        assertEquals("ABCD", result.getContent());
    }


    @Test
    void testProcessNullFileThrowsEmptyFileException() {
        UpperCaseFile upperCaseFile = new UpperCaseFile();
        assertThrows(IllegalArgumentException.class, () -> upperCaseFile.process(null), "File is null and IllegalArgumentException must be thrown!");
    }
}
