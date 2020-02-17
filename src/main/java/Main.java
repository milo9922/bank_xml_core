import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, ParseException, IOException {
        EncodeXML encodeXML = new EncodeXML();
        Filter filter = new Filter();
        Sort sort = new Sort();
        DataExport export = new DataExport();

        String inputPath = "src/main/xml/input.xml";
        List<Account> list = encodeXML.getDatafromXML(inputPath);
        filter.byAll(list);
        sort.sortByName(list);
        export.export(list);

    }


    // TODO testy jednostkowe!!!
}
