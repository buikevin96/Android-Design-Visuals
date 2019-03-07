package com.example.kevinbui.dbintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        // Insert contacts
        Log.d("Insert: ", "Inserting...");
        db.addContact(new Contact("Paul", "7044975555"));
        db.addContact(new Contact("John", "4144140000"));
        db.addContact(new Contact("Rose", "7771112222"));
        db.addContact(new Contact("Bella", "5551111234"));

        // Read them back
        Log.d("Reading: ", "Reading all contacts...");
        List<Contact> contactList = db.getAllContacts();

        // Get 1 contact
        Contact oneContact = db.getContact(1);
        oneContact.setName("Pauloooo");
        oneContact.setPhoneNumber("0000000000");

        // Update contact
        int newContact = db.updateContact(oneContact);

        Log.d("One contact:", "Updated Row: " + String.valueOf(newContact) + "Name: " +oneContact.getName() + "Phone: " + oneContact.getPhoneNumber());
        db.deleteContact(oneContact);

        for (Contact c: contactList){
            String log = "ID: " + c.getId()+ " , Name: "+ c.getName() + ", Phone: " +c.getPhoneNumber();

            Log.d("Name: " , log);
        }
    }
}
