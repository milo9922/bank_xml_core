import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filter {

    public void byCurrency(List<Account> accounts) {
        accounts.removeIf(a -> !a.getCurrency().equals("PLN"));
    }

    public void byBalance(List<Account> accounts) {
        accounts.removeIf(a -> a.getBalance().compareTo(BigDecimal.ZERO) < 0);
    }

    public void byDate(List<Account> accounts) {
        accounts.removeIf(a -> a.getClosingDate().before(new Date()));
    }

    public void byIban(List<Account> accounts) {
        List<Account> toRemove = new ArrayList<>();

        for (Account a : accounts) {
            String currentIban = a.getIban();
            if (currentIban.length() != 28) {
                toRemove.add(a);
            } else {
                char[] ibanArray = currentIban.substring(2).toCharArray();

                for (char c : ibanArray) {
                    if (Character.getNumericValue(c) < 0 || Character.getNumericValue(c) > 9) {
                        toRemove.add(a);
                        break;
                    }
                }
            }
        }

        accounts.removeAll(toRemove);
    }


    public void byAll(List<Account> accounts) {
        byCurrency(accounts);
        byBalance(accounts);
        byDate(accounts);
        byIban(accounts);
    }
}
