package com.github.thebetterteam.tdmystudent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Calendar;

public class GoalActivity extends AppCompatActivity {
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        LinearLayout btnHome = findViewById(R.id.goal_btnHome);
        LinearLayout btnApplyLoan = findViewById(R.id.goal_btnApplyLoan);
        LinearLayout btnRefer = findViewById(R.id.goal_btnRefer);
        Button btnEnrollment = findViewById(R.id.goal_btnEnrollmentCalendar);
        Button btnGraduation = findViewById(R.id.goal_btnGraduationCalendar);

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

        btnEnrollment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCalendar(R.id.goal_editEnrollment);
            }
        });

        btnGraduation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCalendar(R.id.goal_editGraduation);
            }
        });
    }

    private void displayMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void displayLoanApplicationActivity() {
        Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://www.td.com/ca/en/personal-banking/products/borrowing/lines-of-credit/student-line-of-credit/#/university"));
        startActivity(i);
    }

    private void displayReferralActivity() {
        Intent i = new Intent(this, ReferralActivity.class);
        startActivity(i);
    }

    private void displayCalendar(int editId) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        final EditText eText = findViewById(editId);

        // date picker dialog
        picker = new DatePickerDialog(GoalActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        picker.show();
    }
}
