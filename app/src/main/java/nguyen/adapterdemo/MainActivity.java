package nguyen.adapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
