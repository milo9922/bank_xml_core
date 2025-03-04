import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DecodeXML {

    private String inputPath = "src/main/xml/input.xml";

    public List<Account> getDatafromXML() throws ParserConfigurationException, IOException, SAXException, ParseException {
        List<Account> accounts = new ArrayList<>();
        File inputFile = new File(inputPath);

        // read xml file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("account");

        // get data from xml file and save as list of accounts
        for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                String iban, name, currency;
                Date closingDate;
                BigDecimal balance;

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    iban = eElement.getAttribute("iban");

                    name = eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent();

                    currency = eElement
                            .getElementsByTagName("currency")
                            .item(0)
                            .getTextContent();

                    balance = new BigDecimal(eElement
                            .getElementsByTagName("balance")
                            .item(0)
                            .getTextContent());

                    closingDate = new SimpleDateFormat("yyyy-MM-dd").parse(eElement
                            .getElementsByTagName("closingDate")
                            .item(0)
                            .getTextContent());

                    Account currentAccount = new Account(iban, name, currency, balance, closingDate);
                    accounts.add(currentAccount);
                }
        }

        return accounts;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
}
