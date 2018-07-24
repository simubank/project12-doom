package com.github.thebetterteam.tdmystudent;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

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

import com.github.thebetterteam.tdmystudent.ContriConfirmationDialog;

public class ContributeSavings extends AppCompatActivity {
    public static final String authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDQlAiLCJ0ZWFtX2lkIjoiMjgxMzgzMSIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiYXBwX2lkIjoiNDg3MDgwZTYtYWI4ZS00ODg2LWI1ZjQtMWI3ODZjNDQxMWI3In0.wfe66aSnxjG87z12Dz43Yqy-ehUEqz4Qd_oZyMubvds";
    public static final VirtualBank vb = VirtualBank.getBank(authToken);
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contribute_savings);
        Button btnContri = findViewById(R.id.cs_btnContri);


        btnContri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.cs_ContributeInput);
                String contributeAmount = editText.getText().toString();
                customDialog("Confirmation","Contribute now?", contributeAmount);
            }
        });
    }

    private void cancelMethod1(){
    }
    private void okMethod1(final String contributeAmount){

        Intent intent = new Intent(this, MainActivity.class);
        String message = contributeAmount;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

        /*vb.getBankAccount(getBaseContext(), "487080e6-ab8e-4886-b5f4-1b786c4411b7_27ccd2e1-adc7-4902-8cd0-b4baa8558480", new VirtualBankGetBankAccountRequest() {
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
        });*/

    }



    public void customDialog(String title, String message, final String contributeAmount){
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.mipmap.ic_launcher);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);
        builderSingle.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cancelMethod1();
                    }
                });

        builderSingle.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        okMethod1(contributeAmount);
                    }
                });


        builderSingle.show();
    }


}

