package com.bakeddeetz.asciinote2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
        addListenerOnButton(this);

        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void buttonClick(View v)
    {
    
    }
    
    public void addListenerOnButton(final Context context) {
    	 
		button = (Button) findViewById(R.id.button1);
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
				ImageView Iv = (ImageView)findViewById(R.id.imageView1);
			    Artwork artwork = new Artwork();
			   
			    Iv.setImageBitmap(artwork.convertImage("images/trollface_resampled.png",  Environment.getExternalStorageDirectory().getAbsolutePath()+ "/troll.txt",context));
 
			}
		
		});
    }
    
  }

