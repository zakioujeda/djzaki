package ixa.liveweb.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ixa.liveweb.R;

public class NoNetWorkActivity extends AppCompatActivity {

    Button No_Network_Button;

    boolean connectednetwork = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_net_work);

        No_Network_Button = (Button)findViewById(R.id.No_Network_Button);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            No_Network_Button.setBackground(getDrawable(R.drawable.ripple_color_03));

        } else {

            No_Network_Button.setBackgroundColor(getResources().getColor(R.color.main_background));
        }

        No_Network_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckNetworkState();
            }
        });
    }

    private void CheckNetworkState() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        /** Check Network State */
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            connectednetwork = true;

            OpenIntentMainActivity();

        } else {

            connectednetwork = false;

            OpenIntentNoNetworkActivity();
        }
    }

    private void OpenIntentNoNetworkActivity() {

        Intent intent = new Intent(NoNetWorkActivity.this,NoNetWorkActivity.class);
        startActivity(intent);
        finish();
    }

    private void OpenIntentMainActivity() {

        Intent intent = new Intent(NoNetWorkActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
