package com.example.gzh_demon3;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class SecondActivity extends Activity{
	private Button bt3;
	private Button bt2;
protected void onCreate(Bundle savedInstanceState) { 	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bt2= (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent  = new Intent();
				intent.setClass(SecondActivity.this, ActionBarActivity.class);
				startActivity(intent);
				SecondActivity.this.finish();
				
			}
		});
        
        bt3= (Button) findViewById(R.id.button3);
        bt3.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent  = new Intent();
				intent.setClass(SecondActivity.this, AboutActivity.class);
				startActivity(intent);
				SecondActivity.this.finish();
				
			}
		});
    }
}
