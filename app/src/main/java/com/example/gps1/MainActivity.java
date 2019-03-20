package com.example.gps1;

import android.Manifest;
import android.app.Activity;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnGetLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetLoc=(Button) findViewById(R.id.btnGetLoc);

        //Create a popup request to get permission from user (Location)
        ActivityCompat.requestPermissions(MainActivity.this, new String []{Manifest.permission.ACCESS_FINE_LOCATION},123);


        btnGetLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPStracker g=new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if (l!=null){
                    double latitud= l.getLatitude();
                    double longitud=l.getLongitude();
                    Toast.makeText(getApplicationContext(), "Latitud: " + latitud + "\n Longitud: "+longitud, Toast.LENGTH_LONG  ).show();
                }


            }
        });
    }
}
