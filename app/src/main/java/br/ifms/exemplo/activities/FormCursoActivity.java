package br.ifms.exemplo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import br.ifms.exemplo.R;
import br.ifms.exemplo.dao.CursoDAO;
import br.ifms.exemplo.model.Curso;

public class FormCursoActivity extends AppCompatActivity {

    private Button botaoSalvar;
    private EditText campoNome;
    private EditText campoDescricao;
    private CursoDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Novo Curso");
        setContentView(R.layout.activity_form_curso);
        inicializarDAO();
        inicializarReferencias();
        inicializarAcoes();
    }

    private void inicializarDAO(){
        dao = new CursoDAO(getBaseContext());
    }

    private void inicializarReferencias(){
        botaoSalvar = findViewById(R.id.activity_form_curso_botao_salvar);
        campoNome = findViewById(R.id.activity_form_curso_campo_nome);
        campoDescricao = findViewById(R.id.activity_form_curso_campo_descricao);
    }

    private void inicializarAcoes(){
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Curso curso = new Curso();
                curso.setNome(campoNome.getText().toString());
                curso.setDescricao(campoDescricao.getText().toString());
                dao.addNovoCurso(curso);
                Toast toast = Toast.makeText(FormCursoActivity.this,"Salvo!",Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        });
    }
}
