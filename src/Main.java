import java.util.List;

public class Main {

    public static void main(String[] args) {
        EncodeXML encodeXML = new EncodeXML();
        Filter filter = new Filter();
        Sort sort = new Sort();
        DataExport export = new DataExport();

        List<Account> list = encodeXML.getDatafromXML();
        filter.byAll(list);
        sort.sortByName(list);
        export.export(list);

    }


    // TODO testy jednostkowe!!!
}
