package com.example.ctintegration;

import android.os.Bundle;
import com.clevertap.android.sdk.CleverTapAPI;
import android.app.NotificationManager;
import java.util.Date;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();

//Update pre-defined profile properties
        profileUpdate.put("Name", "Valeed Kottuvala");
        profileUpdate.put("Email", "valeedk@icloud.com");
//Update custom profile properties
        profileUpdate.put("Plan Type", "Silver");
        profileUpdate.put("Phone", "+917977653302");
        profileUpdate.put("Gender", "Male");
        profileUpdate.put("MSG-push", true);
        profileUpdate.put("MSG-sms", true);
        profileUpdate.put("MSG-email", true);
        profileUpdate.put("MSG-whatsapp", true); // Enable push notifications


        clevertapDefaultInstance.pushProfile(profileUpdate);
        clevertapDefaultInstance.pushEvent("Product viewed");

        HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
        prodViewedAction.put("Product Name", "Diamond Jewelry");
        prodViewedAction.put("Category", "Jewelry");
        prodViewedAction.put("Price", 99.99);
        prodViewedAction.put("Date", new Date());

        clevertapDefaultInstance.pushEvent("Product viewed", prodViewedAction);
        CleverTapAPI.getDefaultInstance(getApplicationContext()).onUserLogin(profileUpdate);
        CleverTapAPI.createNotificationChannel(getApplicationContext(),"RNTesting","My channel","Your Channel Description",NotificationManager.IMPORTANCE_MAX,true);
        setContentView(R.layout.activity_main);
    }
}