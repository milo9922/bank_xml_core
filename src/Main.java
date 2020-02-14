import java.util.List;

public class Main {

    public static void main(String[] args) {

        AccountsHandler accountsHandler = new AccountsHandler();
        List<Account> list = accountsHandler.getDatafromXML();
        for (Account a : list) {
            System.out.println(a.toString());
        }
    }

    // TODO: wczytanie danych
    // TODO: odrzucenie kont z walutą inną niż PLN
    // TODO: odrzucenie kont z saldem poniżej zera
    // TODO: odrzucenie kont z datą zamknięcia wcześniejszą niż data bieżąca
    // TODO: odrzucenie kont z numerem IBAN nieprawidłowym dla polskich kont bankowych
    // TODO: posortowanie rosnąco wg nazwy rachunku
    // TODO: testy jednostkowe!!!
}
