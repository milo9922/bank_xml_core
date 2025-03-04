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
        DecodeXML decodeXML = new DecodeXML();
        String path = "src/main/xml/wrongInput.xml";

        // when
        decodeXML.setInputPath(path);
        decodeXML.getDatafromXML();
    }

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test(expected = SAXParseException.class)
    public void emptyFileTest() throws ParserConfigurationException, SAXException, ParseException, IOException {
        // given
        final File tempXml = temporaryFolder.newFile("emptyFile.xml");
        DecodeXML decodeXML = new DecodeXML();
        decodeXML.setInputPath(tempXml.getPath());

        // when
        decodeXML.getDatafromXML();
    }


}
