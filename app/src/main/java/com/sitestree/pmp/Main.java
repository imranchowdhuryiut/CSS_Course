package com.sitestree.pmp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.sitestree.pmp.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class Main extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        webView = (WebView)findViewById(R.id.fullscreen_content);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("https://goo.gl/C6mp9P");
        //http://sitestree.com/pmp-project-management/
        //webView.loadUrl("http://sitestree.com/series/pmp-project-management/");
        //webView.loadUrl("file:///android_asset/www/index.html");
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabasePath("/data/data/"+this.getPackageName()+"/databases/");
        
    }
    
    @Override
    public void onBackPressed()
    {
        if ( webView.canGoBack() ) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
    

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    
}
