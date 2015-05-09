package com.lsw.dj95.linuxstattwindows;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.lang.reflect.Method;

/**
 * Created by dj95 on 09.05.15.
 */
public class LsWFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //get menu position
        int position = getArguments().getInt("position");

        String[] strMenu = getResources().getStringArray(R.array.menu);
        View v = inflater.inflate(R.layout.fragment_layout, container, false);

        //assign webview to variable
        WebView mWebView = (WebView) v.findViewById(R.id.fragment_webView);
        mWebView.setWebChromeClient(new WebChromeClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);

        //Enable Zoom
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setBuiltInZoomControls(true);

        // Force links and redirects to open in the WebView instead of a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Load different categories
        switch (position) {
            case 0:
                mWebView.loadUrl("https://linux-statt-windows.org");
                //mWebView.loadUrl("https://html5test.com");
                break;
            case 1:
                mWebView.loadUrl("https://linux-statt-windows.org/unread");
                break;
            case 2:
                mWebView.loadUrl("https://linux-statt-windows.org/recent");
                break;
            case 3:
                mWebView.loadUrl("https://linux-statt-windows.org/tags");
                break;
            case 4:
                mWebView.loadUrl("https://linux-statt-windows.org/popular");
                break;
            case 5:
                mWebView.loadUrl("https://linux-statt-windows.org/users");
                break;
            case 6:
                mWebView.loadUrl("https://linux-statt-windows.org/groups");

        }

        return v;
    }
}
