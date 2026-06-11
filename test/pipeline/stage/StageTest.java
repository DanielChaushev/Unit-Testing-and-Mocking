package bg.sofia.uni.fmi.mjt.pipeline.stage;

import bg.sofia.uni.fmi.mjt.pipeline.step.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StageTest {

    @Mock
    private Step<String, String> step;
    @Mock
    private Step<String, String> step2;


    @Test
    void testStartNullInitialStepThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Stage.start(null), "Initial step is null and IllegalArgumentException must be thrown!");

    }

    @Test
    void testAddStepNullStepThrowsIllegalArgumentException() {
        Stage<String, String> stage = Stage.start(step);
        assertThrows(IllegalArgumentException.class, () -> stage.addStep(null), "Step is null and IllegalArgumentException must be thrown!");
    }

    @Test
    void testAddStep(){
        when(step.process("Input")).thenReturn("Output");
        Stage<String, String> stage = Stage.start(step);
        when(step2.process("Output")).thenReturn("FinalOutput");
        stage.addStep(step2);
        assertEquals("FinalOutput",stage.execute("Input"));
    }
    @Test
    void testExecute() {
        when(step.process("Input")).thenReturn("Output");
        Stage<String, String> stage = Stage.start(step);
        assertEquals("Output", stage.execute("Input"));
    }


}
