package com.hesabdarapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=(WebView) findViewById(R.id.webwiew);
        tv=findViewById(R.id.mag);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i("mag2851-pagefinishUrl",url );
                if ( url.contains("https://www.zarinpal.com")||url.contains("pep.shaparak.ir")){
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(browserIntent);
                    // webView.setVisibility(View.INVISIBLE);
                    finish();

                }
                tv.setText(url);
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
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);


            }
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);


            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onCloseWindow(WebView window) {
                super.onCloseWindow(window);
            }

        });
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);

        webView.getSettings().setSupportMultipleWindows(false);
        webView.getSettings().setSupportZoom(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        webView.loadUrl("https://m.hesabdarapp.com");
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);

    }



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("mag2851-afterPayment",intent.getData().toString());
        if(intent.getAction() != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            Uri uri = intent.getData();
//            webView.loadUrl(uri.toString());
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
