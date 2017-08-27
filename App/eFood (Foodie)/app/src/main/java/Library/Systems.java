package Library;

/**
 * Created by Daniel Medina on 10/03/2017.
 *
 * @author Medina Cruz Jesús Daniel
 * @since 10/03/2017
 */

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public class Systems {

    private Activity activity;

    public Systems(Activity activity) {
        this.activity = activity;

        ActivityCompat.requestPermissions(activity, retrievePermissions(activity), 1);
    }

    private static String[] retrievePermissions(Context context) {
        try {
            return context
                    .getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS)
                    .requestedPermissions;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("This should have never happened.", e);
        }
    }
}