package com.github.thebetterteam.tdmystudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout btnGoalDetails = findViewById(R.id.main_btnGoalDetails);
        LinearLayout btnApplyLoan = findViewById(R.id.main_btnApplyLoan);
        LinearLayout btnRefer = findViewById(R.id.main_btnRefer);
        Button btnCus = findViewById(R.id.main_btnCus);

        // Event-listeners
        btnGoalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayGoalActivity();
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

        btnCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCustomerInfo();
            }
        });

    }

    private void displayGoalActivity() {
        Intent i = new Intent(this, GoalActivity.class);
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

    private void displayCustomerInfo() {
        Intent i = new Intent(this, CustomerInfo.class);
        startActivity(i);
    }
}
