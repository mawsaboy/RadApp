package com.example.rad;

import com.example.pleaseganana.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

public class Search extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		 ActionBar actionBar = getActionBar();
	        actionBar.setDisplayHomeAsUpEnabled(true);
		
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
	           Intent i = new Intent(getApplicationContext(), Options.class);
	           startActivity(i);
	       }
	   });
	   
	   SearchView searchbutton = (SearchView) findViewById(R.id.searchView1);
	   searchbutton.setOnClickListener(new View.OnClickListener() { 
	       public void onClick(View v) {
	           Intent i = new Intent(getApplicationContext(), Home.class);
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
				startActivity(new Intent(Search.this, activityClass));
			}
		});
	   ImageButton button = (ImageButton)findViewById(R.id.imageButton3);
	   button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ourNicePopup.show(v);
			}
		});
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
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
