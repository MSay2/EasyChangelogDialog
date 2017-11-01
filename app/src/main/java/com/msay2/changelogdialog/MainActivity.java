package com.msay2.changelogdialog;

import android.app.*;
import android.os.*;

import android.support.v7.app.AppCompatActivity;

import com.msay2.changelogeedialoglibrary.dialog.DialogChangelog;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity 
{
	// Creation of variables
	Button btn_manual;
	String[] changelog = 
	{
		"Improvement",
		"Added a function that allows you to call the change log manually"
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		// Initializing the btn_manual variable
		btn_manual = (Button)findViewById(R.id.mainButton);
		
		// Obtain the click listener
		btn_manual.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				// Obtain the change log manually
				DialogChangelog.getDialogManual(MainActivity.this, DialogChangelog.Data.getDatas(changelog));
			}
		});
		
		// Initiate a wait of 2 seconds
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				// Obtain the change log automatically
				DialogChangelog.getDialogChangelog(MainActivity.this, DialogChangelog.Data.getDatas(changelog));
			}
		}, 2000);
    }
}
