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

    private String outputPath = "src/main/xml/output.xml";

    public void export(List<Account> accounts) {

        try {
            // create xml file
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);

            Element rootElement = doc.createElement("accounts");
            doc.appendChild(rootElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            // add indents for "pretty" look
            transformerFactory.setAttribute("indent-number", 4);
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

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

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(outputPath));
            transformer.transform(source, result);

            System.out.println("\nFile saved!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}