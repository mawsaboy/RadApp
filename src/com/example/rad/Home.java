package com.example.rad;

import com.example.pleaseganana.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;


public class Home extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
	TabHost tabHost = getTabHost();
	TabHost.TabSpec spec;
	Intent intent;
	
	intent = new Intent().setClass(this, Rants.class);
	spec = tabHost.newTabSpec("RANTS").setIndicator("RANTS",null).setContent(intent);
	tabHost.addTab(spec);
	
	intent = new Intent().setClass(this, Shots.class);
	spec = tabHost.newTabSpec("SHOTS").setIndicator("SHOTS",null).setContent(intent);
	tabHost.addTab(spec);
	
	intent = new Intent().setClass(this, Vids.class);
	spec = tabHost.newTabSpec("VIDS").setIndicator("VIDS",null).setContent(intent);
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
           Intent i = new Intent(getApplicationContext(), Profile.class);
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
			startActivity(new Intent(Home.this, activityClass));
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

}
