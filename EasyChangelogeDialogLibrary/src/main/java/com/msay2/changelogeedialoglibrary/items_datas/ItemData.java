package com.msay2.changelogeedialoglibrary.items_datas;

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

public class ItemData
{
	private String changelog;
	private int drawable, color;
	
	public ItemData()
	{ }
	
	public ItemData(String changelog, int drawable, int color)
	{
		this.changelog = changelog;
		this.drawable = drawable;
		this.color = color;
	}
	
	public String getChangelog()
	{
		return changelog;
	}
	
	public void setChangelog(String changelog)
	{
		this.changelog = changelog;
	}
	
	public int getDrawable()
	{
		return drawable;
	}
	
	public void setDrawable(int drawable, int color)
	{
		this.drawable = drawable;
		this.color = color;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
}
