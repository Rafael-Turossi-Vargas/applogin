package br.ulbra.applogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cadastro extends AppCompatActivity {
    EditText edNome, edUser, edPas1, edPas2;
    Button btSalvar;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        db = new DBHelper(this);
        edNome = (EditText)findViewById(R.id.edNome);
        edUser = (EditText)findViewById(R.id.edLog);
        edPas1 = (EditText)findViewById(R.id.edSenha);
        edPas2 = (EditText)findViewById(R.id.edSenha2);
        btSalvar = (Button)findViewById(R.id.btCriar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUser.getText().toString();
                String pas1 = edPas1.getText().toString();
                String pas2 = edPas2.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(Cadastro.this,"Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (pas1.equals("") || pas2.equals("")){
                    Toast.makeText(Cadastro.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }else if(!pas1.equals(pas2)){
                    Toast.makeText(Cadastro.this, "As senhas não correspondem", Toast.LENGTH_SHORT).show();
                }else{
                    long res = db.criarUtilizador(userName,pas1);
                    if(res>0){
                        Toast.makeText(Cadastro.this, "Resgistro OK", Toast.LENGTH_SHORT).show();
                        setContentView(R.layout.activity_main);
                    }else{
                        Toast.makeText(Cadastro.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
