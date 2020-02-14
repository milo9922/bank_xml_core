import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class AccountsHandler {

   /* private List<Account> accounts = null;
    private Account account = null;
    private StringBuilder stringBuilder = null;*/

    public void parseXML() {

        try {
            File inputFile = new File("src/xml/input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("account");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Account iban : "
                            + eElement.getAttribute("iban"));
                    System.out.println("name : "
                            + eElement
                            .getElementsByTagName("name")
                            .item(0)
                            .getTextContent());
                    System.out.println("currency : "
                            + eElement
                            .getElementsByTagName("currency")
                            .item(0)
                            .getTextContent());
                    System.out.println("balance : "
                            + eElement
                            .getElementsByTagName("balance")
                            .item(0)
                            .getTextContent());
                    System.out.println("closing date : "
                            + eElement
                            .getElementsByTagName("closingDate")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public List<Account> getAccounts() {
        return accounts;
    }
*/
}
