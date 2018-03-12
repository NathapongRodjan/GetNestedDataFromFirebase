package com.example.nathapong.getnesteddatafromfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddValueActivity extends AppCompatActivity {

    EditText edtType, edtList, edtName, edtDescription, edtImage, edtPrice;
    Button btnSend, btnGo;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_value);

        edtType = (EditText)findViewById(R.id.edtType);
        edtList = (EditText)findViewById(R.id.edtList);
        edtName = (EditText)findViewById(R.id.edtName);
        edtDescription = (EditText)findViewById(R.id.edtDescription);
        edtImage = (EditText)findViewById(R.id.edtImage);
        edtPrice = (EditText)findViewById(R.id.edtPrice);
        btnSend = (Button)findViewById(R.id.btnSend);
        btnGo = (Button)findViewById(R.id.btnGo);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String menuType = edtType.getText().toString();
                String menuList = edtList.getText().toString();
                String name = edtName.getText().toString();
                String imagepath = edtImage.getText().toString();
                String description = edtDescription.getText().toString();
                int price = Integer.parseInt(edtPrice.getText().toString());

               String[] array = {"-L7Oh9m1f5e_l53nO8Qv", "-L7PHRSxfbwkS_7KDAoh",
                                "-L7PHXeHEk94ojpt9leQ", "-L7PHXxLVKCJptjZBPN-",
                                "-L7PHYDKYcS71TaFMJIc", "-L7PHYQi_VVhZHJjaYjw",
                                "-L7PHYcc1Qt1ofO4YyXK", "-L7PHYr9H5P9U8pB8GA5",
                                "-L7PHZ5bOjci3huNaMPE", "-L7PHZMUvmEi0VYwuk9_"};

               for (int i = 0; i < array.length; i++){

                   String key = array[i];

                   databaseReference.child("restaurants").child(key)
                           .child("menu").child(menuType).child(menuList)
                           .child("name").setValue(name);

                   databaseReference.child("restaurants").child(key)
                           .child("menu").child(menuType).child(menuList)
                           .child("image").setValue("imagepath");

                   databaseReference.child("restaurants").child(key)
                           .child("menu").child(menuType).child(menuList)
                           .child("description").setValue(description);

                   databaseReference.child("restaurants").child(key)
                           .child("menu").child(menuType).child(menuList)
                           .child("price").setValue(price);
               }


            }
        });


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddValueActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
