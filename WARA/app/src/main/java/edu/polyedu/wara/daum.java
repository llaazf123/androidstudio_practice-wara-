package edu.polyedu.wara;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.List;

public class daum extends AppCompatActivity {
    final String[] userStr = new String[5];


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daum);

        ImageView btnDialog = (ImageView) findViewById(R.id.category);
        final List<String> selectedItems = new ArrayList<String>();

        ImageView btnDialog2 = (ImageView) findViewById(R.id.link);

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

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

                AlertDialog.Builder dialog = new AlertDialog.Builder(daum.this);
                dialog.setTitle("카테고리를 선택하세요")
                        .setMultiChoiceItems(items
                                , new boolean[]{false, false, false, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                        if (isChecked) {
                                            Toast.makeText(daum.this, items[which], Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(daum.this, "선택된 카테고리가 없습니다", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(daum.this, items, Toast.LENGTH_SHORT).show();

                                }
                            }
                        }).create().show();


            }
        });

        btnDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] items = new String[]{"Facebook", "Instagram", "Line", "Kakaotalk"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(daum.this);
                dialog.setTitle("링크 공유를 원하는 SNS를 선택하세요")
                        .setMultiChoiceItems(items
                                , new boolean[]{false, false, false, false}
                                , new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        if (isChecked) {
                                            Toast.makeText(daum.this, items[which], Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(daum.this, "선택된 SNS가 없습니다", Toast.LENGTH_SHORT).show();
                                } else {

                                    String items = "";
                                    for (String seletecItem : selectedItems) {
                                        items += (seletecItem + ", ");
                                    }

                                    selectedItems.clear();

                                    items = items.substring(0, items.length() - 2);
                                    Toast.makeText(daum.this, items, Toast.LENGTH_SHORT).show();

                                }
                            }
                        }).create().show();
            }
        });





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

//    public void onPopupButtonClick(View view2) {
//        //PopupMenu 객체 생성.
//        PopupMenu popup = new PopupMenu(this, view2);
//
//        //설정한 popup XML을 inflate.
//        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
//
//        //팝업메뉴 클릭 시 이벤트
//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.Facebook:
//                        break;
//
//                    case R.id.Instagram:
//                        break;
//
//                    case R.id.Line:
//                        break;
//
//                    case R.id.Kakaotalk:
//                        break;
//                }
//                return true;
//            }
//        });
//        popup.show();
//    }
//
//    public void onPopupButtonClick2(View view3) {
//        //PopupMenu 객체 생성.
//        PopupMenu popup2 = new PopupMenu(this, view3);
//
//        //설정한 popup XML을 inflate.
//        popup2.getMenuInflater().inflate(R.menu.popup2, popup2.getMenu());
//
//        //팝업메뉴 클릭 시 이벤트
//        popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.Restaurant:
//                        break;
//
//                    case R.id.Cafe:
//                        break;
//
//                    case R.id.Drink:
//                        break;
//
//                    case R.id.Conference:
//                        break;
//
//                    case R.id.Hotel:
//                        break;
//                }
//                return true;
//            }
//        });
//        popup2.show();
//    }


}
