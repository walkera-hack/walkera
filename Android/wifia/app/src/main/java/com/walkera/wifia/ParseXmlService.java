package com.walkera.wifia;

import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXmlService {
    public HashMap<String, String> parseXml(InputStream inStream) throws Exception {
        HashMap<String, String> hashMap = new HashMap();
        NodeList childNodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inStream).getDocumentElement().getChildNodes();
        for (int j = 0; j < childNodes.getLength(); j++) {
            Node childNode = childNodes.item(j);
            if (childNode.getNodeType() == (short) 1) {
                Element childElement = (Element) childNode;
                if ("version".equals(childElement.getNodeName())) {
                    hashMap.put("version", childElement.getFirstChild().getNodeValue());
                } else if ("name".equals(childElement.getNodeName())) {
                    hashMap.put("name", childElement.getFirstChild().getNodeValue());
                } else if ("url".equals(childElement.getNodeName())) {
                    hashMap.put("url", childElement.getFirstChild().getNodeValue());
                }
            }
        }
        return hashMap;
    }
}
