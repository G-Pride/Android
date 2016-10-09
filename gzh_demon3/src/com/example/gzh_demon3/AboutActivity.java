package com.example.gzh_demon3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutActivity extends Activity{
	private Button bt8;
	
	protected void onCreate(Bundle savedInstanceState) { 	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
       bt8 = (Button) findViewById(R.id.button8);
       bt8.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) {
			Intent intent  = new Intent();
			intent.setClass(AboutActivity.this, SecondActivity.class);
			startActivity(intent);
			AboutActivity.this.finish();
			
		}
	});
}

}
