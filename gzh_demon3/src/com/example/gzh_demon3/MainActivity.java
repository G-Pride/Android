package com.example.gzh_demon3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button bt5;
	private Button bt6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlay);
        
        bt6 = (Button)findViewById(R.id.button6);
        bt6.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(MainActivity.this, RegisterActivity.class);
				startActivity(intent);
				MainActivity.this.finish();
			}
		});
        
    	bt5=(Button)findViewById(R.id.button5);
    	bt5.setOnClickListener(new OnClickListener() {		
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent  = new Intent();
				intent.setClass(MainActivity.this, SecondActivity.class);
				startActivity(intent);
				MainActivity.this.finish();
			}
		});
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
