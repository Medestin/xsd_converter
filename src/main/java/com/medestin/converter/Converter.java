package com.medestin.converter;

import freemarker.template.*;
import org.w3c.dom.Document;

import java.io.*;
import java.util.Locale;
import java.util.Map;

public final class Converter {
    private final Version version = new Version(2, 3, 29);

    public Configuration cfg(Class rsLoaderClass) throws IOException {
        Configuration cfg = new Configuration(version);

        cfg.setClassForTemplateLoading(rsLoaderClass, "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        return cfg;
    }

    public Template getTemplate(Configuration cfg, String templateName) throws IOException {
        return cfg.getTemplate(templateName);
    }

    public Writer streamWriter(OutputStream outputStream) {
        return new OutputStreamWriter(outputStream);
    }

    public Writer fileWriter(String filename) throws IOException {
        return new FileWriter(new File(filename));
    }

    public void createFromTemplate(Template template, Map<String, Object> dataModel, Writer writer) throws IOException, TemplateException {
           template.process(dataModel, writer);
    }
}
