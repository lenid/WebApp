package gran.home.template.dao;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DriverManagerDataSourceOwnImpl extends DriverManagerDataSource {

	private static final String USER = "javax.persistence.jdbc.user";
	private static final String PASSWORD = "javax.persistence.jdbc.password";
	private static final String DRIVER = "javax.persistence.jdbc.driver";
	private static final String URL = "javax.persistence.jdbc.url";

	public DriverManagerDataSourceOwnImpl(String persistenceXmlPath) throws ParserConfigurationException, SAXException, IOException {
		Document doc = getDocument(persistenceXmlPath);
		NodeList nList = doc.getElementsByTagName("property");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				String propertyName = eElement.getAttribute("name");
				switch (propertyName) {
				case USER:
					setUsername(eElement.getAttribute("value"));
					break;
				case PASSWORD:
					setPassword(eElement.getAttribute("value"));
					break;
				case DRIVER:
					setDriverClassName(eElement.getAttribute("value"));
					break;
				case URL:
					setUrl(eElement.getAttribute("value"));
					break;
				}
			}
		}
	}

	private Document getDocument(String name) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File(name);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		return dBuilder.parse(fXmlFile);
	}

}
