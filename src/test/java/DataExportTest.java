import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class DataExportTest {

    @Test(expected = java.io.FileNotFoundException.class)
    public void fileNotFoundTest() throws ParserConfigurationException, SAXException, ParseException, IOException {
        // given
        EncodeXML encodeXML = new EncodeXML();
        String path = "src/main/xml/wrongInput.xml";

        // when
        encodeXML.getDatafromXML(path);
    }

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test(expected = SAXParseException.class)
    public void emptyFileTest() throws ParserConfigurationException, SAXException, ParseException, IOException {
        // given
        final File tempXml = temporaryFolder.newFile("emptyFile.xml");
        EncodeXML encodeXML = new EncodeXML();

        // when
        encodeXML.getDatafromXML(tempXml.getPath());
    }

}
