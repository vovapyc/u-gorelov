package com.example.demo;

import com.example.demo.models.Model;
import com.example.demo.models.ResultModel;
import com.example.demo.repository.ResultRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private List<Model> parseCoordinates(String fileName) {
        List<Model> modelList = new ArrayList<>();
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Кореневий елемент: "
                    + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("trkpt");
            // якщо потрібно вибрати усі елементи, скористайтесь
            // параметром методу getElementsByTagName("*");
            System.out.println("Кількість елементів <item>: " + nList.getLength());
            System.out.println("----------------------------");
            for (int i = 0, l = nList.getLength(); i < l; i++) {
                Node nNode = nList.item(i);
                Element element = (Element) nNode;
                String lat = element.getAttribute("lat");
                String lon = element.getAttribute("lon");
                modelList.add(new Model(Double.valueOf(lat), Double.valueOf(lon)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelList;
    }

    @Bean
    public CommandLineRunner demo(ResultRepository repository) {
        return (args) -> {
            List<Model> modelList = this.parseCoordinates("10.gpx");

            for (Model i : modelList) {
                String result = Convert.latLonToString(new Model(i.getLat(), i.getLon()), 90, 180, -180, -90);
                repository.save(new ResultModel(i.getLat(), i.getLon(), result));
            }
        };
    }

}
