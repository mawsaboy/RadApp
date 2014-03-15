package com.example.rad;

import com.example.pleaseganana.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class RowLayout6 extends ArrayAdapter<String>{
	Context context;
	int images[];
	String [] titles;
	public RowLayout6(Context con, String[] name){	
		super(con,R.layout.rowlayout6,name);
		this.context = con;
		this.titles = name;

	}

public class MyViewHolder{
	TextView title;
	
	public MyViewHolder(View v){
		
		
		
	}
	

}
	
	@Override
	public View getView(int position, View convertView , ViewGroup parent){
		View row = convertView;
		MyViewHolder hold = null;
		if(row==null){
    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row = inflater.inflate(R.layout.rowlayout6, parent, false);
		hold = new MyViewHolder(row);
		row.setTag(hold);
		}
		else{
			hold = (MyViewHolder) row.getTag();
		}
		
		hold.title.setText(titles[position]);
		
	return row;
	}
}
