package com.medestin.extractor;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

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

    @Test
    void extractDocument_returnsDocument_properFile() throws IOException, SAXException, ParserConfigurationException {
        // Given
        Extractor extractor = new Extractor();
        File file = new File(ClassLoader.getSystemResource("schema.xsd").getFile());

        // When
        Document doc = extractor.extractDocument(file);

        // Then
        assertNotNull(doc);
    }
}