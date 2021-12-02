package ixa.liveweb.Theme;

import android.app.Activity;
import android.content.Intent;

import ixa.liveweb.Activities.MainActivity;
import ixa.liveweb.R;

public class Utils
{
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_2 = 1;
    public final static int THEME_3 = 2;
    public final static int THEME_4 = 3;
    public final static int THEME_5 = 4;
    public final static int THEME_6 = 5;

    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, MainActivity.class));
    }
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case THEME_2:
                activity.setTheme(R.style.AppTheme2);
                break;
            case THEME_3:
                activity.setTheme(R.style.AppTheme3);
                break;
            case THEME_4:
                activity.setTheme(R.style.AppTheme4);
                break;
            case THEME_5:
                activity.setTheme(R.style.AppTheme5);
                break;
            case THEME_6:
                activity.setTheme(R.style.AppTheme6);
                break;
        }
    }
}