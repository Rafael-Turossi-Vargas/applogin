package br.ulbra.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.Buffer;

public class Login extends AppCompatActivity {
    EditText edLogin, edPass;
    Button btLogin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new DBHelper(this);
        edLogin = (EditText)findViewById(R.id.edLog);
        edPass = (EditText)findViewById(R.id.edSenha);
        btLogin = (Button)findViewById(R.id.btlogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edLogin.getText().toString();
                String password=edPass.getText().toString();
                if(username.equals("")){
                    Toast.makeText(Login.this,"Usuario não inserido, tente novamente",Toast.LENGTH_SHORT).show();
                }else if(password.equals("")){
                    Toast.makeText(Login.this,"Senha não inserida, tente novamente",Toast.LENGTH_SHORT).show();
                }else{
                    String res = db.validarLogin(username,password);
                    if(res.equals("OK")){
                        Toast.makeText(Login.this,"Login OK !!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Login.this,"Login ou Senha errado(s)!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
