package com.example.rad;

import com.example.pleaseganana.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class RowLayout3 extends ArrayAdapter<String>{
	Context context;
	int images[];
	String [] titles;
	public RowLayout3(Context con, String[] name, int image[]){	
		super(con,R.layout.rowlayout3,R.id.name,name);
		this.context = con;
		this.images = image;
		this.titles = name;

	}

public class MyViewHolder{
	ImageView image;
	TextView title;
	
	public MyViewHolder(View v){
		image = (ImageView) v.findViewById(R.id.meme1);
		title = (TextView) v.findViewById(R.id.name);
		
	}
	

}
	
	@Override
	public View getView(int position, View convertView , ViewGroup parent){
		View row = convertView;
		MyViewHolder hold = null;
		if(row==null){
    	LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		row = inflater.inflate(R.layout.rowlayout3, parent, false);
		hold = new MyViewHolder(row);
		row.setTag(hold);
		}
		else{
			hold = (MyViewHolder) row.getTag();
		}
		
		hold.image.setImageResource(images[position]);
		hold.title.setText(titles[position]);
		
	return row;
	}
}
