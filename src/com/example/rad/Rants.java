package com.example.rad;

import java.util.ArrayList;
import java.util.List;

import com.example.pleaseganana.R;

import android.os.Bundle;
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

public class Rants extends ListActivity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Resources res = getResources();
		int[] image = {R.drawable.avatar_dark, R.drawable.avatar_dark, R.drawable.avatar_dark, R.drawable.avatar_dark, R.drawable.avatar_dark};
		String[] name = res.getStringArray(R.array.name);
		String[] desc = res.getStringArray(R.array.desc);
		
		RowLayout1 adapter = new RowLayout1(this,name,image,desc);
		setListAdapter(adapter);
		
		ListView list = getListView();
		list.setOnItemClickListener(new OnItemClickListener(){
	          public void onItemClick(AdapterView<?> parent, View view,
	                  int position, long id) {
	                   

	                 TextView title = (TextView) view.findViewById(R.id.name);
	                 TextView desc = (TextView) view.findViewById(R.id.desc);
	                 ImageView img = (ImageView) view.findViewById(R.id.meme1);

	                 String s = title.getText().toString();
	                 String d = desc.getText().toString();
	                 
	                 
	                 Intent intent = new Intent(getApplicationContext(), RantView.class);
	                 intent.putExtra("title",s);
	                 intent.putExtra("desc",d);
	                 intent.putExtra("image",position);
	                  startActivity(intent);
	              }
	            });
	}	

}