package nguyen.adapterdemo.data;

/**
 * Created by 660253185 on 12/4/2017.
 */

public class Company {

    //define variables
    public String companyName;
    public int imageResource;
    public String phone;
    public String website;
    public String email;

    public Company(String companyName, int imageResource, String phone, String website, String email) {
        this.companyName = companyName;
        this.imageResource = imageResource;
        this.phone = phone;
        this.website = website;
        this.email = email;
    }


    //return company name as a string
    @Override
    public String toString() {
        return companyName;
    }
}
