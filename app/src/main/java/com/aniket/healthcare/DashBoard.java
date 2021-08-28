package com.aniket.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashBoard extends AppCompatActivity {

    //This changes is available at update_1 branch

    Button signout;
    FirebaseAuth mFirebaseAuth;
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        signout = findViewById(R.id.cirLogOutButton);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken("278944410326-rfro3ljl2b2ff2iodhqrgv5khqd4gqk6.apps.googleusercontent.com")
                        .requestEmail()
                        .build();
                GoogleSignInClient googleSignInClient= GoogleSignIn.getClient(DashBoard.this,gso);
                googleSignInClient.signOut();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(DashBoard.this,LoginActivity.class));
                finish();
            }
        });
    }
}