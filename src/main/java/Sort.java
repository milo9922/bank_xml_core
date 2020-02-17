import java.util.Collections;
import java.util.List;

public class Sort {

    public void sortByName(List<Account> accounts) {

        for (int i = 0; i < accounts.size() - 1; i++) {
            for (int j = i + 1; j < accounts.size(); j++) {
                if (accounts.get(i).getName().compareTo(accounts.get(j).getName()) > 0) {
                    Collections.swap(accounts, i, j);
                }
            }
        }
    }


}
