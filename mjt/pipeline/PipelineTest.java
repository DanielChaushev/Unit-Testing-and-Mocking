package bg.sofia.uni.fmi.mjt.pipeline;

import bg.sofia.uni.fmi.mjt.pipeline.stage.Stage;
import bg.sofia.uni.fmi.mjt.pipeline.step.Step;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PipelineTest {
    @Mock
    private Cache cache;
    @Mock
    private Stage stage;
    @Mock
    private Step<String, String> step;
    private Pipeline pipeline;

    @Test
    void testStartNullInitialStageThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Pipeline.start(null), "Initial stage is null and IllegalArgumentException must be thrown!");
    }

    @Test
    void testPipelineNullStagesThrowsIllegalArgumentException() {
        Cache cache = new Cache();
        cache.cacheValue("key1", "value1");
        assertThrows(IllegalArgumentException.class, () -> pipeline = new Pipeline<>(null, cache), "Stages is null and IllegalArgumentException must be thrown!");
    }

    @Test
    void testPipelineNullCacheThrowsIllegalArgumentException() {
        Stage<String, String> stage = Stage.start(step);
        List<Stage<?, ?>> stages = new ArrayList<>();
        stages.add(stage);
        assertThrows(IllegalArgumentException.class, () -> pipeline = new Pipeline<>(stages, null), "Cache is null and IllegalArgumentException must be thrown!");
    }

    @Test
    void testAddStageNullStageThrowsIllegalArgumentException(){
        Stage<String, String> stage = Stage.start(step);
        List<Stage<?, ?>> stages = new ArrayList<>();
        stages.add(stage);
        pipeline = new Pipeline<>(stages, cache);
        assertThrows(IllegalArgumentException.class,()->pipeline.addStage(null),"Stage is null and IllegalArgumentException must be thrown!");

    }
    @Test
    void testAddStage() {
        List<Stage<?, ?>> stages = new ArrayList<>();
        stages.add(stage);
        Pipeline<String, String> pipeline = new Pipeline<>(stages, cache);
        pipeline.addStage(stage);
        verify(cache).clear();
    }
    @Test
    void testExecuteReturnsCachedResult() {
        when(cache.containsKey("Input")).thenReturn(true);
        when(cache.getCachedValue("Input")).thenReturn("CachedOutput");
        Stage<String, String> stage = Stage.start(step);
        List<Stage<?, ?>> stages = new ArrayList<>();
        stages.add(stage);
        Pipeline<String, String> pipeline = new Pipeline<>(stages, cache);
        assertEquals("CachedOutput", pipeline.execute("Input"));
    }

    @Test
    void testExecute() {
        when(step.process("Input")).thenReturn("Output");
        Stage<String, String> stageReal = Stage.start(step);
        List<Stage<?, ?>> stages = new ArrayList<>();
        stages.add(stageReal);
        when(cache.containsKey("Input")).thenReturn(false);
        Pipeline<String, String> pipeline = new Pipeline<>(stages, cache);
        assertEquals("Output", pipeline.execute("Input"));
    }
}
