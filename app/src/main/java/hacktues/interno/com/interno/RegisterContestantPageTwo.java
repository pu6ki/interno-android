package hacktues.interno.com.interno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterContestantPageTwo extends AppCompatActivity {
    Intent intent;
    Button btnRegisterContestant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_register_contestant_page_two);
        btnRegisterContestant = (Button) findViewById(R.id.btn_register_contestant);
        btnListener();
    }

    public void btnListener(){
        btnRegisterContestant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            EditText first_name = (EditText)findViewById(R.id.register_contestant_first_name);
            EditText last_name = (EditText)findViewById(R.id.register_contestant_last_name);
            EditText school = (EditText)findViewById(R.id.register_contestant_school);
            EditText country = (EditText)findViewById(R.id.register_contestant_country);

            String first_namestr = first_name.getText().toString();
            String last_namestr = last_name.getText().toString();
            String schoolstr = school.getText().toString();
            String countrystr = country.getText().toString();

            if(first_namestr.trim().equals("") || last_namestr.trim().equals("") ||
                schoolstr.trim().equals("") || countrystr.trim().equals("")) {
                Toast blank_error = Toast.makeText(RegisterContestantPageTwo.this, "Fill the empty blank!",
                Toast.LENGTH_SHORT);
                blank_error.show();
            }
            else {
                intent = new Intent(RegisterContestantPageTwo.this, ContestHome.class);
                startActivity(intent);
            }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
