package com.msay2.changelogeedialoglibrary.adapter;

import com.msay2.changelogeedialoglibrary.R;
import com.msay2.changelogeedialoglibrary.items_datas.ItemData;
import com.msay2.changelogeedialoglibrary.widget.TextViewFormat;
import com.msay2.changelogeedialoglibrary.preferences.Preferences;

import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import java.util.List;

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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
	private Context context;
	private List<ItemData> item_data;
	
	public Adapter(Context context, List<ItemData> item_data)
	{
		this.context = context;
		this.item_data = item_data;
	}
	
	@Override
	public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_changelog, parent, false);
		
		ViewHolder vh = new ViewHolder(view);
		
		return vh;
	}

	@Override
	public void onBindViewHolder(Adapter.ViewHolder holder, int position)
	{
		ItemData item = item_data.get(position);
		
		holder.changelog.setHtml(item.getChangelog());
		holder.changelog.setTintedDrawable("left", R.drawable.ic_changelog_circle, Preferences.getAttributeColor(context, R.attr.colorAccent));
	}

	@Override
	public int getItemCount()
	{
		return item_data.size();
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder
	{
		private TextViewFormat changelog;
		
		ViewHolder(View itemView)
		{
			super(itemView);
			
			changelog = (TextViewFormat)itemView.findViewById(R.id.id_text);
		}
	}
}
