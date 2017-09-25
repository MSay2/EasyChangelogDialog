package com.msay2.changelogeedialoglibrary.preferences;

import android.support.annotation.NonNull;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.*;

/*
 * EasyChangelogDialog library
 *
 * Copyright (c) 2017 Dani Mahardhika and Meclot Yoann
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

public class Preferences
{
	private final Context context;

    private static final String PREFERENCES_NAME = "boo_preferences";
	
	private static final String KEY_APP_VERSION = "app_version";
	
	public Preferences(@NonNull Context context)
	{
        this.context = context;
    }
	
	private SharedPreferences getSharedPreferences() 
	{
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }
	
	private int getVersion() 
	{
        return getSharedPreferences().getInt(KEY_APP_VERSION, 0);
    }

	private void setVersion(int version)
	{
        getSharedPreferences().edit().putInt(KEY_APP_VERSION, version).apply();
    }

	public boolean isNewVersion() 
	{
        int version = 0;
        try 
		{
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
		catch (PackageManager.NameNotFoundException e)
		{ }
        if (version > getVersion())
		{
            setVersion(version);
			return true;
        }
		else 
		{
            return false;
        }
    }
	
	public int getVersionCode()
	{
		int version = 0;
        try 
		{
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
		catch (PackageManager.NameNotFoundException e)
		{ }
		
		return version;
	}
	
	public String getVersionName()
	{
		String version = "0";
		try
		{
			version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
		}
		catch (PackageManager.NameNotFoundException e)
		{}
		
		return version;
	}
}
