package hacktues.interno.com.interno;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText mEtEmail;
    EditText mEtPassword;

    Button mBtnLogin;
    Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_login);

        mEtEmail = (EditText) findViewById(R.id.email);
        mEtPassword = (EditText) findViewById(R.id.password);

        mBtnLogin = (Button) findViewById(R.id.sign_in_button);
        mBtnRegister = (Button) findViewById(R.id.register_button);

        buttonsOnClickListeners();
    }

    private void buttonsOnClickListeners(){
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ChooseCategory.class);
                startActivity(intent);
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEtEmail.getText().toString();
                String password = mEtPassword.getText().toString();
                Uri.Builder urlBuilder = new Uri.Builder()
                        .scheme("http")
                        .authority("hack-interno.herokuapp.com")
                        .appendPath("users")
                        .appendPath("sign_in.json");

                String url = urlBuilder.build().toString();
                JSONObject jsonBody = new JSONObject();

                try{
                    jsonBody.put("email",email);
                    jsonBody.put("password", password);
                }catch(JSONException e){
                    e.printStackTrace();
                }

                sendLoginData(url, jsonBody);
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }

    private void sendLoginData(String url, JSONObject credentials){
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);

        JsonObjectRequest jsonobj = new JsonObjectRequest(
                Request.Method.POST,
                url,
                credentials,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String token = response.getString("authentication_token");
                            DatabaseHelper db = new DatabaseHelper(LoginActivity.this);
                            db.insertToken(token);
                            db.close();
                            Intent intent = new Intent(LoginActivity.this, ContestHome.class);
                            startActivity(intent);
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
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
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                return headers;
            }
        };
        requestQueue.add(jsonobj);
    }
}
