package nguyen.adapterdemo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nguyen.adapterdemo.data.Company;

/**
 * Created by 660253185 on 12/4/2017.
 */

public class CustomAdapter extends ArrayAdapter<Company>{

    //define variables
    private Context context;
    private List<Company> objects;

    public CustomAdapter(Context context, int resource, List<Company> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Company company = objects.get(position);

        //inflating means reading the XML file that describes a layout
        //and to create the actual objects that correspond to it
        //and thus make the object variable within an Android app

        //Passes an ID to get a handle on a system level service
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_detail, null);

        ImageView image = view.findViewById(R.id.logoIV);
        image.setImageResource(company.imageResource);

        TextView nameTV = view.findViewById(R.id.nameTV);
        nameTV.setText(company.companyName);

        return view;
    }
}
