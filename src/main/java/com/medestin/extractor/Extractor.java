package com.medestin.extractor;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public final class Extractor {

    public File loadFile(String filename) {
        String file = ClassLoader.getSystemResource(filename).getFile();
        return new File(file);
    }

    public Document extractDocument(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.normalizeDocument();
        return doc;
    }
}
