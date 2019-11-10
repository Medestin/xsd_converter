package com.medestin.converter.extractor;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ExtractorTest {


    @Test
    void loadFile_loadsFile_properFile(){
        // Given
        Extractor extractor = new Extractor();
        String filename = "schema.xsd";

        // When
        File result = extractor.loadFile(filename);

        // Then
        assertNotNull(result);
    }

    @Test
    void loadFile_throwsNullPointerEx_improperFile(){
        // Given
        Extractor extractor = new Extractor();
        String filename = "invalid.file";

        // When & Then - expect exception to be thrown
        assertThrows(NullPointerException.class, () -> extractor.loadFile(filename));
    }

}