package com.example.rad;

import java.util.ArrayList;
import java.util.List;

import com.example.pleaseganana.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.*;
import android.widget.ListView;

public class Settings extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
		
		Resources res = getResources();
		int[] image = {R.drawable.arrowright, R.drawable.arrowright, R.drawable.arrowright,  R.drawable.arrowright };
		String[] name = res.getStringArray(R.array.settings);
		
		
		RowLayout5 adapter = new RowLayout5(this,name,image);
		setListAdapter(adapter);
		
		ListView list = getListView();
		list.setOnItemClickListener(new OnItemClickListener(){
	          public void onItemClick(AdapterView<?> parent, View view,
	                  int position, long id) {
	                   

	                 TextView title = (TextView) view.findViewById(R.id.settingsname); 
	                 ImageView img = (ImageView) view.findViewById(R.id.image1);

	                 String s = title.getText().toString();
	                 
	                 Intent a;
		              switch(position){

		             case 0:
		                 a = new Intent(getApplicationContext(),ChangePassword.class);
		                 startActivity(a);
		                 break;
		              
		             case 1:
		                 a = new Intent(getApplicationContext(),ShareSettings.class);
		                 startActivity(a);
		                 break;
		             case 2:
		                 a = new Intent(getApplicationContext(),NotificationSettings.class);
		                 startActivity(a);
		                 break;
		             case 3:
		            	 Toast toast = Toast.makeText(getApplicationContext(), "Your history has been cleared", Toast.LENGTH_LONG);
		                 toast.show();
		                 break;
		             }      
	                

	              }
	            });
	}	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
           case R.id.action_settings:
              Intent a = new Intent(getApplicationContext(), Options.class);
                           startActivity(a);  
                  return true;    
            default:
                return super.onOptionsItemSelected(item);
        
        }
    }

}