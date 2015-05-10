package com.lsw.dj95.linuxstattwindows;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LsWFragment extends Fragment {

    private WebView mWebView;
    private ActionBar mActionBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //get menu position
        int position = getArguments().getInt("position");

        String[] strMenu = getResources().getStringArray(R.array.menu);
        View v = inflater.inflate(R.layout.fragment_layout, container, false);

        //assign webview to variable
        mWebView = (WebView) v.findViewById(R.id.fragment_webView);
        mWebView.setWebChromeClient(new WebChromeClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(false);

        // Disable Zoom
        mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setBuiltInZoomControls(false);

        // Force links and redirects to open in the WebView instead of a browser
        mWebView.setWebViewClient(new WebViewClient());

        String mainSite = "https://linux-statt-windows.org";

        // Load different categories
        switch (position) {
            case 0:
                mWebView.loadUrl(mainSite);
                break;
            case 1:
                mWebView.loadUrl(mainSite + "/unread");
                break;
            case 2:
                mWebView.loadUrl(mainSite + "/recent");
                break;
            case 3:
                mWebView.loadUrl(mainSite + "/tags");
                break;
            case 4:
                mWebView.loadUrl(mainSite + "/popular");
                break;
            case 5:
                mWebView.loadUrl(mainSite + "/users");
                break;
            case 6:
                mWebView.loadUrl(mainSite + "/groups");
        }

        return v;
    }
}
