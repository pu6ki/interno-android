package hacktues.interno.com.interno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterContestant extends AppCompatActivity {

    Intent intent;
    Button regContestantContinueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_contestant);
        regContestantContinueBtn = (Button) findViewById(R.id.btn_register_contestant_continue);
        btnListener();
    }

    public void btnListener(){
        regContestantContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            EditText username = (EditText)findViewById(R.id.register_contestant_username);
            EditText email = (EditText)findViewById(R.id.register_contestant_email);
            EditText password = (EditText)findViewById(R.id.register_contestant_password);
            EditText repassword = (EditText)findViewById(R.id.register_contestant_repassword);

            String usernamestr = username.getText().toString();
            String emailstr = email.getText().toString();
            String passwordstr = password.getText().toString();
            String repasswordstr = repassword.getText().toString();

            if(usernamestr.trim().equals("") || emailstr.trim().equals("")) {
                Toast blank_error = Toast.makeText(RegisterContestant.this, "Fill the empty blank!",
                Toast.LENGTH_SHORT);
                blank_error.show();
            }
            else if(!passwordstr.equals(repasswordstr)) {
                //popup message
                Toast pass_error = Toast.makeText(RegisterContestant.this, "Passwords don't match!",
                Toast.LENGTH_SHORT);
                pass_error.show();
            }
            else {
                intent = new Intent(RegisterContestant.this, RegisterContestantPageTwo.class);
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
