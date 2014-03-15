$ git tag
v1.0 

package com.example.rad;

import com.example.pleaseganana.R;

import android.app.Activity;         // imports
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 
public class MainActivity extends Activity {    


    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
     
        
        setContentView(R.layout.activity_main); 

  
 
        Button registerScreen = (Button) findViewById(R.id.button2);
        
        
      
        
        registerScreen.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });
        
        Button home = (Button) findViewById(R.id.button1);
        
        home.setOnClickListener(new View.OnClickListener() {
        	 
            public void onClick(View v) {
                // Switching to Home screen
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });
        	
    }
}
