package com.example.mafm.Nettenvericekme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://jsonplaceholder.typicode.com/posts" , new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.d("işlem", "başarısız");

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
            Log.d("işlem", "başarılı");
                tv.setText(responseString);



            }
        });




    }
}
