package com.msay2.changelogeedialoglibrary.widget;

import com.msay2.changelogeedialoglibrary.helpers.DrawableHelper;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import android.support.annotation.DrawableRes;
import android.support.annotation.ColorInt;

import java.util.Locale;

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

public class TextViewFormat extends TextView
{
	private static Activity act;

	// Constructeur publique
	public TextViewFormat(Context context)
	{
		super(context);
		act = (Activity)context; // Obtention du support {@Activity} par la class {@Context}
	}

	// Constructeur publique
	public TextViewFormat(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		act = (Activity)context; // Obtention du support {@Activity} par la class {@Context}
	}

	// Constructeur publique
	public TextViewFormat(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		act = (Activity)context; // Obtention du support {@Activity} par la class {@Context}
	}

	// Obtention de l'écriture HTML
	public TextViewFormat setHtml(String html)
	{
		setText(Html.fromHtml(html));

		return this;
	}

	// Obtention de l'écriture Formater
	public TextViewFormat setFormat(String format, Object[] args)
	{
		setText(String.format(format, args));

		return this;
	}

	// Obtention de l'écriture Formater
	public TextViewFormat setFormat(Locale locale, String format, Object[] args)
	{
		setText(String.format(locale, format, args));

		return this;
	}


	/*
	 * Obtention du fichier XML {@Drawable}
	 * Incluant les emplacements voulus
	 * Dans la methode {@String} direction
	 * Gauche, Haut, Droite, Bas = left, top, right, bottom
	 */
	public TextViewFormat setDrawable(String direction, @DrawableRes int resDrawable)
	{
		Drawable icon = DrawableHelper.getDrawable(act, resDrawable);
		if (direction == null)
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		}
		else if (direction.equals("left"))
		{
			setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
		}
		else if (direction.equals("top"))
		{
			setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
		}
		else if (direction.equals("right"))
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null);
		}
		else if (direction.equals("bottom"))
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, icon);
		}
		else
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		}
		return this;
	}


	/*
	 * Obtention du fichier XML {@Drawable}
	 * Obtention de la coloration du fichier XML {@ColorInt}
	 * Incluant les emplacements voulus
	 * Dans la methode {@String} direction
	 * Gauche, Haut, Droite, Bas = left, top, right, bottom
	 */
	public TextViewFormat setTintedDrawable(String direction, @DrawableRes int resDrawable, @ColorInt int resColor)
	{
		Drawable icon = DrawableHelper.getTintedDrawable(act, resDrawable, resColor);
		if (direction == null)
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		}
		else if (direction.equals("left"))
		{
			setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
		}
		else if (direction.equals("top"))
		{
			setCompoundDrawablesWithIntrinsicBounds(null, icon, null, null);
		}
		else if (direction.equals("right"))
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, icon, null);
		}
		else if (direction.equals("bottom"))
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, icon);
		}
		else
		{
			setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
		}
		return this;
	}
}
