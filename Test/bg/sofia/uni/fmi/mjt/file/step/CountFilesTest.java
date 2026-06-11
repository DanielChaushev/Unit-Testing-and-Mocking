package bg.sofia.uni.fmi.mjt.file.step;

import bg.sofia.uni.fmi.mjt.file.File;
import bg.sofia.uni.fmi.mjt.file.step.CountFiles;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountFilesTest {

    @Test
    void testProcess(){
        Collection<File> files=new ArrayList<>();
        File f1=new File("asdasd");
        File f2=new File("abcd");
        files.add(f1);
        files.add(f2);
        CountFiles countFiles=new CountFiles();
        assertEquals(2,countFiles.process(files));
    }

    @Test
    void testProcessNullCollectionThrowsIllegalArgumentException(){
        CountFiles countFiles=new CountFiles();
        assertThrows(IllegalArgumentException.class,()->countFiles.process(null),"Collection is null and IllegalArgumentException must be thrown!");
    }
}
