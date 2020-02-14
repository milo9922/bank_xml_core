import java.math.BigDecimal;

public class Account {

    private String iban;
    private String name;
    private String currency;
    private BigDecimal balance;
    private String closingDate;

    public Account(String iban, String name, String currency, BigDecimal balance, String closingDate) {
        this.iban = iban;
        this.name = name;
        this.currency = currency;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    @Override
    public String toString() {
        return "\nIBAN : " + iban
                + "\nName : " + name
                + "\nCurrency : " + currency
                + "\nBalance : " + balance
                + "\nClosing date : " + closingDate;
    }
}
