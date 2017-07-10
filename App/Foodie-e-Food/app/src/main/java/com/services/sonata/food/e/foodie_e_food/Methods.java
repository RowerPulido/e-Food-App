package com.services.sonata.food.e.foodie_e_food;

import android.text.TextUtils;
import android.widget.TextView;

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
}
