package jp.ac.shohoku.aporochoco.imgeditapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton button1 = findViewById(R.id.imageButton1);
        ImageButton button2 = findViewById(R.id.imageButton2);


        button1.setOnClickListener(new OnClickListener() {

            //ボタンが押された時の処理
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);  //インテントの作成
                startActivity(intent);                                 //画面遷移
            }
        });
        button2.setOnClickListener(new OnClickListener() {

            //ボタンが押された時の処理
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);  //インテントの作成
                startActivity(intent);                                 //画面遷移
            }
        });
    }
}