package com.example.nathapong.getnesteddatafromfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView txtName, txtAddress, txtLatitude, txtLongitude, txtData, txtKey;
    TextView txtMenu1, txtDescription1, txtImage1, txtPrice1;
    TextView txtMenu2, txtDescription2, txtImage2, txtPrice2;
    Button btnGetData, btnShow, btnSendData;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView)findViewById(R.id.txtName);
        txtAddress = (TextView)findViewById(R.id.txtAddress);
        txtLatitude = (TextView)findViewById(R.id.txtLatitude);
        txtLongitude = (TextView)findViewById(R.id.txtLongitude);

        txtMenu1 = (TextView)findViewById(R.id.txtMenu1);
        txtDescription1 = (TextView)findViewById(R.id.txtDescription1);
        txtImage1 = (TextView)findViewById(R.id.txtImage1);
        txtPrice1 = (TextView)findViewById(R.id.txtPrice1);

        txtMenu2 = (TextView)findViewById(R.id.txtMenu2);
        txtDescription2 = (TextView)findViewById(R.id.txtDescription2);
        txtImage2 = (TextView)findViewById(R.id.txtImage2);
        txtPrice2 = (TextView)findViewById(R.id.txtPrice2);

        btnGetData = (Button)findViewById(R.id.btnGetData);
        btnShow = (Button)findViewById(R.id.btnShow);
        btnSendData = (Button)findViewById(R.id.btnSendData);

        txtData = (TextView)findViewById(R.id.txtData);
        txtKey = (TextView)findViewById(R.id.txtKey);



        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot child : dataSnapshot.getChildren()){

                            Restaurants restaurants = child.getValue(Restaurants.class);

                            txtName.setText(restaurants.getName());
                            txtAddress.setText(restaurants.getAddress());
                            txtLatitude.setText(restaurants.getLocation().getLatitude()+"");
                            txtLongitude.setText(restaurants.getLocation().getLongitude()+"");

                            txtMenu1.setText(restaurants.getMenu().getSteak().getBeef().getName());
                            txtDescription1.setText(restaurants.getMenu().getSteak().getBeef().getDescription());
                            txtImage1.setText(restaurants.getMenu().getSteak().getBeef().getImage());
                            txtPrice1.setText(restaurants.getMenu().getSteak().getBeef().getPrice()+"");

                            txtMenu2.setText(restaurants.getMenu().getSteak().getPork().getName());
                            txtDescription2.setText(restaurants.getMenu().getSteak().getPork().getDescription());
                            txtImage2.setText(restaurants.getMenu().getSteak().getPork().getImage());
                            txtPrice2.setText(restaurants.getMenu().getSteak().getPork().getPrice()+"");


                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseDatabase.getReference("001/menu/steak")
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {


                                String oldText = "";

                                for (DataSnapshot child : dataSnapshot.getChildren()){

                                    Beef steak = child.getValue(Beef.class);

                                    txtData.setText(oldText + steak.getName() +  " " + steak.getDescription() + " " + steak.getImage() + " " + steak.getPrice() + "\n");

                                    txtKey.setText(dataSnapshot.getKey());

                                    oldText = txtData.getText().toString();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
            }
        });

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String key = databaseReference.push().getKey();

                databaseReference.child("restaurants").child(key).child("id").setValue(key);
                databaseReference.child("restaurants").child(key).child("address").setValue("บางใหญ่ นนทบุรี");
                databaseReference.child("restaurants").child(key).child("name").setValue("name");
                databaseReference.child("restaurants").child(key).child("location").child("latitude").setValue(0);
                databaseReference.child("restaurants").child(key).child("location").child("longitude").setValue(0);
            }
        });

    }

}
