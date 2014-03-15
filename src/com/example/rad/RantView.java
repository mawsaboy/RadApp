package com.example.rad;

import com.example.pleaseganana.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class RantView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rantview);
		
		int[] image = {R.drawable.avatar_dark, R.drawable.avatar_dark, R.drawable.avatar_dark, R.drawable.avatar_dark, R.drawable.avatar_dark};
		TextView titles = (TextView) findViewById(R.id.textView1);
        TextView descs = (TextView) findViewById(R.id.textView2);
        ImageView imgs = (ImageView) findViewById(R.id.image1);
        
    	Bundle extras = getIntent().getExtras();
        Intent i = getIntent();
        
        String title = i.getStringExtra("title");
        String desc = i.getStringExtra("desc");
        int pos = i.getIntExtra("image", 0);

        
        titles.setText(title);
        descs.setText(desc);
        imgs.setImageResource(image[pos]);
        
	}
}

