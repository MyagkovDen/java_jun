package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class StudentUtils {

    public static final String FILE_JSON = "file.json";
    public static final String FILE_XML = "file.xml";
    public static final String FILE_BIN = "file.bin";
    static ObjectMapper objectMapper = new ObjectMapper();
    static XmlMapper xmlMapper = new XmlMapper();

    public static void convertToFile(String fileName, Student student) throws IOException {
        if (fileName.endsWith(".bin")) {
            try (FileOutputStream outputStream = new FileOutputStream(FILE_BIN);
                 ObjectOutputStream oos = new ObjectOutputStream(outputStream)) {
                oos.writeObject(student);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (fileName.endsWith(".json")) {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(FILE_JSON), student);
        } else if (fileName.endsWith(".xml")) {
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(new File(FILE_XML), student);
        }
    }

    public static Student convertToObject(String fileName) throws IOException {
        Student student = null;
        if (fileName.endsWith(".bin")) {
            try (FileInputStream inputStream = new FileInputStream(fileName);
                 ObjectInputStream ois = new ObjectInputStream(inputStream)) {
                student = (Student) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        } else if (fileName.endsWith(".json")) {
            student = objectMapper.readValue(new File(fileName), Student.class);
        } else if (fileName.endsWith(".xml")) {
            student = xmlMapper.readValue(new File(fileName), Student.class);
        }
        return student;
    }
}
