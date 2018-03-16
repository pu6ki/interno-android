package hacktues.interno.com.interno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseCategory extends AppCompatActivity {

    Button btnContestant;
    Button btnRecruiter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_choose_category);
        btnContestant = (Button) findViewById(R.id.btn_contestant);
        btnRecruiter = (Button) findViewById(R.id.btn_recruiter);
        buttonEventListner();
    }

    public void buttonEventListner(){
        btnRecruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ChooseCategory.this, RegisterRecruiter.class);
                startActivity(intent);
            }
        });
        btnContestant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ChooseCategory.this, RegisterContestant.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
