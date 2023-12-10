package com.anshul.buzzme;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anshul.buzzme.databinding.ActivityHelpPageBinding;
import com.bumptech.glide.Glide;

public class HelpActivityPage extends AppCompatActivity {

    ActivityHelpPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHelpPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Help");



        binding.helpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HelpActivityPage.this);
                builder.setTitle("Help Center");
                LinearLayout layout = new LinearLayout(HelpActivityPage.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setPadding(60, 10, 10, 10);
                final TextView txtview = new TextView(HelpActivityPage.this);
                txtview.setText(getString(R.string.help_center));
                layout.addView(txtview);
                builder.setView(layout);
                builder.create().show();

            }
        });
        binding.contactLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HelpActivityPage.this);
                builder.setTitle("Contact Info");

                LinearLayout layout = new LinearLayout(HelpActivityPage.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setPadding(60, 10, 10, 10);
                final TextView txtview = new TextView(HelpActivityPage.this);
                txtview.setText("Email\t:\tchatbuzz11@gmail.com");
                layout.addView(txtview);
                builder.setView(layout);
                builder.create().show();
            }
        });
        binding.policyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.accountLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HelpActivityPage.this);
                builder.setTitle("App Info");

                LinearLayout layout = new LinearLayout(HelpActivityPage.this);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setPadding(60, 10, 10, 10);

                final TextView txtview = new TextView(HelpActivityPage.this);
                txtview.setText(getString(R.string.app_info));
                layout.addView(txtview);
                builder.setView(layout);
                builder.create().show();

            }
        });

    }
}