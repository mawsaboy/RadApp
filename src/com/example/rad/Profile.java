package com.example.rad;

import com.example.pleaseganana.R;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;


public class Profile extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		 ActionBar actionBar = getActionBar();
	        actionBar.setDisplayHomeAsUpEnabled(true);
	Resources res = getResources();
	TabHost tabHost = getTabHost();
	TabHost.TabSpec spec;
	Intent intent;
	
	intent = new Intent().setClass(this, Rants.class);
	spec = tabHost.newTabSpec("RANTS").setIndicator("",res.getDrawable(R.drawable.ranticon)).setContent(intent);
	tabHost.addTab(spec);
	
	intent = new Intent().setClass(this, Shots.class);
	spec = tabHost.newTabSpec("SHOTS").setIndicator("",res.getDrawable(R.drawable.shoticon)).setContent(intent);
	tabHost.addTab(spec);
	
	intent = new Intent().setClass(this, Vids.class);
	spec = tabHost.newTabSpec("VIDS").setIndicator("",res.getDrawable(R.drawable.play)).setContent(intent);
	tabHost.addTab(spec);
	
	tabHost.setCurrentTab(0);
	
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
			startActivity(new Intent(Profile.this, activityClass));
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
