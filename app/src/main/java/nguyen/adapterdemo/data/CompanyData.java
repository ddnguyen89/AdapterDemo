package nguyen.adapterdemo.data;

import java.util.ArrayList;
import java.util.List;
import nguyen.adapterdemo.R;

/**
 * Created by 660253185 on 12/4/2017.
 */

public class CompanyData {

    //an array of companies
    private List<Company> mCompanies = new ArrayList<Company>();

    //get the companies data
    public List<Company> getmCompanies() {
        return mCompanies;
    }

    public CompanyData() {

        addItem(new Company("Android", R.drawable.android, "1-800-111-1111", "http://www.android.com", "support@android.com"));
        addItem(new Company("Microsoft", R.drawable.microsoft, "1-800-222-2222", "http://www.microsoft.com", "support@microsoft.com"));
        addItem(new Company("Ebay", R.drawable.ebay, "1-800-333-3333", "http://www.ebay.com", "support@ebay.com"));
        addItem(new Company("Apple", R.drawable.apple, "1-800-444-4444", "http://www.apple.com", "support@apple.com"));
        addItem(new Company("Amazon", R.drawable.amazon, "1-800-555-5555", "http://www.amazon.com", "support@amazon.com"));
        addItem(new Company("Google", R.drawable.google, "1-800-777-7777", "http://www.google.com", "support@google.com"));
    }

    private void addItem(Company item) {
        mCompanies.add(item);
    }
}
