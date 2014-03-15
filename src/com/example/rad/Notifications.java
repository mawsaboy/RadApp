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

public class Notifications extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
		  
		View footer = getLayoutInflater().inflate(R.layout.footer, null);  
		ListView listView = getListView(); 
		listView.addFooterView(footer); 
		
		ImageButton home = (ImageButton) findViewById(R.id.imageButton1);
	    home.setOnClickListener(new View.OnClickListener() {
	   	 public void onClick(View v) {
	           Intent i = new Intent(getApplicationContext(), Home.class);
	           startActivity(i);
	       }
	   });
		
		ImageButton notifications = (ImageButton) findViewById(R.id.imageButton2);
		   notifications.setOnClickListener(new View.OnClickListener() { 
		       public void onClick(View v) {
		           Intent i = new Intent(getApplicationContext(), Notifications.class);
		           startActivity(i);
		       }
		   });
		   
		   PopUpItem item1 = new PopUpItem(0, "Express a Rant", RantIt.class);
		   PopUpItem item2 = new PopUpItem(1, "Post a Shot", Shots.class);
		   PopUpItem item3 = new PopUpItem(2, "Upload a Video", Vids.class);
		   
		   final Popup ourNicePopup = new Popup(this);
		   
		   ourNicePopup.addItem(item1);
		   ourNicePopup.addItem(item2);
		   ourNicePopup.addItem(item3);
		   
		   ourNicePopup.setOnItemClickListener(new OnPopupItemClickListener() {
				@Override
				public void onItemClick(Class<?> activityClass, int itemId){
					startActivity(new Intent(Notifications.this, activityClass));
				}
			});
		   ImageButton button = (ImageButton)findViewById(R.id.imageButton3);
		   button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					ourNicePopup.show(v);
				}
			});
			
		   
		   ImageButton search = (ImageButton) findViewById(R.id.imageButton4);
		   search.setOnClickListener(new View.OnClickListener() { 
		       public void onClick(View v) {
		           Intent i = new Intent(getApplicationContext(), Search.class);
		           startActivity(i);
		       }
		   });
		   
		   ImageButton options = (ImageButton) findViewById(R.id.imageButton5);
		   options.setOnClickListener(new View.OnClickListener() { 
		       public void onClick(View v) {
		           Intent i = new Intent(getApplicationContext(), Profile.class);
		           startActivity(i);
		       }
		   });
		
		Resources res = getResources();
		int[] image = {R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon, R.drawable.icon};
		String[] name = res.getStringArray(R.array.name3);
		
		
		RowLayout3 adapter = new RowLayout3(this,name,image);
		setListAdapter(adapter);
		
		ListView list = getListView();
		list.setOnItemClickListener(new OnItemClickListener(){
	          public void onItemClick(AdapterView<?> parent, View view,
	                  int position, long id) {
	                   

	                 TextView title = (TextView) view.findViewById(R.id.name); 
	                 ImageView img = (ImageView) view.findViewById(R.id.meme1);

	                 String s = title.getText().toString();
	  
	                 Intent a;
		              switch(position){

		             case 0:
		                 a = new Intent(getApplicationContext(),Home.class);
		                 startActivity(a);
		                 break;
		             case 1:
		                 a = new Intent(getApplicationContext(),Vids.class);
		                 startActivity(a);
		                 break;
		             case 2:
		                 a = new Intent(getApplicationContext(),Shots.class);
		                 startActivity(a);
		                 break;
		             case 3:
		                 a = new Intent(getApplicationContext(),Shots.class);
		                 startActivity(a);
		                 break;
		             case 4:
		                 a = new Intent(getApplicationContext(),Home.class);
		                 startActivity(a);
		                 break;
		             case 5:
		                 a = new Intent(getApplicationContext(),Shots.class);
		                 startActivity(a);
		                 break;
		             case 6:
		                 a = new Intent(getApplicationContext(),Home.class);
		                 startActivity(a);
		                 break;
		             case 7:
		                 a = new Intent(getApplicationContext(),Shots.class);
		                 startActivity(a);
		                 break;
		             case 8:
		                 a = new Intent(getApplicationContext(),Shots.class);
		                 startActivity(a);
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
