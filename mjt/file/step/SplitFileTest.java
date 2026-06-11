package bg.sofia.uni.fmi.mjt.file.step;

import bg.sofia.uni.fmi.mjt.file.File;
import bg.sofia.uni.fmi.mjt.file.step.SplitFile;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SplitFileTest {

    @Test
    void testProcessRepeatingWords() {
        File file = new File("hello world hello world");
        SplitFile splitFile = new SplitFile();
        assertEquals(2, splitFile.process(file).size());
    }
    @Test
    void testProcessRepeatingNonRepeatingWords() {
        File file = new File("hello world how are you");
        SplitFile splitFile = new SplitFile();
        Set<File> files=new HashSet<>();

        assertEquals(5, splitFile.process(file).size());
    }
    @Test
    void testProcessNullFileThrowsIllegalArgumentException() {
        SplitFile splitFile = new SplitFile();
        assertThrows(IllegalArgumentException.class,()-> splitFile.process(null),"File is null and IllegalArgumentException must be thrown!");
    }
}
