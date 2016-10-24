package com.example.app;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
	Context context;
	
	public WebAppInterface(Context c) {
		this.context = c;
	}
	
	@JavascriptInterface
	public void showText(final String text) {
		Toast.makeText(this.context, text, Toast.LENGTH_LONG).show();	
	}
	
	@JavascriptInterface
	public void dateService(final String option) {
		
		
	}
}
