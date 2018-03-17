package hacktues.interno.com.interno;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class CompaniesActivity extends AppCompatActivity {

    private static final String TAG = "CompaniesActivity";

    private ListView mListViewContests;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            // TODO: Direct intents at activities
            switch (item.getItemId()) {
                case R.id.navigation_companies:
                    intent = new Intent(CompaniesActivity.this, CompaniesActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_home:
                    intent = new Intent(CompaniesActivity.this, ContestHome.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_profile:
                    intent = new Intent(CompaniesActivity.this, Profile.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_companies);
    }
}
