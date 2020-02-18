import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortTest {

    @Test
    public void sortByNameTest() throws ParseException {
        // given
        Sort sort = new Sort();
        final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

        Account account1 = new Account("PL61109010140000071219812871", "name2", "PLN", BigDecimal.valueOf(4500), SDF.parse("2016-04-14"));
        Account account2 = new Account("PL27114020040000300201355387", "name6", "PLN", BigDecimal.valueOf(2000.60), SDF.parse("2035-03-11"));
        Account account3 = new Account("MC5813488000010051108001292", "moroccan", "MAD", BigDecimal.valueOf(8800.60), SDF.parse("2020-03-13"));
        Account account4 = new Account("IT60X0542811101000000123456", "italian", "EUR", BigDecimal.valueOf(2000.60), SDF.parse("2013-03-11"));
        Account account5 = new Account("PLL1109010140000K71219812871", "name3", "PLN", BigDecimal.valueOf(4500), SDF.parse("2016-04-14"));
        Account account6 = new Account("PLL1109010140000K71219812871123123213", "name4", "PLN", BigDecimal.valueOf(4500), SDF.parse("2039-04-14"));
        Account account7 = new Account("PL110901014", "name5", "PLN", BigDecimal.valueOf(4500), SDF.parse("2020-04-14"));
        Account account8 = new Account("PL27114020040000300201355387", "name1", "PLN", BigDecimal.valueOf(-200), SDF.parse("2021-11-15"));

        List<Account> accounts = new LinkedList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        accounts.add(account6);
        accounts.add(account7);
        accounts.add(account8);

        List<Account> expectedAccounts = new LinkedList<>();
        expectedAccounts.add(account4);
        expectedAccounts.add(account3);
        expectedAccounts.add(account8);
        expectedAccounts.add(account1);
        expectedAccounts.add(account5);
        expectedAccounts.add(account6);
        expectedAccounts.add(account7);
        expectedAccounts.add(account2);

        // when
        sort.sortByName(accounts);

        // then
        assertEquals(expectedAccounts, accounts);
    }
}
