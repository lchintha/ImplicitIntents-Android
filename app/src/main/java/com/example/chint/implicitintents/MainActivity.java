package com.example.chint.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.service.chooser.ChooserTarget;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (Button)findViewById(R.id.maps);
        b = (Button)findViewById(R.id.markets);
        c = (Button)findViewById(R.id.mails);
    }
    public void onClick(View v){
        int id = v.getId();
        Intent i, chooser;
        if(id == R.id.maps){
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:27.1750,78.0422"));
            chooser = Intent.createChooser(i, "Lunch Maps");
            startActivity(chooser);
        }
        if(id == R.id.markets){
            i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("market:\\details?id=com.whatsapp&hl=en"));
            chooser = Intent.createChooser(i, "Choose Store");
            startActivity(chooser);
        }
        if(id == R.id.mails){
            i = new Intent(Intent.ACTION_SEND);
            // String[] to = {"mail@mail.com","gmail@gmail.com"};
            String to = "gmail@gmail.com";
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, to);
            i.putExtra(Intent.EXTRA_SUBJECT,"Mail to Inform");
            i.putExtra(Intent.EXTRA_TEXT, "This is a mail to inform you");
            i.setType("text/plain");
            chooser = Intent.createChooser(i, "Select App");
            startActivity(chooser);
        }
    }
}
