package hacktues.interno.com.interno;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Profile extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            // TODO: Direct intents at activities
            switch (item.getItemId()) {
                case R.id.navigation_companies:
                    return true;
                case R.id.navigation_home:
                    intent = new Intent(Profile.this, ContestHome.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_profile:
                    intent = new Intent(Profile.this, Profile.class);
                    startActivity(intent);
                    break;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_profile);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    public void changeToProfile(View v){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}
