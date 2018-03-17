package hacktues.interno.com.interno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                intent = new Intent(RegisterContestant.this, RegisterContestantPageTwo.class);
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
