package bg.sofia.uni.fmi.mjt.file.step;

import bg.sofia.uni.fmi.mjt.file.File;
import bg.sofia.uni.fmi.mjt.file.step.PrintFiles;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrintFilesTest {

    @Test
    void testProcess(){
        Collection<File> files=new ArrayList<>();
        File f1=new File("asdasd");
        File f2=new File("abcd");
        files.add(f1);
        files.add(f2);
        PrintFiles printFiles=new PrintFiles();
        assertEquals(files,printFiles.process(files));
    }

    @Test
    void testProcessNullCollectionThrowsIllegalArgumentException(){
        Collection<File> files=null;
        PrintFiles printFiles=new PrintFiles();
        assertThrows(IllegalArgumentException.class,()->printFiles.process(files),"Collection is null and IllegalArgumentException must be thrown!");
    }
}
