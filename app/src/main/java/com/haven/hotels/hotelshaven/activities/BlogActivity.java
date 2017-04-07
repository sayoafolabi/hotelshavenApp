package com.haven.hotels.hotelshaven.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.haven.hotels.hotelshaven.R;


/**
 * Created by AfolabSa on 07/04/2017.
 */

public class BlogActivity extends Activity
{
    private WebView webView;
    ImageView imageView;
    TextView splashView;
    String url = "www.hotelshaven.com/blog";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = (WebView) findViewById(R.id.webView1);
        imageView = (ImageView) findViewById(R.id.imgloader);
        splashView = (TextView) findViewById(R.id.splashTextView);
        splashView.setText("You are now being redirected to Hotels Haven blog page which is a web content");

        webView.setWebViewClient(new BlogActivity.MyBrowser());
        webView.clearCache(true);
        webView.clearHistory();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {

                // imageView.setVisibility(View.GONE);

                splashView.setVisibility(View.GONE);

                webView.setVisibility(View.VISIBLE);
            }

        });

        webView.loadUrl(url);

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
