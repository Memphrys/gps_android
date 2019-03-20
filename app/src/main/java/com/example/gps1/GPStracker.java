package com.example.gps1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

public class GPStracker implements LocationListener {
    Context contexto;
    public GPStracker(Context c){
        contexto = c;
    }
    public Location getLocation(){
        //Check if permission is Enabled
         if(ContextCompat.checkSelfPermission(contexto, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
             Toast.makeText(contexto, "NO SE HAN DADO PERMISOS", Toast.LENGTH_SHORT).show();
             return  null; //No se han dado permisos por lo tanto no se ha de devolver ninguna localizacion
         }

        LocationManager lm=(LocationManager) contexto.getSystemService(contexto.LOCATION_SERVICE);
        boolean isGPSenabled=lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSenabled){
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,6000,5,this );
            Location l=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            return l;
        }else{
            Toast.makeText(contexto, "Por favor habilita el GPS, gracias", Toast.LENGTH_LONG).show();
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
