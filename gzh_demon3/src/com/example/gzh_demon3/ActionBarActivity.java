package com.example.gzh_demon3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.Toast;

public class ActionBarActivity extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) { 	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);
        
        ActionBar actionBar = getActionBar();  
        // 是否显示应用程序图标，默认为true  
        actionBar.setDisplayShowHomeEnabled(true);  
        // 是否显示应用程序标题，默认为true  
        actionBar.setDisplayShowTitleEnabled(true);  
  
        /* 
         * 是否将应用程序图标转变成可点击的按钮，默认为false。 
         *  
         * 如果设置了DisplayHomeAsUpEnabled为true， 
         *  
         * 则该设置自动为 true。 
         */  
        actionBar.setHomeButtonEnabled(true);  
        /* 
         * 在应用程序图标的左边显示一个向左的箭头， 
         *  
         * 并且将HomeButtonEnabled设为true。 
         *  
         * 默认为false。 
         */  
        actionBar.setDisplayHomeAsUpEnabled(true);  
  
        forceShowOverflowMenu();  
  
    }  
  
    /** 
     * 如果设备有物理菜单按键，需要将其屏蔽才能显示OverflowMenu 
     */  
    private void forceShowOverflowMenu() {  
        try {  
            ViewConfiguration config = ViewConfiguration.get(this);  
            Field menuKeyField = ViewConfiguration.class  
                    .getDeclaredField("sHasPermanentMenuKey");  
            if (menuKeyField != null) {  
                menuKeyField.setAccessible(true);  
                menuKeyField.setBoolean(config, false);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        MenuInflater inflater = getMenuInflater();  
        inflater.inflate(R.menu.actionbar_menu, menu);  
        return super.onCreateOptionsMenu(menu);  
    }  
  
    @Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
        /* 
         * 将actionBar的HomeButtonEnabled设为ture， 
         *  
         * 将会执行此case 
         */  
        case android.R.id.home:  
            finish();  
            break;  
        case R.id.add:  
            Toast.makeText(this, "添加", Toast.LENGTH_LONG).show();  
            break; 
        case R.id.delete2:  
            Toast.makeText(this, "编辑", Toast.LENGTH_LONG).show();  
            break;

        // 其他省略...  
        default:  
            break;  
        }  
        return super.onOptionsItemSelected(item);  
    }  
  
    @Override  
    public boolean onMenuOpened(int featureId, Menu menu) {  
        setOverflowIconVisible(featureId, menu);  
        return super.onMenuOpened(featureId, menu);  
    }  
  
    /** 
     * 显示OverflowMenu的Icon 
     *  
     * @param featureId 
     * @param menu 
     */  
    private void setOverflowIconVisible(int featureId, Menu menu) {  
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {  
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {  
                try {  
                    Method m = menu.getClass().getDeclaredMethod(  
                            "setOptionalIconsVisible", Boolean.TYPE);  
                    m.setAccessible(true);  
                    m.invoke(menu, true);  
                } catch (Exception e) {  
                    Log.d("OverflowIconVisible", e.getMessage());  
                }  
            }  
        }  
        
	}
}
