package edu.polyedu.wara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

public class shoplist2 extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoplist2);

        Button userplus = (Button) findViewById(R.id.userplus);
        userplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        page4.class);
                startActivity(intent);
            }
        });

    }

    public void onPopupButtonClick(View view2) {
        //PopupMenu 객체 생성.
        PopupMenu popup = new PopupMenu(this, view2);

        //설정한 popup XML을 inflate.
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

        //팝업메뉴 클릭 시 이벤트
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Facebook:
                        break;

                    case R.id.Instagram:
                        break;

                    case R.id.Line:
                        break;

                    case R.id.Kakaotalk:
                        break;
                }
                return true;
            }
        });
        popup.show();
    }

    public void onPopupButtonClick2(View view3) {
        //PopupMenu 객체 생성.
        PopupMenu popup2 = new PopupMenu(this, view3);

        //설정한 popup XML을 inflate.
        popup2.getMenuInflater().inflate(R.menu.popup2, popup2.getMenu());

        //팝업메뉴 클릭 시 이벤트
        popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Restaurant:
                        break;

                    case R.id.Cafe:
                        break;

                    case R.id.Drink:
                        break;

                    case R.id.Conference:
                        break;

                    case R.id.Hotel:
                        break;
                }
                return true;
            }
        });
        popup2.show();
    }

}
