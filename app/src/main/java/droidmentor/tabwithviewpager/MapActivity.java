package droidmentor.tabwithviewpager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.MarkerManager;

import java.io.IOError;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng LC1 =  null;
    LatLng LC2 =  null;
    LatLng LC3 =  null;
    LatLng LC4 = null;
    LatLng amphi1 = null;
    LatLng amphi2 = null;
    LatLng amphi3 = null;
    LatLng amphi4 = null;
    LatLng amphi5 = null;
    LatLng amphi6 = null;
    LatLng amphiA = null;
    LatLng amphiB = null;
    LatLng amphiC = null;
    LatLng amphiD = null;
    LatLng Administration =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LC1 = new LatLng(35.764312, 10.806357);
        LC2 = new LatLng(35.765009, 10.804584);
        //LC3 = new LatLng(26.998162, 17.117323);
        //LC4 = new LatLng(33.877039, 10.088747);
        Administration = new LatLng(35.763846, 10.804829);
        LC2 = new LatLng(35.765009, 10.804584);
        amphi1 = new LatLng(35.764524, 10.804686);
        amphi2 = new LatLng(35.764599, 10.804848);
        amphi3 = new LatLng(35.764659, 10.805004);
        amphi4 = new LatLng(35.764795, 10.804919);
        amphi5 = new LatLng(35.764730, 10.804766);
        amphi6 = new LatLng(35.764668, 10.804589);
        amphiA = new LatLng(35.764081, 10.806160);
        amphiB = new LatLng(35.764302, 10.806675);
        amphiC = new LatLng(35.764521, 10.806527);
        amphiD = new LatLng(35.764304, 10.806026);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.764863, 10.804675), 17.0f));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        final Marker ni =mMap.addMarker(new MarkerOptions().position(LC1).title("lmarchi"));
        final   Marker nig =mMap.addMarker(new MarkerOptions().position(LC2).title("locaux commun2"));
        //final   Marker tc =mMap.addMarker(new MarkerOptions().position(LC3).title("locaux commun3"));
        //final   Marker aa =mMap.addMarker(new MarkerOptions().position(LC4).title("locaux commun4"));
        final   Marker bb =mMap.addMarker(new MarkerOptions().position(amphi1).title("Amphi 1"));
        final   Marker cc =mMap.addMarker(new MarkerOptions().position(amphi2).title("Amphi 2"));
        final   Marker dd =mMap.addMarker(new MarkerOptions().position(amphi3).title("Amphi 3"));
        final   Marker ee =mMap.addMarker(new MarkerOptions().position(amphi4).title("Amphi 4"));
        final   Marker ff =mMap.addMarker(new MarkerOptions().position(amphi5).title("Amphi 5"));
        final   Marker gg =mMap.addMarker(new MarkerOptions().position(amphi6).title("Amphi 6"));
        final   Marker hh =mMap.addMarker(new MarkerOptions().position(amphiA).title("Amphi A"));
        final   Marker ii =mMap.addMarker(new MarkerOptions().position(amphiB).title("Amphi B"));
        final   Marker jj =mMap.addMarker(new MarkerOptions().position(amphiC).title("Amphi C"));
        final   Marker kk =mMap.addMarker(new MarkerOptions().position(amphiD).title("Amphi D"));
        final Marker ll =mMap.addMarker(new MarkerOptions().position(Administration).title("Administration"));



        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                try {


                    if (marker.getTitle().equals("lmarchi"))
                        dialogShow(R.layout.lmarchi, "fo");
                    else if (marker.getTitle().equals("Amphi 1"))
                        dialogShow(R.layout.amphi1, "do");
                    else if (marker.getTitle().equals("Amphi 2"))
                        dialogShow(R.layout.amphi2, "imn");
                    else if (marker.getTitle().equals("Amphi 3"))
                        dialogShow(R.layout.amphi3, "ih");
                    else if (marker.getTitle().equals("Amphi 4"))
                        dialogShow(R.layout.amphi4, "lo");
                    else if(marker.getTitle().equals("Amphi 5"))
                        dialogShow(R.layout.amphi5, "imd");
                    else if(marker.getTitle().equals("Amphi 6"))
                        dialogShow(R.layout.amphi6, "imd");
                    else if(marker.getTitle().equals("Amphi A"))
                        dialogShow(R.layout.amphi_a, "imd");
                    else if(marker.getTitle().equals("Amphi B"))
                        dialogShow(R.layout.amphi_b, "imd");
                    else if(marker.getTitle().equals("Amphi C"))
                        dialogShow(R.layout.amphi_c, "imd");
                    else if(marker.getTitle().equals("Amphi D"))
                        dialogShow(R.layout.amphi_d, "imd");// refrere
                    else
                        Toast.makeText(MapActivity.this, "aucun emplacement à "+marker.getTitle(),Toast.LENGTH_SHORT).show();

                }catch (IOError e){}
                return false;
            }
        });



        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                int i =  mMap.getMapType();
                switch ( i ){
                    case GoogleMap.MAP_TYPE_HYBRID :{  mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        break;}
                    case GoogleMap.MAP_TYPE_SATELLITE :{  mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        break;}
                    case GoogleMap.MAP_TYPE_TERRAIN :{  mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        break;}
                    default: break;

                }

            }
        });
    }
    private void dialogShow(int layoutInfo , final String type ){

        try {
            AlertDialog.Builder showPlace = new AlertDialog.Builder(MapActivity.this);
            LayoutInflater factory = LayoutInflater.from(MapActivity.this);

            final View view = factory.inflate(layoutInfo, null);
            showPlace.setView(view);



            showPlace.show();
        }catch (Exception t){}


    }
}
