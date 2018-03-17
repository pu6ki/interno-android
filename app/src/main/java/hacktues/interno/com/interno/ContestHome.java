package hacktues.interno.com.interno;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Uri.Builder urlBuilder = new Uri.Builder()
                .scheme("http")
                .authority("hack-interno.herokuapp.com")
                .appendPath("contests.json");

        String url = urlBuilder.build().toString();

        getContestsData(url);

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

    private void getContestsData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(ContestHome.this);

        JsonObjectRequest jsonobj = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ArrayList<Contest> contests = new ArrayList<>();

                        try {
                            JSONArray array = response.getJSONArray("contests");
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject row = array.getJSONObject(i);
                                Integer id = row.getInt("id");
                                String title = row.getString("title");
                                String description = row.getString("description");
//                                String deadline = row.getString("deadline");
//                                String position = row.getString("position");

                                JSONObject recruiter = row.getJSONObject("recruiter");
                                System.out.println(recruiter);
                                Company company = new Company(
                                    recruiter.getInt("id"),
                                    recruiter.getString("company_name"),
                                    null
//                                   recruiter.getString("description")
                                );

                                contests.add(
                                        new Contest(
                                                id,
                                                company,
                                                title,
                                                description,
                                                null,
                                                null,
                                                "python"
                                        )
                                );
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        ContestListAdapter adapter = new ContestListAdapter(ContestHome.this, R.layout.adapter_contests_layout, contests);
                        mListViewContests.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.toString());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();

                headers.put("X-User-Email", "recruiter@gmail.com");
                headers.put("X-User-Token", "iwzUVJt-UUL3_LWny4g5");

                headers.put("Content-Type", "application/json");

                return headers;
            }
        };
        requestQueue.add(jsonobj);
    }
}
