package com.vunsen.audiomode;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final int RINGER_MODE_SILENT=0;//静音
    public static final int RINGER_MODE_VIBRATE=1;//震动
    public static final int RINGER_MODE_NORMAL=2;//响铃
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_normal=(Button) findViewById(R.id.normal);
        Button btn_vibration=(Button) findViewById(R.id.vibration);
        Button btn_mute=(Button) findViewById(R.id.mute);
        final AudioManager audioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        if (btn_normal != null) {
            btn_normal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioManager.setRingerMode(RINGER_MODE_NORMAL);
                }
            });
        }
        if (btn_vibration != null) {
            btn_vibration.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioManager.setRingerMode(RINGER_MODE_VIBRATE);
                }
            });
        }
        if (btn_mute != null) {
            btn_mute.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    audioManager.setRingerMode(RINGER_MODE_SILENT);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("MainActivity", "menu--->" + menu);

//        setIconEnable(menu, true);// 4.0以上版本默认关闭，需要打开
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.Exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
