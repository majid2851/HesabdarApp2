package com.hesabdarapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        webView= findViewById(R.id.webwiew);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i("mag2851-pagefinishUrl",url );
                if (url.contains("m.hesabdarapp.com/account")){
                    startActivity(new Intent(ReportActivity.this,MainActivity.class));
                    finish();
                }



            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                super.onPageFinished(view, url);


            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error)
            {

                Log.i("mag2851-recieveErr", error.toString());
                Log.i("mag2851-recieveErrWeb",view.getUrl() );


            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                Log.i("mag2851-url",url);


                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);

        webView.getSettings().setSupportMultipleWindows(false);
        webView.getSettings().setSupportZoom(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        webView.loadUrl(getIntent().getData().toString());
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent=getIntent();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
//        Log.i("mag2851-afterPayment",intent.getData().toString());
//        if(intent.getAction() != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
//            Uri uri = intent.getData();
//            Log.i("mag2851-this","alskjdflasj");
//            tv.setText(uri.toString());
////            try {
////                String q = uri.getQueryParameter("q");
////                String s = uri.getQueryParameter("s");
////
////                AlertDialog dialog;
////                AlertDialog.Builder builder=new AlertDialog.Builder(MyOrderActivity.this);
////                View v=getLayoutInflater().inflate(R.layout.dialog_payment,null);
////                TextView tv=v.findViewById(R.id.tvPayment);
////                tv.setText(q+s);
////
////
////
////                builder.setView(v);
////                dialog=builder.create();
////                dialog.show();
////
////                Log.i("mag2851-afterPayment","you did it");
////
////            }catch (NullPointerException exception) { }
//        }
    }

}