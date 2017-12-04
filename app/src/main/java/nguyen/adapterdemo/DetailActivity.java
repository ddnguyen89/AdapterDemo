package nguyen.adapterdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends Activity {

    private String companyName;
    private TextView phoneTV;
    private TextView nameTV;
    private TextView browserTV;
    private TextView emailTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //gets the data that was passed in from the intent of the Main Activity
        Intent intent = getIntent();
        companyName = intent.getStringExtra("companyName");
        int imageResource = intent.getIntExtra("imageResource", 0);
        String phone =  intent.getStringExtra("phone");
        String website =  intent.getStringExtra("website");
        String email =  intent.getStringExtra("email");

        //get reference to the widget
        nameTV = findViewById(R.id.nameTV);
        nameTV.setText(companyName);

        phoneTV = findViewById(R.id.phoneTV);
        phoneTV.setText(phone);

        browserTV = findViewById(R.id.browserTV);
        browserTV.setText(website);

        emailTV = findViewById(R.id.emailTV);
        emailTV.setText(email);

        ImageView image = findViewById(R.id.logoIV);
        image.setImageResource(imageResource);
    }

    public void phoneClick(View view) {
        String phoneNumber = phoneTV.getText().toString().replaceAll("-", "");

        Intent callIntent = new Intent(Intent.ACTION_DIAL);

        callIntent.setData(Uri.parse("tel:" + phoneNumber));

        startActivity(callIntent);
    }

    public void smsClick(View view) {
        String number = phoneTV.getText().toString();
        String message = "";

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number));
        intent.putExtra("sms body", message);
        startActivity(intent);
    }

    public void browerClick(View view) {
        String link = browserTV.getText().toString();
        Uri uri = Uri.parse(link);

        Intent viewIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(viewIntent);
    }

    public void emailClick(View view) {
        String email = emailTV.getText().toString();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT, "body of email");

        try {
            startActivity(Intent.createChooser(i, "send email..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed", Toast.LENGTH_LONG).show();
        }

    }
}
