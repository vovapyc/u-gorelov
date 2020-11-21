import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
public class Count {
    public static void main(String[] args) {
        List<Model> modelList = new ArrayList<>();
        try {
            File inputFile = new File("10.gpx");
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
                modelList.add(new Model(Double.valueOf(lat),Double.valueOf(lon)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(modelList.size());
        System.out.println(Convert.latLonToString(new Model(-20,-20),90,180,-180,-90));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sss");
        stringBuilder.append("fff");
        System.out.println(stringBuilder.toString());

    }
}