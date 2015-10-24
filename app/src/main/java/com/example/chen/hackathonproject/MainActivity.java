package com.example.chen.hackathonproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ch.boye.httpclientandroidlib.NameValuePair;
import ch.boye.httpclientandroidlib.message.BasicNameValuePair;

public class MainActivity extends AppCompatActivity {

    public static String TEST_URL = "http://139.129.24.127/test.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View.OnClickListener listener = new SendMsgListener();
        findViewById(R.id.button1).setOnClickListener(listener);
        findViewById(R.id.button2).setOnClickListener(listener);
        findViewById(R.id.button3).setOnClickListener(listener);
        findViewById(R.id.button4).setOnClickListener(listener);


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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMsg(final String msg) {
                new Thread(new Runnable() {
            @Override
            public void run() {
                NetCore n = new NetCore();
                String url = "http://139.129.24.127/test.php";
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                try {
                    System.out.println("~~********");
                    params.add(new BasicNameValuePair("id", msg));
                    String s = n.postResultToNet(url, params);
                    System.out.println(s + "((((((((())))))))");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("~~!!!!!!!!!!!");

            }
        }).start();
    }

    class SendMsgListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    sendMsg("1");
                    break;
                case R.id.button2:
                    sendMsg("2");
                    break;
                case R.id.button3:
                    sendMsg("3");
                    break;
                case R.id.button4:
                    sendMsg("4");
                    break;
            }
        }
    }
}
