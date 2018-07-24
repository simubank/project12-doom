package com.github.thebetterteam.tdmystudent;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
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
        Button btnContact = findViewById(R.id.main_btnContact);

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

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactFinancialAdvisor();
            }
        });
    }

    private void displayGoalActivity() {
        Intent i = new Intent(this, GoalActivity.class);
        startActivity(i);
    }

    private void displayLoanApplicationActivity() {
        Intent i = new Intent("android.intent.action.VIEW", Uri.parse(getResources().getString(R.string.appointment_site)));
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

    private void contactFinancialAdvisor() {
        CharSequence options[] = getResources().getStringArray(R.array.contact_options);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(getResources().getString(R.string.alert_titleContact));
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choice) {
                Intent intent = null;
                switch (choice) {
                    case 0:  // Call
                        intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + getResources().getString(R.string.phone_advisor)));
                        break;
                    case 1:  // Text
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.putExtra("address", getResources().getString(R.string.text_td));
                        intent.setData(Uri.parse("sms:" + getResources().getString(R.string.text_td)));
                        break;
                    case 2:  // Book appointment
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse(getResources().getString(R.string.appointment_site)));
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });
        builder.setCancelable(true);
        builder.show();
    }
}
