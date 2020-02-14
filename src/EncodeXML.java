import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EncodeXML {

    public List<Account> getDatafromXML() {
        List<Account> accounts = new ArrayList<>();

        try {
            File inputFile = new File("src/xml/input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("account");

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return accounts;
    }

}
