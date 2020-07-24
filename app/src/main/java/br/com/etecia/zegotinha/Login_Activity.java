package br.com.etecia.zegotinha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    String aux = "";
    Integer ano = 0, idade = 0;
    Button btnEntrar;
    ImageButton btnSair;
    EditText editCEP, editData;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        btnSair = findViewById(R.id.btnSair);
        btnEntrar = findViewById(R.id.btnEntrar);

        editCEP = findViewById(R.id.editCEP);
        editData = findViewById(R.id.editData);


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //convertendo oq será escrito no EditText em número INT
                //aux = editData.getText().toString();
                //ano = Integer.parseInt(aux);
                //idade = saberIdade(ano);
                //ou
                ano = Integer.parseInt(editData.getText().toString());
                idade = saberIdade(ano);

                if(ano >=1900) {
                    if (idade >= 60) {
                        Toast.makeText(getApplicationContext(), "Voce é uma pessoa que está na Idade de Risco", Toast.LENGTH_SHORT).show();
                        limparCampos();
                        //startActivity(new Intent(getApplicationContext(),MenuPrincipal.class));
                        //finish();
                    } else if (idade >= 0) {
                        limparCampos();
                        startActivity(new Intent(getApplicationContext(), Onde_Vacinar_Activity.class));
                        //finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Ano inválido (max:2020)", Toast.LENGTH_SHORT).show();
                        limparCampos();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Ano inválido (min:1900)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public int saberIdade(int ano) {
        return 2020 - ano;
    }

    //Limpando Campos e colocando o foco em EDIT editCEP
    public void limparCampos() {
        editCEP.setText("");
        editData.setText("");
        editCEP.requestFocus();
    }
}
