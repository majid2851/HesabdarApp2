package com.hesabdarapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);


    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("mag2851-afterPayment",intent.getData().toString());
        if(intent.getAction() != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            Uri uri = intent.getData();
            Log.i("mag2851-this","alskjdflasj");
//            try {
//                String q = uri.getQueryParameter("q");
//                String s = uri.getQueryParameter("s");
//
//                AlertDialog dialog;
//                AlertDialog.Builder builder=new AlertDialog.Builder(MyOrderActivity.this);
//                View v=getLayoutInflater().inflate(R.layout.dialog_payment,null);
//                TextView tv=v.findViewById(R.id.tvPayment);
//                tv.setText(q+s);
//
//
//
//                builder.setView(v);
//                dialog=builder.create();
//                dialog.show();
//
//                Log.i("mag2851-afterPayment","you did it");
//
//            }catch (NullPointerException exception) { }
        }
    }

}