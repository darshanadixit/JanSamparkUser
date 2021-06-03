package in.darshana.jansampark.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import in.darshana.jansampark.R;


public class LoginActivity extends Activity {
    private EditText mEdtitUsername,mEditPassword;
    private Button mBtnLogin;
    private TextView mTxtLogin,mTxtUsername,mTxtPassword,mTxtForgotPassword,mTxtNewUser;
    private TextView mTxtSignUp,mTxtSigninwith;
    private ImageView mImgFacebook,mImgTwitter,mImgOrangeBg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mEdtitUsername = findViewById(R.id.edt_username);
        mEditPassword = findViewById(R.id.edt_password);
        mImgFacebook = findViewById(R.id.imgFacebook);
        mImgTwitter = findViewById(R.id.imgTwitter);
        mImgOrangeBg = findViewById(R.id.imgorangebg);
        mBtnLogin = findViewById(R.id.btnLogin);
        mTxtLogin = findViewById(R.id.txtLogin);
        //mTxtUsername = findViewById(R.id.txtUsername);
        //mTxtPassword = findViewById(R.id.txtPassword);
        mTxtForgotPassword = findViewById(R.id.txtForgotPassword);
        mTxtNewUser= findViewById(R.id.txtAccount);
        mTxtSignUp = findViewById(R.id.txtLinkSignup);
    }
}
