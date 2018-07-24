package com.github.thebetterteam.tdmystudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.td.virtualbank.VirtualBank;
import com.td.virtualbank.VirtualBankAccount;
import com.td.virtualbank.VirtualBankBankAccount;
import com.td.virtualbank.VirtualBankBranch;
import com.td.virtualbank.VirtualBankCustomer;
import com.td.virtualbank.VirtualBankGetCustomerAccountsRequest;
import com.td.virtualbank.VirtualBankGetBankAccountRequest;
import com.td.virtualbank.VirtualBankGetBranchesRequest;
import com.td.virtualbank.VirtualBankGetCustomerRequest;
import com.td.virtualbank.VirtualBankPostTransferRequest;

public class MainActivity extends AppCompatActivity {
    public static final String authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDQlAiLCJ0ZWFtX2lkIjoiMjgxMzgzMSIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiYXBwX2lkIjoiNDg3MDgwZTYtYWI4ZS00ODg2LWI1ZjQtMWI3ODZjNDQxMWI3In0.wfe66aSnxjG87z12Dz43Yqy-ehUEqz4Qd_oZyMubvds";
    public static final VirtualBank vb = VirtualBank.getBank(authToken);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout btnGoalDetails = findViewById(R.id.main_btnGoalDetails);
        LinearLayout btnApplyLoan = findViewById(R.id.main_btnApplyLoan);
        LinearLayout btnRefer = findViewById(R.id.main_btnRefer);
        Button btnContribute = findViewById(R.id.main_btnContribute);
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

        btnContribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayContributeSavings();
            }
        });

        btnCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCustomerInfo();
            }
        });

    }

    /*@Override
    public void onResume(){
        super.onResume();
        Log.d("resume worked","resume worked");
        Intent intent = getIntent();
        String message = intent.getStringExtra(ContributeSavings.EXTRA_MESSAGE);
        final Double contributeAmount = Double.parseDouble(message);
        vb.getBankAccount(getBaseContext(), "487080e6-ab8e-4886-b5f4-1b786c4411b7_27ccd2e1-adc7-4902-8cd0-b4baa8558480", new VirtualBankGetBankAccountRequest() {
            @Override
            public void onSuccess(VirtualBankBankAccount response) {
                Double balance = response.getBalance();
                Log.d("current balance", balance.toString());
                if (contributeAmount <= balance) {
                    //change in account
                    Double currentBalance = (balance - contributeAmount);
                    Log.d("mid balance", currentBalance.toString());
                    response.setBalance(currentBalance);
                    Log.d("after blanace", balance.toString());
                    //change the amount on progressbar
                    TextView savingsAmount = findViewById(R.id.main_txtSavingsAmount);
                    savingsAmount.setText("$" + currentBalance.toString());
                    //change the progress progressbar
                    ProgressBar prgSavings = (ProgressBar) findViewById(R.id.main_prgSavings);
                    String strSpendingGoal = findViewById(R.id.main_txtSpendingGoal).toString();
                    int intSpendingGoal = Integer.parseInt(strSpendingGoal.substring(1, strSpendingGoal.length()));
                    int percentage = Math.round(Math.round(currentBalance/intSpendingGoal));
                    prgSavings.setProgress(percentage);
                    //change percentage text
                    TextView savingsPercentage = findViewById(R.id.main_txtSavingsPercentage);
                    savingsAmount.setText("%" + Integer.toString(percentage));
                } else {
                    response.setBalance(0.0);
                }
            }

            @Override
            public void onError(VolleyError error) {

            }
        });

    } */

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

    private void displayContributeSavings() {
        Intent i = new Intent(this, ContributeSavings.class);
        startActivity(i);
    }

    private void displayCustomerInfo() {
        Intent i = new Intent(this, CustomerInfo.class);
        startActivity(i);
    }
}
