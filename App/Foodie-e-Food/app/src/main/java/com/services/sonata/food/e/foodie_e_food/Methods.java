package com.services.sonata.food.e.foodie_e_food;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by jorge on 10/07/2017.
 */

public abstract class Methods {
    public static boolean isNotNull(Object... o) {
        int nulls = 0;
        for (Object t : o) {
            if (t == null) {
                nulls++;
                break;
            }
        }
        return nulls == 0;
    }

    public static boolean isNotEmpty(TextView... t) {
        int emptys = 0;
        for (TextView temp : t) {
            if (TextUtils.isEmpty(temp.getText().toString())) {
                emptys++;
                break;
            }
        }
        return emptys == 0;
    }

    public static Drawable drawableFromURL(String imageURL) {
        Drawable d = null;
        try {
            InputStream data = (InputStream) new URL(imageURL).getContent();
            d = Drawable.createFromStream(data, imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
}
