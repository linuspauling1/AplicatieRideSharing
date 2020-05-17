package DOM;

import dataStructures.Client;
import dataStructures.ComandaNepreluata;
import graphicalUserInterface.driverPage.ListaComenzi;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

    private static Document doc;
    private static DocumentBuilder builder;
    private static Element element;
    private static ArrayList<ComandaNepreluata> comenzi;

    public static void citireInformatiiXML() {
        comenzi = new ArrayList<>();
        File inputFile = new File("C:\\XML\\data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("comanda");
            for(int i = 0;i < nList.getLength();++i) {
                Node nNode = nList.item(i);
                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    NodeList lList = eElement.getChildNodes();
                    Client cl = null;
                    String destinatie = "";
                    String loc = "";
                    int an = 0,luna = 0, zi = 0, ora = 0, minut = 0;
                    for(int j = 0;j < lList.getLength();++j) {
                        Node cChild = lList.item(j);
                        if(cChild.getNodeName() != "data") {
                            switch(cChild.getNodeName()){
                                case "userClient":
                                    cl = jsonClasses.JSONClient.findClient(cChild.getTextContent());
                                    break;
                                case "destinatie":
                                    destinatie = cChild.getTextContent();
                                    break;
                                case "loc":
                                    loc = cChild.getTextContent();
                                    break;
                                default:
                                    System.out.println("ceva lipseste!");
                            }

                        }
                        else {
                            NodeList sublist = cChild.getChildNodes();
                            for(int k = 0;k < sublist.getLength();++k) {
                                Node subchild = sublist.item(k);
                                switch (subchild.getNodeName()) {
                                    case "an":
                                        an = Integer.parseInt(subchild.getTextContent());
                                        break;
                                    case "luna":
                                        luna = Integer.parseInt(subchild.getTextContent());
                                        break;
                                    case "zi":
                                        zi = Integer.parseInt(subchild.getTextContent());
                                        break;
                                    case "ora":
                                        ora = Integer.parseInt(subchild.getTextContent());
                                        break;
                                    case "minut":
                                        minut = Integer.parseInt(subchild.getTextContent());
                                        break;
                                    default:
                                        System.out.println("ciudat");
                                }
                            }
                        }
                    }
                    ComandaNepreluata cn = new ComandaNepreluata(cl,an,luna,zi,ora,minut,loc,destinatie);
                    comenzi.add(cn);
                    new ListaComenzi(comenzi);
                }
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void adaugareInformatiiXML(ComandaNepreluata c) {
        Element comanda = doc.createElement("comanda");
        element.appendChild(comanda);
        //setare atribut
        Attr attr = doc.createAttribute("status");
        attr.setValue("nepreluate");
        element.setAttributeNode(attr);
        //incep elementele subarborelui
        Element user = doc.createElement("userClient");
        user.appendChild(doc.createTextNode(c.getUsernameClient()));
        comanda.appendChild(user);

        Element d = doc.createElement("destinatie");
        d.appendChild(doc.createTextNode(c.getDestinatie()));
        comanda.appendChild(d);

        Element lc = doc.createElement("loc");
        lc.appendChild(doc.createTextNode(c.getLocatie()));
        comanda.appendChild(lc);

        Element data = doc.createElement("data");
        comanda.appendChild(data);

        Element a = doc.createElement("an");
        a.appendChild(doc.createTextNode(Integer.toString(c.getAn())));
        data.appendChild(a);

        Element l = doc.createElement("luna");
        l.appendChild(doc.createTextNode(Integer.toString(c.getLuna())));
        data.appendChild(l);

        Element z = doc.createElement("zi");
        z.appendChild(doc.createTextNode(Integer.toString(c.getZi())));
        data.appendChild(z);

        Element o = doc.createElement("ora");
        o.appendChild(doc.createTextNode(Integer.toString(c.getOra())));
        data.appendChild(o);

        Element m = doc.createElement("minut");
        m.appendChild(doc.createTextNode(Integer.toString(c.getMinut())));
        data.appendChild(m);

    }

    public static void eliminareNod(String userClient,String destinatie,String loc,
                                    int an,int luna,int zi,int ora,int minut) {
        NodeList comenziList = doc.getElementsByTagName("comanda");
        for(int i = 0;i < comenziList.getLength();++i) {
            Node p = comenziList.item(i);
            if(p.getNodeType()==Node.ELEMENT_NODE) {
                Element com = (Element)p;
                NodeList nameList = com.getChildNodes();
                for(int j = 0;j<nameList.getLength();++j) {
                    Node n = nameList.item(j);
                    if(n.getNodeType()==Node.ELEMENT_NODE) {
                        Element name = (Element) n;
                        if(name.getTagName() == "userClient" & name.getTextContent() != userClient)
                            break;
                        else if(name.getTagName() == "destinatie" & name.getTextContent() != destinatie)
                            break;
                        else if(name.getTagName() == "loc" & name.getTextContent() != loc)
                            break;
                        else if(name.getTagName() == "data") {
                            NodeList noduri = name.getChildNodes();
                            if(!noduri.item(0).getTextContent().equals(Integer.toString(an)))
                                break;
                            if(!noduri.item(1).getTextContent().equals(Integer.toString(luna)))
                                break;
                            if(!noduri.item(2).getTextContent().equals(Integer.toString(zi)))
                                break;
                            if(!noduri.item(3).getTextContent().equals(Integer.toString(ora)))
                                break;
                            if(!noduri.item(4).getTextContent().equals(Integer.toString(minut)))
                                break;
                            p.getParentNode().removeChild(p);
                        }
                    }
                }
            }
        }
    }

    public static void createXML(ArrayList<ComandaNepreluata> c) {// creare fisier XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.newDocument();

            element = doc.createElement("comenzi");
            doc.appendChild(element);

            for(ComandaNepreluata tmp:c)
                adaugareInformatiiXML(tmp);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult streamResult = new StreamResult(new File("C:\\XML\\data.xml"));
            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException e) {;
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}