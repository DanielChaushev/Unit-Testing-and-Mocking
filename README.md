# Unit-Testing-and-Mocking
JUnit and Mockito tests for a generic data processing pipeline — bug discovery and test-driven fixes.
# Poor Man's Jenkins – Unit Testing and Mocking

A university assignment focused on writing JUnit tests and using Mockito for mocking
to discover and fix bugs in an existing implementation of a generic data processing pipeline.

## Structure

### Source (`src`)
- `pipeline/Pipeline` — generic pipeline with caching
- `pipeline/stage/Stage` — sequence of steps
- `pipeline/step/Step` — interface for a single processing unit
- `pipeline/Cache` — in-memory cache for pipeline results
- `file/File` — in-memory representation of a text file
- `file/exception/EmptyFileException` — thrown when a file is empty or null
- `file/step/UpperCaseFile` — converts file content to uppercase
- `file/step/CheckEmptyFile` — validates that a file is not empty
- `file/step/SplitFile` — splits file content by whitespace
- `file/step/CountFiles` — counts files in a collection
- `file/step/PrintFiles` — prints file contents

### Tests (`test`)
- `pipeline/PipelineTest` — tests for Pipeline with mocked Cache
- `pipeline/stage/StageTest` — tests for Stage with mocked Step
- `file/FileTest` — tests for File constructor validation
- `pipeline/CacheTest` — tests for Cache validation and behavior
- `file/step/UpperCaseFileTest`, `CheckEmptyFileTest`, `SplitFileTest`, `CountFilesTest`, `PrintFilesTest`

## Bugs found and fixed

- `UpperCaseFile` — result of `toUpperCase()` was not saved back to the file
- `CheckEmptyFile` — was throwing `IllegalArgumentException` instead of `EmptyFileException`
- `Pipeline.addStage()` — cache was not cleared when a new stage was added
- `Pipeline.start()` — missing null validation
- `Stage.start()` and `Stage.addStep()` — missing null validation
- `File` constructor — missing null validation for content
- `Cache.cacheValue()` — missing null validation for key and value

## Notes

- Tests written with JUnit 5 and Mockito
- Cache is mocked in Pipeline tests to verify interactions
- Java Stream API and lambdas are not used
