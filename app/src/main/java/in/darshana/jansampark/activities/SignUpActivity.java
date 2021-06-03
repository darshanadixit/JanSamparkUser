package in.darshana.jansampark.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import in.darshana.jansampark.R;

public class SignUpActivity extends Activity {
    private TextView mTxtSignup,mTxtAccount,mTxtLinkSignup;
    private EditText mEditUserName,mEditMobileNo,mEditEmail,mEditPassword;
    private EditText mEditConfirmPassword;
    private Button mBtnSignUp;
    private ImageView mImgBgSignup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        mTxtSignup = findViewById(R.id.txtviewSignup);
        mTxtAccount = findViewById(R.id.txtAccountSignup);
        mTxtLinkSignup = findViewById(R.id.txtLinkSignup);
        mEditUserName = findViewById(R.id.edt_username_signup);
        mEditMobileNo = findViewById(R.id.edt_mobileno_signup);
        mEditEmail = findViewById(R.id.edt_email_signup);
        mEditPassword= findViewById(R.id.edt_password);
        mEditConfirmPassword = findViewById(R.id.edt_confirm_password_signup);
        mBtnSignUp = findViewById(R.id.btn_signup);
        mImgBgSignup = findViewById(R.id.img_Signup_bg);
    }
}
