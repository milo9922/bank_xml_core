import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, ParseException, IOException {
        DecodeXML decodeXML = new DecodeXML();
        Filter filter = new Filter();
        Sort sort = new Sort();
        DataExport export = new DataExport();

        List<Account> list = decodeXML.getDatafromXML();
        filter.byAll(list);
        sort.sortByName(list);
        export.export(list);
    }

}
