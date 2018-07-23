package com.github.thebetterteam.tdmystudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class GoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        LinearLayout btnHome = findViewById(R.id.goal_btnHome);
        LinearLayout btnApplyLoan = findViewById(R.id.goal_btnApplyLoan);
        LinearLayout btnRefer = findViewById(R.id.goal_btnRefer);

        // Event-listeners
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayMainActivity();
            }
        });

        btnApplyLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLoanApplicationActivity();
            }
        });

        btnRefer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayReferralActivity();
            }
        });
    }

    private void displayMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void displayLoanApplicationActivity() {
        Intent i = new Intent(this, LoanApplicationActivity.class);
        startActivity(i);
    }

    private void displayReferralActivity() {
        Intent i = new Intent(this, ReferralActivity.class);
        startActivity(i);
    }
}
