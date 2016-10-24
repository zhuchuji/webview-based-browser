package com.example.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Activity main = this;
		WebView webview = (WebView)findViewById(R.id.browserView);
		Button refreshBtn = (Button)findViewById(R.id.refresh);
		Button goBtn = (Button)findViewById(R.id.go);

		webview.setWebChromeClient(new WebChromeClient());
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 4.4; Nexus 5 Build/_BuildID_) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
		webview.getSettings().setAllowFileAccessFromFileURLs(true);
		webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
		webview.setWebContentsDebuggingEnabled(true);
		webview.setWebContentsDebuggingEnabled(true);
		webview.getSettings().setAllowContentAccess(true);
		webview.addJavascriptInterface(new WebAppInterface(this), "NativeAppHook");
		
		goBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText urlText = (EditText)findViewById(R.id.urlInput);
				WebView webview = (WebView)findViewById(R.id.browserView);
				String url = urlText.getText().toString();
				if (url != null && url != "") {
					webview.loadUrl(url);
				}
			}
			
		});
		
		refreshBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WebView webview = (WebView)findViewById(R.id.browserView);
				webview.reload();
			}
			
		});
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
