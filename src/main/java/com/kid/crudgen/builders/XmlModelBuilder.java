package com.kid.crudgen.builders;

import com.kid.crudgen.model.Model;
import com.kid.crudgen.model.Requisite;
import com.kid.crudgen.model.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlModelBuilder implements ModelBuilder {

    Model model;
    String path;

    public Model getModel() {

        Model model = null;

        try {
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            String name = doc.getElementsByTagName("name").item(0).getTextContent();
            String shortName = doc.getElementsByTagName("shortName").item(0).getTextContent();

            NodeList type = doc.getElementsByTagName("type");

            Map<String,Type> types = new HashMap<String,Type>();

            for (int i = 0; i < type.getLength(); i++) {

                Node nNode = type.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String typeName = eElement.getAttribute("name");
                    String typeShortName = eElement.getAttribute("shortName");
                    String typeDbType = eElement.getAttribute("dbType");
                    String typeJavaType = eElement.getAttribute("javaType");

                    types.put(typeShortName,new Type(typeName, typeShortName, typeDbType, typeJavaType));

                }
            }

            NodeList requisite = doc.getElementsByTagName("requisite");

            List<Requisite> requisites = new ArrayList<Requisite>();

            for (int i = 0; i < requisite.getLength(); i++) {

                Node nNode = requisite.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String requisiteName = eElement.getAttribute("name");
                    String requisiteShortName = eElement.getAttribute("shortName");
                    String requisiteType = eElement.getAttribute("type");

                    requisites.add(new Requisite(requisiteName,requisiteShortName,types.get(requisiteType)));

                }
            }

            model = new Model(name, shortName, requisites);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

    public void saveModel(Model model) {

    }

    public XmlModelBuilder(String path){
        this(null, path);
    }

    public XmlModelBuilder(Model model, String path){
        this.model = model;
        this.path = path;
    }
}
