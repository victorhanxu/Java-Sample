package org.example.xml;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlTest3 {
  public static void main(String arg[]) throws Exception{
    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(getXmlRecord()));

    Document doc = db.parse(is);
    NodeList nodes = doc.getElementsByTagName("ns:faultInfo");

    for (int i = 0; i < nodes.getLength(); i++) {
      Element element = (Element) nodes.item(i);

      NodeList name = element.getElementsByTagName("ns:severity");
      Element line = (Element) name.item(0);
      System.out.println("Severity: " + getCharacterDataFromElement(line));

      NodeList title = element.getElementsByTagName("ns:code");
      line = (Element) title.item(0);
      System.out.println("Code: " + getCharacterDataFromElement(line));

      NodeList addInfo = element.getElementsByTagName("ns:additionalText");
      line = (Element) addInfo.item(0);
      System.out.println("AddInfo: " + getCharacterDataFromElement(line));

      NodeList status = element.getElementsByTagName("ns:status");
      if(status!=null && status.getLength()>0) {
        line = (Element) status.item(0);
        System.out.println("Status: " + getCharacterDataFromElement(line));
      } else {
          System.out.println("Status is null value");
      }
    }

  }

  public static String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
      CharacterData cd = (CharacterData) child;
      return cd.getData();
    }
    return "";
  }

  public static String getXmlRecord () {
    String xmlRecords = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
    "\t<SOAP-ENV:Body>\n" +
    "\t\t<SOAP-ENV:Fault>\n" +
    "\t\t\t<faultcode xmlns=\"\">SOAP-ENV:Server</faultcode>\n" +
    "\t\t\t<faultstring xmlns=\"\">This is an operation implementation generated fault</faultstring>\n" +
    "\t\t\t<faultactor xmlns=\"\"/>\n" +
    "\t\t\t<detail xmlns=\"\">\n" +
    "\t\t\t\t<ns:systemFault xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ns=\"http://xmlns.bmogc.net/bmo/2003/fault/\" xmlns:ns0=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
    "\t\t\t\t\t<ns:subType>HUB</ns:subType>\n" +
    "\t\t\t\t\t<ns:requestID>CHREQ20220914S111613S0330QO</ns:requestID>\n" +
    "\t\t\t\t\t<ns:faultInfo>\n" +
    "\t\t\t\t\t\t<ns:severity>ERROR</ns:severity>\n" +
    "\t\t\t\t\t\t<ns:code>Backend.Connection.Timeout</ns:code>\n" +
    "\t\t\t\t\t\t<ns:additionalText>HUB Error||-||Backend connection timeout waiting for a reply</ns:additionalText>\n" +
    "\t\t\t\t\t\t<ns:parameter>\n" +
    "\t\t\t\t\t\t\t<ns:key>HubTransactionId</ns:key>\n" +
    "\t\t\t\t\t\t\t<ns:value>HubSol091411f189a166-5b94-4009-a7b3-c6dfea56313c</ns:value>\n" +
    "\t\t\t\t\t\t</ns:parameter>\n" +
    "\t\t\t\t\t</ns:faultInfo>\n" +
    "\t\t\t\t</ns:systemFault>\n" +
    "\t\t\t</detail>\n" +
    "\t\t</SOAP-ENV:Fault>\n" +
    "\t</SOAP-ENV:Body>\n" +
    "</SOAP-ENV:Envelope>";

    return xmlRecords;
  }
}