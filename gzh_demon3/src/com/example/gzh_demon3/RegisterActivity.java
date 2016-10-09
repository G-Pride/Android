package com.example.gzh_demon3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RegisterActivity extends Activity{
	
	private Button cacel;
	
	protected void onCreate(Bundle savedInstanceState) { 	
        
		super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
     
        cacel = (Button) findViewById(R.id.cancel);
        cacel.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent  = new Intent();
				intent.setClass(RegisterActivity.this,MainActivity.class );
				startActivity(intent);
				RegisterActivity.this.finish();
				
			}
		});
    }
}
