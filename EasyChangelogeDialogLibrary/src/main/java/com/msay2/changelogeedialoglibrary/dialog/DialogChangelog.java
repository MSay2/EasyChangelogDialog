package com.msay2.changelogeedialoglibrary.dialog;

import com.msay2.changelogeedialoglibrary.R;
import com.msay2.changelogeedialoglibrary.preferences.Preferences;
import com.msay2.changelogeedialoglibrary.adapter.Adapter;
import com.msay2.changelogeedialoglibrary.items_datas.ItemData;
import com.msay2.changelogeedialoglibrary.widget.TextViewFormat;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;

import android.support.annotation.NonNull;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

/*
 * EasyChangelogDialog library
 *
 * Copyright (c) 2017 Meclot Yoann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class DialogChangelog
{
	private static RecyclerView recycler;
	private static Adapter adapter;
	private static TextView version_number;
	private static AlertDialog dialog;
	private static Activity mActivity;
	private static View mView;
	private static List<ItemData> item_data;
	
	private static Preferences get(@NonNull Context context)
	{
		return new Preferences(context);
	}
	
	private static void initRecyclerView(List<ItemData> item_data)
	{
		recycler = (RecyclerView)mView.findViewById(R.id.ma_recyclerView);
		recycler.setLayoutManager(new LinearLayoutManager(mActivity));
		recycler.setItemAnimator(new DefaultItemAnimator());
		
		adapter = new Adapter(mActivity, item_data);
		
		recycler.setAdapter(adapter);
	}
	
	private static void setVersion(String version)
	{
		version_number = (TextView)mView.findViewById(R.id.id_version_name);
		version_number.setText(version);
	}
	
	private static void obtainDialogChangelog(Activity activity, List<ItemData> item_data)
	{
		mActivity = activity;
		
		View view = mView = mActivity.getLayoutInflater().inflate(R.layout.dialog_changelog, null);
		
		initRecyclerView(item_data);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(activity)
		    .setView(view)
		    .setPositiveButton("Ok", new DialogInterface.OnClickListener()
			{
				@Override
				public void onClick(DialogInterface dialog, int position)
				{ }
			});
			
		dialog = builder.create();
		dialog.show();
	}
	
	public static void getDialogChangelog(Activity activity, List<ItemData> item_data)
	{
		if (get(activity).isNewVersion())
		{
			obtainDialogChangelog(activity, item_data);
			setVersion(get(activity).getVersionName());
		}
	}
	
	public static class Data
	{
		public static List<ItemData> getDatas(String[] changelogs)
		{
			item_data = new ArrayList<>();

			for (int i = 0; i < changelogs.length; i++)
			{
				ItemData item = new ItemData();
				item.setChangelog(changelogs[i]);

				item_data.add(item);
			}
			return item_data;
		}
	}
}
