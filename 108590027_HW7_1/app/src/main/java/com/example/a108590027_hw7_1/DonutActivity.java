package com.example.a108590027_hw7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DonutActivity extends AppCompatActivity {
    private static final int menu1 = Menu.FIRST;
    private static final int menu2 = Menu.FIRST + 1;
    private static final int menu3 = Menu.FIRST + 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //在此定義MENU選單選項
        menu.add(0, menu1, 0, getString(R.string.act_main));//(群組ID, 選項ID, 選項排列順序, 選項名稱)
        menu.add(0, menu2, 1, getString(R.string.act_froyo));
        menu.add(0, menu3, 2, getString(R.string.act_ice));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //當使用者點選MENU中的選項後，觸發此狀態事件
        switch (item.getItemId())
        {
            case menu1: //main
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
            case menu2: //froyo
                Intent intent2 = new Intent(this, FroyoActivity.class);
                startActivity(intent2);
                break;
            case menu3: //ice cream
                Intent intent3 = new Intent(this, IceActivity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}