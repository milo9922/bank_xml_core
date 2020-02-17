import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {

    private String iban;
    private String name;
    private String currency;
    private BigDecimal balance;
    private Date closingDate;

    public Account(String iban, String name, String currency, BigDecimal balance, Date closingDate) {
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

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public String closingDateToString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(closingDate);
    }

    @Override
    public String toString() {
        return "\nIBAN : " + iban
                + "\nName : " + name
                + "\nCurrency : " + currency
                + "\nBalance : " + balance
                + "\nClosing date : " + closingDateToString();
    }
}
