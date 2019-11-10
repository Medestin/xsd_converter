package com.medestin;

import com.medestin.converter.Converter;
import com.medestin.extractor.Extractor;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TemplateException {
        Extractor extractor = new Extractor();
        File file = extractor.loadFile("schema.xsd");
        Document doc = extractor.extractDocument(file);

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("doc", doc);

        Converter converter = new Converter();
        Configuration cfg = converter.cfg(Main.class);
        Template template = converter.getTemplate(cfg, "schema.ftl");
        Writer writer = converter.streamWriter(System.out);
        converter.createFromTemplate(template, dataModel, writer);
    }


}
