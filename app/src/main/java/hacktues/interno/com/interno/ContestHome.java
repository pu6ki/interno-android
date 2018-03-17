package hacktues.interno.com.interno;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContestHome extends AppCompatActivity {
    private static final String TAG = "ContestHome";

    private ListView mListViewContests;

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
                    intent = new Intent(ContestHome.this, ContestHome.class);
                    startActivity(intent);
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
        Log.d(TAG, "onCreate started");
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest_home);

        mListViewContests = (ListView) findViewById(R.id.lv_home_contests);

        ArrayList<Contest> contests = new ArrayList<>();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        Contest contest1 = new Contest(1, "Yes", "Yes", "Yes", 10000000, "Yes","Tech", 20);

        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);
        contests.add(contest1);

        ContestListAdapter adapter = new ContestListAdapter(this, R.layout.adapter_contests_layout, contests);
        mListViewContests.setAdapter(adapter);
        Log.d(TAG, "onCreate ended");
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    private void listViewItemListener(){
        mListViewContests.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
