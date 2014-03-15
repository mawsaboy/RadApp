package com.example.rad;

import com.example.pleaseganana.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class RowLayout1 extends ArrayAdapter<String>{
	Context context;
	int images[];
	String [] titles;
	String [] descs;
	public RowLayout1(Context con, String[] name, int image[], String [] desc){	
		super(con,R.layout.rowlayout1,R.id.name,name);
		this.context = con;
		this.images = image;
		this.titles = name;
		this.descs = desc;
	}

public class MyViewHolder{
	ImageView image;
	TextView title;
	TextView desc;
	public MyViewHolder(View v){
		image = (ImageView) v.findViewById(R.id.meme1);
		title = (TextView) v.findViewById(R.id.name);
		desc = (TextView) v.findViewById(R.id.desc);
		
	}
	

}
	
	@Override
	public View getView(int position, View convertView , ViewGroup parent){
		View row = convertView;
		MyViewHolder hold = null;
		if(row==null){
    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row = inflater.inflate(R.layout.rowlayout1, parent, false);
		hold = new MyViewHolder(row);
		row.setTag(hold);
		}
		else{
			hold = (MyViewHolder) row.getTag();
		}
		
		hold.image.setImageResource(images[position]);
		hold.title.setText(titles[position]);
		hold.desc.setText(descs[position]);
		
	return row;
	}
}
