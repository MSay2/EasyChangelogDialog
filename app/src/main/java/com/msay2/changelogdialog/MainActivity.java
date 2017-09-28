package com.msay2.changelogdialog;

import android.app.*;
import android.os.*;

import android.support.v7.app.AppCompatActivity;

import com.msay2.changelogeedialoglibrary.dialog.DialogChangelog;

public class MainActivity extends AppCompatActivity 
{
	String[] changelog = { "Improvement", "Deletion", "Add new support", "Is Open Source" };
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run()
			{
				DialogChangelog.getDialogChangelog(MainActivity.this, DialogChangelog.Data.getDatas(changelog));
			}
		}, 2000);
    }
}
