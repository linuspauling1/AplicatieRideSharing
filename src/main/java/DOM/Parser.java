package DOM;

import dataStructures.Client;
import dataStructures.ComandaEfectuata;
import dataStructures.ComandaNepreluata;
import dataStructures.Sofer;
import graphicalUserInterface.driverPage.DriverPage;
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
    private static ArrayList<ComandaEfectuata> efectuate;

    public static void citireInformatiiXML() {
        comenzi = new ArrayList<>();
        File inputFile = new File("src/data.xml");
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
                    int an = 0,luna = 0, zi = 0, ora = 0, minut = 0,secunda = 0;
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
                                    case "secunda":
                                        secunda = Integer.parseInt(subchild.getTextContent());
                                        break;
                                    default:
                                        System.out.println("ciudat");
                                }
                            }
                        }
                    }
                    ComandaNepreluata cn = new ComandaNepreluata(cl,an,luna,zi,ora,minut,secunda,loc,destinatie);
                    comenzi.add(cn);
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

    public static void afisareXML(){
        citireInformatiiXML();
        new ListaComenzi(comenzi);
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

        Element s = doc.createElement("secunda");
        s.appendChild(doc.createTextNode(Integer.toString(c.getSecunda())));
        data.appendChild(s);

    }

    public static void citireInformatiiXMLEfectuate(){
        efectuate = new ArrayList<>();
        File inputFile = new File("src/completed.xml");
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
                    Sofer sofer = null;
                    int pret = 0;
                    int distanta = 0;
                    int an = 0,luna = 0, zi = 0, ora = 0, minut = 0,secunda = 0;
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
                                case "pret":
                                    pret = Integer.parseInt(cChild.getTextContent());
                                    break;
                                case "distanta":
                                    distanta = Integer.parseInt(cChild.getTextContent());
                                    break;
                                case "sofer":
                                    sofer = DriverPage.getSofer();
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
                                    case "secunda":
                                        secunda = Integer.parseInt(subchild.getTextContent());
                                        break;
                                    default:
                                        System.out.println("ciudat");
                                }
                            }
                        }
                    }
                    ComandaEfectuata ce = new ComandaEfectuata(cl,an,luna,zi,ora,minut,secunda,loc,destinatie,
                            sofer,pret,distanta);
                    efectuate.add(ce);
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

    public static void adaugareInformatiiXMLEfectuate(ComandaEfectuata c) {
        Element comanda = doc.createElement("comanda");
        element.appendChild(comanda);
        //setare atribut
        Attr attr = doc.createAttribute("status");
        attr.setValue("preluate");
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

        Element s = doc.createElement("secunda");
        s.appendChild(doc.createTextNode(Integer.toString(c.getSecunda())));
        data.appendChild(s);

        Element pret = doc.createElement("pret");
        pret.appendChild(doc.createTextNode(Integer.toString(c.getPret())));
        comanda.appendChild(pret);

        Element distanta = doc.createElement("distanta");
        distanta.appendChild(doc.createTextNode(Integer.toString(c.getDistanta())));
        comanda.appendChild(distanta);

        Element sofer = doc.createElement("sofer");
        sofer.appendChild(doc.createTextNode(c.getUsernameSofer()));
        comanda.appendChild(sofer);

    }

    public static void createXML(ComandaNepreluata c) {// creare fisier XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.newDocument();

            element = doc.createElement("comenzi");
            doc.appendChild(element);

            citireInformatiiXML();
            for(ComandaNepreluata tmp:comenzi)
                adaugareInformatiiXML(tmp);
            adaugareInformatiiXML(c);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult streamResult = new StreamResult("src/data.xml");
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

    public static void createXMLEfectuate(ComandaEfectuata c) {// creare fisier XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.newDocument();

            element = doc.createElement("comenzi");
            doc.appendChild(element);

            citireInformatiiXMLEfectuate();
            for(ComandaEfectuata tmp:efectuate)
                adaugareInformatiiXMLEfectuate(tmp);
            adaugareInformatiiXMLEfectuate(c);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult streamResult = new StreamResult("src/completed.xml");
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

    public static void delete(ComandaNepreluata c) {// eliminare din fisier XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.newDocument();

            element = doc.createElement("comenzi");
            doc.appendChild(element);

            citireInformatiiXML();
            for(ComandaNepreluata tmp:comenzi)
                if(!tmp.equals(c))
                    adaugareInformatiiXML(tmp);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult streamResult = new StreamResult("src/data.xml");
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
    public static void deleteEfectuate(ComandaEfectuata c) {// eliminare din fisier XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.newDocument();

            element = doc.createElement("comenzi");
            doc.appendChild(element);

            citireInformatiiXMLEfectuate();
            for(ComandaEfectuata tmp:efectuate)
                if(tmp.getPret() != 0)
                    adaugareInformatiiXMLEfectuate(tmp);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult streamResult = new StreamResult("src/completed.xml");
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