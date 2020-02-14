import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class DataExport {

    public void export(List<Account> accounts) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);

            Element rootElement = doc.createElement("accounts");
            doc.appendChild(rootElement);

            for (Account a : accounts) {
                String ibanTag = "account";
                Element account = doc.createElement(ibanTag);
                account.setAttribute("iban", a.getIban());
                rootElement.appendChild(account);

                Element accName = doc.createElement("name");
                accName.appendChild(doc.createTextNode(a.getName()));
                account.appendChild(accName);

                Element accCurrency = doc.createElement("currency");
                accCurrency.appendChild(doc.createTextNode(a.getCurrency()));
                account.appendChild(accCurrency);

                Element accBalance = doc.createElement("balance");
                accBalance.appendChild(doc.createTextNode(a.getBalance().toString()));
                account.appendChild(accBalance);

                Element accClosing = doc.createElement("closingDate");
                accClosing.appendChild(doc.createTextNode(a.closingDateToString()));
                account.appendChild(accClosing);
            }

            // creating output
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // add indents for "pretty" look
            transformerFactory.setAttribute("indent-number", 2);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/xml/output.xml"));
            transformer.transform(new DOMSource(doc), result);

            transformer.transform(source, result);

            System.out.println("\nFile saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}