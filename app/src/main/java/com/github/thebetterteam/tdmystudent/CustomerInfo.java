package com.github.thebetterteam.tdmystudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class CustomerInfo extends AppCompatActivity {
    public static final String authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJDQlAiLCJ0ZWFtX2lkIjoiMjgxMzgzMSIsImV4cCI6OTIyMzM3MjAzNjg1NDc3NSwiYXBwX2lkIjoiNDg3MDgwZTYtYWI4ZS00ODg2LWI1ZjQtMWI3ODZjNDQxMWI3In0.wfe66aSnxjG87z12Dz43Yqy-ehUEqz4Qd_oZyMubvds";
    public static final VirtualBank vb = VirtualBank.getBank(authToken);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);

        vb.getCustomer(getBaseContext(), "487080e6-ab8e-4886-b5f4-1b786c4411b7_6c8434d3-9d00-45d9-83d6-5c87cc97cdd8", new VirtualBankGetCustomerRequest() {
            @Override
            public void onSuccess(VirtualBankCustomer response) {
                TextView textView1 = findViewById(R.id.textView1);
                TextView textView2 = findViewById(R.id.textView2);
                String givenname;
                givenname = response.getGivenName();
                String surname;
                surname = response.getSurname();
                String occupation = response.getPrimaryOccupation();
                textView1.setText("Name: " + givenname + surname);
                textView2.setText("Occupation: " + occupation);
            }
            @Override
            public void onError(VolleyError error) {
                // handle the error
            }
        });

        vb.getBankAccount(getBaseContext(), "487080e6-ab8e-4886-b5f4-1b786c4411b7_27ccd2e1-adc7-4902-8cd0-b4baa8558480", new VirtualBankGetBankAccountRequest() {
            @Override
            public void onSuccess(VirtualBankBankAccount response) {
                TextView textView3 = findViewById(R.id.textView3);
                String balance;
                balance = Double.toString(response.getBalance());
                textView3.setText("Account Balance: " + "$" + balance);
            }

            @Override
            public void onError(VolleyError error) {

            }
        });


    }
}
