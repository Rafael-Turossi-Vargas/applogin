package br.ulbra.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {
    EditText edNome, edUser, edPas1, edPas2;
    Button btSalvar;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        db = new DBHelper(this);
        edNome = (EditText)findViewById(R.id.edit_nome);
        edUser = (EditText)findViewById(R.id.edit_login);
        edPas1 = (EditText)findViewById(R.id.edit_senha);
        edPas2 = (EditText)findViewById(R.id.edit_repeat_senha);
        btSalvar = (Button)findViewById(R.id.bt_salvar);

        /*
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUser.getText().toString();
                String pas1 = edPas1.getText().toString();
                String pas2 = edPas2.getText().toString();
                if (userName.equals("")) {

                    Toast.makeText(RegistrarActivity.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }
                else if (pas1.equals("") || pas2.equals("")){
                    Toast.makeText(RegistrarActivity.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }
                else if(!pas1.equals(pas2)){
                    Toast.makeText(RegistrarActivity.this, "As senhas não correspondem ao login do usuário", Toast.LENGTH_SHORT).show();
                }
                else{
                    long res = db.criarUtilizador(userName,pas1);
                    if(res>0){
//nesta parte você poderá chamar a tela principal do sistema

                        Toast.makeText(RegistrarActivity.this,
                                "Resgistro OK", Toast.LENGTH_SHORT).show();
                        setContentView(R.layout.activity_main);
                    }
                    else{
                        Toast.makeText(RegistrarActivity.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });*/
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegistrarActivity.this, "Clicou", Toast.LENGTH_SHORT).show();
            }
        });
    }
}