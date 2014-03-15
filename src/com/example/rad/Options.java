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
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.*;
import android.widget.ListView;

public class Options extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 ActionBar actionBar = getActionBar();
	        actionBar.setDisplayHomeAsUpEnabled(true);
		
		Resources res = getResources();
		int[] image = {R.drawable.editprof, R.drawable.settings, R.drawable.arrowright };
		String[] name = res.getStringArray(R.array.optheader);
		
		
		RowLayout4 adapter = new RowLayout4(this,name,image);
		setListAdapter(adapter);
		
		ListView list = getListView();
		list.setOnItemClickListener(new OnItemClickListener(){
	          public void onItemClick(AdapterView<?> parent, View view,
	                  int position, long id) {
	                   

	                 TextView title = (TextView) view.findViewById(R.id.headname); 
	                 ImageView img = (ImageView) view.findViewById(R.id.image);

	                 String s = title.getText().toString();
	  
	                 Intent a;
		              switch(position){

		             case 0:
		                 a = new Intent(getApplicationContext(),EditProfile.class);
		                 startActivity(a);
		                 break;
		             case 1:
		                 a = new Intent(getApplicationContext(),Settings.class);
		                 startActivity(a);
		                 break;
		             case 2:
		                 a = new Intent(getApplicationContext(),MainActivity.class);
		                 startActivity(a);
		                 break;
		            
		             }           

	              }
	            });
	}	

}