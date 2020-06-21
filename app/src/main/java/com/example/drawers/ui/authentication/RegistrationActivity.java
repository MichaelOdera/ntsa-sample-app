package com.example.drawers.ui.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.drawers.R;
import com.example.drawers.ui.LauncherActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{


    @BindView(R.id.btn_generate_otp) Button mButtonGenerateOtp;
    @BindView(R.id.btn_sign_in) Button mButtonSignIn;

    @BindView(R.id.phoneNumberEditText) EditText mPhoneNumberEditText;
    @BindView(R.id.otpEditText) EditText mOtpEditText;


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    private FirebaseAuth mAuth;
    private String mPhoneNumber;

    private String mOtp;
    private String mVerificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        mButtonGenerateOtp.setOnClickListener(this);
        mButtonSignIn.setOnClickListener(this);

        StartFirebaseLogin();



    }

    private void StartFirebaseLogin() {
        mAuth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(RegistrationActivity.this,"verification completed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(RegistrationActivity.this,"verification failed",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                mVerificationCode = s;
                Toast.makeText(RegistrationActivity.this,"Code"+s+" sent to"+ mPhoneNumber,Toast.LENGTH_SHORT).show();
            }
        };
    }


    @Override
    public void onClick(View view) {
        if (view == mButtonGenerateOtp){
            mPhoneNumber = mPhoneNumberEditText.getText().toString();
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    "+254"+mPhoneNumber,
                    60,
                    TimeUnit.SECONDS,
                    RegistrationActivity.this,
                    mCallback
            );

            StartFirebaseLogin();

        }

        if (view == mButtonSignIn){
            mOtp = mOtpEditText.getText().toString();
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationCode, mOtp);
            SignInWithPhone(credential);
        }

    }

    private void SignInWithPhone(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this, "Successful Login", Toast.LENGTH_SHORT).show();
                    Intent launchIntent = new Intent(RegistrationActivity.this, LauncherActivity.class);
                    launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    RegistrationActivity.this.startActivity(launchIntent);
                    RegistrationActivity.this.finish();
                }else{
                    Toast.makeText(RegistrationActivity.this, "Wrong OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
