package droidmentor.tabwithviewpager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import at.markushi.ui.CircleButton;
import droidmentor.tabwithviewpager.Model.User;
import droidmentor.tabwithviewpager.ViewPager.HomeActivity;

public class LoginActivity extends AppCompatActivity {


   private EditText edit_registernum;
   private EditText edit_password;
    private Button btn_signin;
    private at.markushi.ui.CircleButton btn_fb;
    private at.markushi.ui.CircleButton btn_site;
    private CheckBox checkBox;
    private String registernum;
    private String password;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        initContent();
        loginAction();

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            edit_registernum.setText(loginPreferences.getString("registernum", ""));
            edit_password.setText(loginPreferences.getString("password", ""));
            checkBox.setChecked(true);
        }


    }

    private void initContent() {
        edit_password=(EditText)findViewById(R.id.password);
        edit_registernum=(EditText)findViewById(R.id.register_number);
        btn_signin = (Button) findViewById(R.id.signinbtn);
        btn_fb = (CircleButton) findViewById(R.id.fblogo);
        btn_site=(CircleButton) findViewById(R.id.planet);
        checkBox = (CheckBox)findViewById(R.id.rememberme);


    }

    private void loginAction(){
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registernum = edit_registernum.getText().toString();
                password = edit_password.getText().toString();

                if(registernum.equals("")){
                    edit_registernum.setError("can't be blank");
                }
                else if(password.equals("")){
                    edit_password.setError("can't be blank");
                }
                else{
                    String url = "https://fsm-app-f1956.firebaseio.com/user.json";
                    final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                    pd.setMessage("Loading...");
                    pd.show();

                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                        @Override
                        public void onResponse(String s) {
                            if(s.equals("null")){
                                Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                            }
                            else{
                                try {
                                    JSONObject obj = new JSONObject(s);

                                    if(!obj.has(registernum)){
                                        Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                                    }
                                    else if(obj.getJSONObject(registernum).getString("password").equals(password)){

                                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                                    }
                                    else {
                                        Toast.makeText(LoginActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            pd.dismiss();
                        }
                    },new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            System.out.println("" + volleyError);
                            pd.dismiss();
                        }
                    });

                    RequestQueue rQueue = Volley.newRequestQueue(LoginActivity.this);
                    rQueue.add(request);
                }
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edit_registernum.getWindowToken(), 0);

                registernum = edit_registernum.getText().toString();
                password = edit_password.getText().toString();

                if (checkBox.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("registernum", registernum);
                    loginPrefsEditor.putString("password", password);
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }


            }
        });
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        btn_site.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animRotate);
                String url = "http://www.fsm.rnu.tn";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }});

        btn_fb.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                arg0.startAnimation(animRotate);
                String url = "http://fr-fr.facebook.com/Facult%C3%A9-des-Sciences-de-Monastir-113216455514646";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }});
            }


}
