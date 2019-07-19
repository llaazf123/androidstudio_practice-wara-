package edu.polyedu.wara;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.ArrayList;
import java.util.List;

//참고 : https://mailmail.tistory.com/17
public class google extends AppCompatActivity implements OnMapReadyCallback {
    final String[] userStr = new String[5];
    //구글맵참조변수
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google);

        // SupportMapFragment을 통해 레이아웃에 만든 fragment의 ID를 참조하고 구글맵을 호출한다.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); //getMapAsync must be called on the main thread.

        ImageView btnDialog = (ImageView) findViewById(R.id.category);

        final List<String> selectedItems = new ArrayList<String>();

        ImageView btnDialog2 = (ImageView) findViewById(R.id.link);
        ImageView userplus = (ImageView) findViewById(R.id.userplus);
//        ImageView middle = (ImageView) findViewById(R.id.middle);

        userplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        People.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();


        userStr[0] = intent.getStringExtra("user1");
        userStr[1] = intent.getStringExtra("user2");
        userStr[2] = intent.getStringExtra("user3");
        userStr[3] = intent.getStringExtra("user4");
        userStr[4] = intent.getStringExtra("user5");


//        TextView TextViewid = (TextView) findViewById(R.id.TextViewid);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(getApplicationContext(), shoplist.class);
                final String[] items = new String[]{"음식점", "카페", "술집", "숙박시설"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(google.this);
                dialog.setTitle("카테고리를 선택하세요")
                        .setMultiChoiceItems(items
                                , new boolean[]{false, false, false, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                        if (isChecked) {
                                            Toast.makeText(google.this, items[which], Toast.LENGTH_SHORT).show();
                                            selectedItems.add(items[which]

                                            );
                                        } else {
                                            selectedItems.remove(items[which]);
                                        }
                                    }
                                })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (selectedItems.size() == 0) {
                                    Toast.makeText(google.this, "선택된 카테고리가 없습니다", Toast.LENGTH_SHORT).show();
                                } else {

                                    String items = "";
                                    for (String seletecItem : selectedItems) {
                                        items += (seletecItem + ", ");
                                    }

///////////////////////////////////////////////////////////////////////////////////////////////////////
                                    String[] selecteditem = new String[selectedItems.size()];

                                    if (selectedItems.get(0) == null) {
                                        //아무것도 안해
                                    } else {
                                        for (int i =0;i < selectedItems.size(); i++) {
                                            selecteditem[i] = selectedItems.get(i);


                                        }
                                        intent.putExtra("selecteditem", selecteditem);
                                        startActivityForResult(intent, 0);
                                    }

//////////////////////////////////////////////////////////////////////////////////////////////////

                                    selectedItems.clear();

                                    items = items.substring(0, items.length() - 2);
                                    Toast.makeText(google.this, items, Toast.LENGTH_SHORT).show();

                                }
                            }
                        }).create().show();


            }
        });

        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] items = new String[]{"Facebook", "Instagram", "Line", "Kakaotalk"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(google.this);
                dialog.setTitle("링크 공유를 원하는 SNS를 선택하세요")
                        .setMultiChoiceItems(items
                                , new boolean[]{false, false, false, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            Toast.makeText(google.this, items[which], Toast.LENGTH_SHORT).show();
                                            selectedItems.add(items[which]);
                                        } else {
                                            selectedItems.remove(items[which]);
                                        }
                                    }
                                })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (selectedItems.size() == 0) {
                                    Toast.makeText(google.this, "선택된 SNS가 없습니다", Toast.LENGTH_SHORT).show();
                                } else {

                                    String items = "";
                                    for (String seletecItem : selectedItems) {
                                        items += (seletecItem + ", ");
                                    }

                                    selectedItems.clear();

                                    items = items.substring(0, items.length() - 2);
                                    Toast.makeText(google.this, items, Toast.LENGTH_SHORT).show();

                                }
                            }
                        }).create().show();
            }
        });





    }

    @Override //구글맵을 띄울준비가 됬으면 자동호출된다.
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //지도타입 - 일반
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
    public void onPopupButtonClick3(View view) {
        if (userStr[0] == null) {
            //아무것도 안해
        } else {
            PopupMenu popup3 = new PopupMenu(this, view);
            popup3.getMenuInflater().inflate(R.menu.popup3, popup3.getMenu());
            for (int i = 0; i < 5; i++) {
                popup3.getMenu().getItem(i).setTitle(userStr[i]);
            }
            popup3.show();
        }
    }
}