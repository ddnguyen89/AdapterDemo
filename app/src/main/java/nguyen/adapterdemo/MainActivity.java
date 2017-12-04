package nguyen.adapterdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import nguyen.adapterdemo.data.Company;
import nguyen.adapterdemo.data.CompanyData;

public class MainActivity extends ListActivity {

    //old AdapterDemo extends AppCompatActivity
    //ListView listView;

    private static final int REQUEST_CODE = 100;
    List<Company> mCompanies = new CompanyData().getmCompanies();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the custom adapter and get it
        CustomAdapter adapter = new CustomAdapter(this, R.layout.item_detail, mCompanies);
        setListAdapter(adapter);

        /*old AdapterDemo

        listView = (ListView) findViewById(R.id.list_item);

        String [] values = getResources().getStringArray(R.array.list_adapter_array);

        //Define a new Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        //Arrays adapter to ListView
        listView.setAdapter(adapter);

        //ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //ListView Click item index
                int itemPosition = position + 1;

                //ListView Clicked item Value
                String itemValue = (String) listView.getItemAtPosition(position);

                //Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position: " + itemPosition + "   ListItem: " + itemValue,
                        Toast.LENGTH_LONG).show();
            }
        });
        */
    }

    //this function is used by the adapter
    @Override
    protected void onListItemClick(ListView parent, View v, int position, long id) {
        super.onListItemClick(parent, v, position, id);

        //return the position of the list of companies
        Company company = mCompanies.get(position);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("companyName", company.companyName);
        intent.putExtra("imageResource", company.imageResource);
        intent.putExtra("phone", company.phone);
        intent.putExtra("website", company.website);
        intent.putExtra("email", company.email);

        //sometimes you want to get a result back from an activity when it ends
        //for example, you may start an activity that lets the user pick a person
        //in a list of contacts. when it ends, it returns the person that was selected.
        startActivityForResult(intent, REQUEST_CODE);
    }

    //invoked automattically when second activity returns the result from startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == REQUEST_CODE && requestCode == RESULT_OK) {
            String companyName = data.getStringExtra("companyName");
            String action = data.getStringExtra("action");
        }
    }
}
