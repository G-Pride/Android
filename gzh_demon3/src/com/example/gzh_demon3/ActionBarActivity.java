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
        // �Ƿ���ʾӦ�ó���ͼ�꣬Ĭ��Ϊtrue  
        actionBar.setDisplayShowHomeEnabled(true);  
        // �Ƿ���ʾӦ�ó�����⣬Ĭ��Ϊtrue  
        actionBar.setDisplayShowTitleEnabled(true);  
  
        /* 
         * �Ƿ�Ӧ�ó���ͼ��ת��ɿɵ���İ�ť��Ĭ��Ϊfalse�� 
         *  
         * ���������DisplayHomeAsUpEnabledΪtrue�� 
         *  
         * ��������Զ�Ϊ true�� 
         */  
        actionBar.setHomeButtonEnabled(true);  
        /* 
         * ��Ӧ�ó���ͼ��������ʾһ������ļ�ͷ�� 
         *  
         * ���ҽ�HomeButtonEnabled��Ϊtrue�� 
         *  
         * Ĭ��Ϊfalse�� 
         */  
        actionBar.setDisplayHomeAsUpEnabled(true);  
  
        forceShowOverflowMenu();  
  
    }  
  
    /** 
     * ����豸������˵���������Ҫ�������β�����ʾOverflowMenu 
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
         * ��actionBar��HomeButtonEnabled��Ϊture�� 
         *  
         * ����ִ�д�case 
         */  
        case android.R.id.home:  
            finish();  
            break;  
        case R.id.add:  
            Toast.makeText(this, "���", Toast.LENGTH_LONG).show();  
            break; 
        case R.id.delete2:  
            Toast.makeText(this, "�༭", Toast.LENGTH_LONG).show();  
            break;

        // ����ʡ��...  
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
     * ��ʾOverflowMenu��Icon 
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
