package com.msay2.changelogeedialoglibrary.helpers;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.widget.AppCompatDrawableManager;

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

public class DrawableHelper
{
	@Nullable
	public static Drawable getDrawable(@NonNull Context context, @DrawableRes int res)
	{
		Drawable drawable = AppCompatDrawableManager.get().getDrawable(context, res);
		return drawable.mutate();
	}
	
	@Nullable
    public static Drawable getTintedDrawable(@NonNull Context context, @DrawableRes int res, @ColorInt int color)
	{
        try 
		{
            Drawable drawable = AppCompatDrawableManager.get().getDrawable(context, res);
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);

			return drawable.mutate();
        } 
		catch (OutOfMemoryError e)
		{
            return null;
        }
    }
}
