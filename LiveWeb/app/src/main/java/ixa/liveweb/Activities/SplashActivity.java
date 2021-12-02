package ixa.liveweb.Activities;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

import ixa.liveweb.Conts.Constants;
import ixa.liveweb.R;
import ixa.liveweb.Theme.Utils;

public class SplashActivity extends AppCompatActivity {

    DatabaseReference mDatabase,mDatabase2,mDatabase3,mDatabase4,mDatabase5,mDatabase6,mDatabase7;

    TextView Splash_Screen_Text;
    ImageView SplashScreenLogo;
    MyBounceInterpolator interpolator;

    View LP_View;
    ProgressBar Loading_Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseApp.initializeApp(this);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        /** Firebase Database Names */
        mDatabase = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_SPLASH_SCREEN)
                .child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION);
        mDatabase2 = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_SPLASH_SCREEN)
                .child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION).child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_STATE);
        mDatabase3 = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_SPLASH_SCREEN)
                .child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION).child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_CHILD_01);
        mDatabase4 = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_SPLASH_SCREEN)
                .child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION).child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_CHILD_02);
        mDatabase5 = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_SPLASH_SCREEN)
                .child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION).child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_LOGO);
        mDatabase6 = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_SPLASH_SCREEN);
        mDatabase7 = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_MAIN_ACTIVITY).child(Constants.DATABASE_APP_SETTINGS)
                .child(Constants.DATABASE_APP_SETTINGS_CHILD_THEMES).child(Constants.DATABASE_APP_SETTINGS_CHILD_THEMES_CHILD);

        SplashScreenLogo = findViewById(R.id.Splash_Screen_Logo);
        Splash_Screen_Text = findViewById(R.id.Splash_Screen_Text);
        LP_View = findViewById(R.id.LP_View);
        Loading_Progress = findViewById(R.id.loadingProgress);

        Loading_Progress.setProgress(0);
        ProgressStart();

        /** Check Network State */
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            mDatabase6.child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_STATE)
                    .child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN)
                    .addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String url = dataSnapshot.getValue(String.class);

                    if (url.equals(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_VALUE_RESULT)){

                        SPLASH_SCREEN_ON();

                    } else {

                        SPLASH_SCREEN_OFF();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

        } else {

            OpenIntentNoNetworkActivity();
        }
    }

    private void SPLASH_SCREEN_OFF() {

        chooseCurrentlyTheme();
    }

    private void chooseCurrentlyTheme() {

        mDatabase7.child(Constants.DATABASE_APP_SETTINGS_CHILD_THEMES_CHILD_VALUE)
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String string = dataSnapshot.getValue(String.class);

                        if (string.equals(Constants.DEFAULT_THEME)){

                            setThemeDEFAULT();
                        }
                        else if (string.equals(Constants.THEME_2)){

                            setTheme2();
                        }
                        else if (string.equals(Constants.THEME_3)){

                            setTheme3();
                        }
                        else if (string.equals(Constants.THEME_4)){

                            setTheme4();
                        }
                        else if (string.equals(Constants.THEME_5)){

                            setTheme5();
                        }
                        else if (string.equals(Constants.THEME_6)){

                            setTheme6();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }

    private void setThemeDEFAULT() {

        Utils.onActivityCreateSetTheme(SplashActivity.this);
        Utils.changeToTheme(SplashActivity.this, Utils.THEME_DEFAULT);
    }

    private void setTheme2() {

        Utils.onActivityCreateSetTheme(SplashActivity.this);
        Utils.changeToTheme(SplashActivity.this, Utils.THEME_2);
    }

    private void setTheme3() {

        Utils.onActivityCreateSetTheme(SplashActivity.this);
        Utils.changeToTheme(SplashActivity.this, Utils.THEME_3);
    }

    private void setTheme4() {

        Utils.onActivityCreateSetTheme(SplashActivity.this);
        Utils.changeToTheme(SplashActivity.this, Utils.THEME_4);
    }

    private void setTheme5() {

        Utils.onActivityCreateSetTheme(SplashActivity.this);
        Utils.changeToTheme(SplashActivity.this, Utils.THEME_5);
    }

    private void setTheme6() {

        Utils.onActivityCreateSetTheme(SplashActivity.this);
        Utils.changeToTheme(SplashActivity.this, Utils.THEME_6);
    }

    private void SPLASH_SCREEN_ON() {

        mDatabase3.child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_BOUNCE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                if (url.equals(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_BOUNCE_VALUE))
                    Splash_Screen_Anim_01();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        mDatabase4.child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_FADE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                if (url.equals(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_FADE_VALUE))
                    Splash_Screen_Anim_02();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase2.child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_NO_ANIMATION).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                if (url.equals(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_ANIMATION_NO_ANIMATION_VALUE))
                    Splash_Screen_Anim_03();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabase5.child(Constants.DATABASE_MAIN_ACTIVITY_SPLASH_SCREEN_LOGO_VALUE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String url = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(url)
                        .resize(512,512)
                        .into(SplashScreenLogo);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void Splash_Screen_Anim_03() {

        LP_View.setVisibility(View.GONE);
        SplashScreenLogo.setVisibility(View.VISIBLE);

        OpenIntentMainActivity();
    }

    private void Splash_Screen_Anim_02() {

        LP_View.setVisibility(View.GONE);
        SplashScreenLogo.setVisibility(View.VISIBLE);

        SplashScreenLogo.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadeanim));

        OpenIntentMainActivity();
    }

    private void Splash_Screen_Anim_01() {

        LP_View.setVisibility(View.GONE);
        SplashScreenLogo.setVisibility(View.VISIBLE);

        /** Splash Logo Animation*/
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        SplashScreenLogo.startAnimation(myAnim);

        OpenIntentMainActivity();
    }

    private void OpenIntentMainActivity() {

        /** Splash Screen Wait Time */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                chooseCurrentlyTheme();
            }
        },2500); // 1000 Millis  =  "1.0 Seconds"
    }

    private void OpenIntentNoNetworkActivity() {

        Intent intent = new Intent(SplashActivity.this,NoNetWorkActivity.class);
        startActivity(intent);
        finish();
    }

    private void ProgressStart() {

        Loading_Progress.setVisibility(View.VISIBLE);

        ObjectAnimator anim = ObjectAnimator.ofInt(Loading_Progress, "progress", 0, 100);
        anim.setDuration(1000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setRepeatCount(100);
        anim.start();

    }

    public void onBackPressed(){
        //empty
    }
}
