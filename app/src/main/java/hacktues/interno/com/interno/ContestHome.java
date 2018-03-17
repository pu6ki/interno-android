package hacktues.interno.com.interno;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContestHome extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView mListViewContests;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Intent intent;
            // TODO: Direct intents at activities
            switch (item.getItemId()) {
                case R.id.navigation_companies:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        mListViewContests = (ListView) findViewById(R.id.lv_home_contests);

        ArrayList<Contest> contests = new ArrayList<>();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ContestListAdapter adapter = new ContestListAdapter(this, R.layout.adapter_contests_layout, contests);

    }

}
