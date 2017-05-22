package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        StringWriter writer = new StringWriter();
        try {
            File tmp = File.createTempFile("tmp", "xml");
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, tmp);
            BufferedReader reader = new BufferedReader(new FileReader(tmp));
            while (reader.ready()) {
                String line = reader.readLine().trim();
                if (line.startsWith("<" + tagName))
                    writer.write("<!--" + comment + "-->");
                writer.write(line);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static void main(String[] args) {
    }
}
