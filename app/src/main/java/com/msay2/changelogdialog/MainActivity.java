package com.msay2.changelogdialog;

import android.app.*;
import android.os.*;

import android.support.v7.app.AppCompatActivity;

import com.msay2.changelogeedialoglibrary.dialog.DialogChangelog;
import com.msay2.changelogeedialoglibrary.items_datas.ItemData;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity 
{
	private List<ItemData> item_data;
	
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
				DialogChangelog.getDialogChangelog(MainActivity.this, getListItem());
			}
		}, 2000);
    }
	
	public List<ItemData> getListItem()
	{
		String[] changelog = { "Improvement", "Deletion", "Add new support", "Is Open Source" };
		int color = getResources().getColor(R.color.accent);
		item_data = new ArrayList<>();
		
		for (int i = 0; i < changelog.length; i ++)
		{
			ItemData item = new ItemData();
			item.setChangelog(changelog[i]);
			item.setDrawable(R.drawable.ic_changelog_circle, color);
			
			item_data.add(item);
		}
		return item_data;
	}
}
