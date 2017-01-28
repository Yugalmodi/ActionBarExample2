package com.techpalle.actionbarexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//HOW TO REMOVE TITLE FROM ACTION BAR
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//HOW TO ENABLE BACK/UP CARROT SYMBOL on ACTION BAR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//FOR REMOVING ACTION BAR
        getSupportActionBar().hide();//open-use show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case  android.R.id.home:// HANDLE FOR UP-CARROT SYMBOL CLICK
                finish();
                break;
            case R.id.backup:
                Toast.makeText(MainActivity.this, "Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.call:
                Toast.makeText(MainActivity.this, "calling", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 8109434645"));
                startActivity(intent);
                break;
            case R.id.back:
                Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
                break;
            case R.id.run:
                Toast.makeText(MainActivity.this, "Running", Toast.LENGTH_SHORT).show();
                break;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
