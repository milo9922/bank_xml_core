
public class Account {

    private String iban;
    private String name;
    private long balance;
    private String closingDate;

    public Account(String iban, String name, long balance, String closingDate) {
        this.iban = iban;
        this.name = name;
        this.balance = balance;
        this.closingDate = closingDate;
    }

    public String getIban() {
        return iban;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }
}
