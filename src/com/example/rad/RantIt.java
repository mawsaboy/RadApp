package com.example.rad;

import com.example.pleaseganana.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RantIt extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rantit);
		
		Button addRad = (Button) findViewById(R.id.button1);
		   addRad.setOnClickListener(new View.OnClickListener() { 
		       public void onClick(View v) {
		           Intent i = new Intent(getApplicationContext(), Home.class);
		           startActivity(i);
		       }
		   });
		   
		   ActionBar actionBar = getActionBar();
	        actionBar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rant_it, menu);
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
