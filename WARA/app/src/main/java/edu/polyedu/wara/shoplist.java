package edu.polyedu.wara;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class shoplist extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoplist);

        LinearLayout linear1 = (LinearLayout) findViewById(R.id.linear1);
        LinearLayout linear2 = (LinearLayout) findViewById(R.id.linear2);
        LinearLayout linear3 = (LinearLayout) findViewById(R.id.linear3);
        LinearLayout linear4 = (LinearLayout) findViewById(R.id.linear4);
        LinearLayout linear5 = (LinearLayout) findViewById(R.id.linear5);


        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        shoplist2.class);

                String restaurantStr, addressStr;
                TextView restaurant, address;

                restaurant = (TextView) findViewById(R.id.restaurant1);
                address = (TextView) findViewById(R.id.address1);


                restaurantStr = restaurant.getText().toString();
                addressStr = address.getText().toString();

                intent.putExtra("restaurant", restaurantStr);
                intent.putExtra("address", addressStr);





                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.restaurantpng);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image", byteArray);
                startActivity(intent);




            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        shoplist2.class);

                String restaurantStr, addressStr;
                TextView restaurant, address;
                restaurant = (TextView) findViewById(R.id.restaurant2);
                address = (TextView) findViewById(R.id.address2);

                restaurantStr = restaurant.getText().toString();
                addressStr = address.getText().toString();

                intent.putExtra("restaurant", restaurantStr);
                intent.putExtra("address", addressStr);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.drinkpng);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image", byteArray);
                startActivity(intent);


            }
        });

        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        shoplist2.class);


                String restaurantStr, addressStr;
                TextView restaurant, address;
                restaurant = (TextView) findViewById(R.id.restaurant3);
                address = (TextView) findViewById(R.id.address3);

                restaurantStr = restaurant.getText().toString();
                addressStr = address.getText().toString();

                intent.putExtra("restaurant", restaurantStr);
                intent.putExtra("address", addressStr);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.drinkpng);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image", byteArray);
                startActivity(intent);


            }
        });

        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        shoplist2.class);


                String restaurantStr, addressStr;
                TextView restaurant, address;
                restaurant = (TextView) findViewById(R.id.restaurant4);
                address = (TextView) findViewById(R.id.address4);

                restaurantStr = restaurant.getText().toString();
                addressStr = address.getText().toString();

                intent.putExtra("restaurant", restaurantStr);
                intent.putExtra("address", addressStr);

                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.restaurantpng);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image", byteArray);
                startActivity(intent);


            }
        });

        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        shoplist2.class);


                String restaurantStr, addressStr;
                TextView restaurant, address;
                restaurant = (TextView) findViewById(R.id.restaurant5);
                address = (TextView) findViewById(R.id.address5);

                restaurantStr = restaurant.getText().toString();
                addressStr = address.getText().toString();

                intent.putExtra("restaurant", restaurantStr);
                intent.putExtra("address", addressStr);


                Bitmap sendBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.restaurantpng);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("image", byteArray);
                startActivity(intent);


            }
        });
/////////////////////////////////////////////////////////////////
        Intent intent = getIntent();

        String[] array = intent.getStringArrayExtra("selecteditem");
        String selected = "";
        for(int i=0; i<array.length; i++) {
            selected += (array[i] +"          ");
        }


        TextView Filter1 = (TextView) findViewById(R.id.filter1);

        Filter1.setText(selected);
        ///////////////////////////////////////////////////////////////
    }

}
