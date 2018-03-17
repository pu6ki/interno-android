package hacktues.interno.com.interno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterRecruiter extends AppCompatActivity {

    Button btnRegisterRecruiter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_recruiter);
        btnRegisterRecruiter = (Button) findViewById(R.id.btn_register_recruiter);
        btnListener();
    }

    public void btnListener(){
        btnRegisterRecruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            EditText company = (EditText)findViewById(R.id.register_recruiter_company);
            EditText password = (EditText)findViewById(R.id.register_recruiter_password);
            EditText repassword = (EditText)findViewById(R.id.register_recruiter_repassword);
            EditText country = (EditText)findViewById(R.id.register_recruiter_country);

            String companystr = company.getText().toString();
            String passwordstr = password.getText().toString();
            String repasswordstr = repassword.getText().toString();
            String countrystr = country.getText().toString();

            if(companystr.trim().equals("") || countrystr.trim().equals("") {
                Toast blank_error = Toast.makeText(RegisterRecruiter.this, "Fill the empty blank!",
                Toast.LENGTH_SHORT);
                blank_error.show();
            }
            if(!passwordstr.equals(repasswordstr)) {
                //popup message
                Toast pass_error = Toast.makeText(RegisterRecruiter.this, "Passwords don't match!",
                Toast.LENGTH_LONG);
                pass_error.show();
            }
            else {
                intent = new Intent(RegisterRecruiter.this, ContestHome.class);
                startActivity(intent);
            }
            }
        });
    }
}
