package hacktues.interno.com.interno;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class ContestHome extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView mListViewContests;
=======

public class ContestHome extends AppCompatActivity {
>>>>>>> d01806351929ffa5d21d325870d6539b1527734a

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
                    return true;
                case R.id.navigation_profile:
                    intent = new Intent(ContestHome.this, Profile.class);
                    startActivity(intent);


                    break;
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
