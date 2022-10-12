package com.azkazhanif.visualtalk.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.azkazhanif.visualtalk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText signName, signUsername, signEmail, signPassword, signVerifyPassword;
    Button signInButton;
    String name, username, email, password, verifyPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();


        signName = findViewById(R.id.signInFullName);
        signUsername = findViewById(R.id.signInUsername);
        signEmail = findViewById(R.id.signInEmail);
        signPassword = findViewById(R.id.signInPassword);
        signVerifyPassword = findViewById(R.id.signInVerifyPassword);
        signInButton = findViewById(R.id.buttonSignIn);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRegister();
            }
        });
    }

    private void checkRegister() {
        name = signName.getText().toString();
        username = signUsername.getText().toString();
        email = signEmail.getText().toString();
        password = signPassword.getText().toString();
        verifyPassword = signVerifyPassword.getText().toString();

        if(name.isEmpty()||username.isEmpty()||email.isEmpty()||password.isEmpty()) {
            alertFail("All field is require");
        } else if (!password.equals(verifyPassword)) {
            alertFail("Password is'nt common. Please check again!");
        } else {
            mAuth.createUserWithEmailAndPassword(email,verifyPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(SignUpActivity.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
                                sendRegister();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUpActivity.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void sendRegister() {
        alertSuccess("Sign Up are successfull");
    }

    private void alertSuccess(String s) {
        new AlertDialog.Builder(this)
                .setTitle("Success")
                .setIcon(R.drawable.ic_baseline_success_24)
                .setMessage(s)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                })
                .show();
    }

    private void alertFail(String s) {
        new AlertDialog.Builder(this)
                .setTitle("Failed")
                .setIcon(R.drawable.ic_baseline_warning_24)
                .setMessage(s)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}