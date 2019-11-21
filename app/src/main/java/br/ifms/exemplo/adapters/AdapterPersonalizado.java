package br.ifms.exemplo.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.ifms.exemplo.R;
import br.ifms.exemplo.model.Curso;

public class AdapterPersonalizado extends BaseAdapter {

    private List<Curso> cursos;
    private AppCompatActivity activity;

    public void setCursos(List<Curso> cursos){
        this.cursos = cursos;
    }

    public AdapterPersonalizado(AppCompatActivity activity){
        this.cursos = new ArrayList<Curso>();
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return cursos.size();
    }

    @Override
    public Object getItem(int position) {
        return cursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        Curso  curso = cursos.get(position);
        return curso.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity
                .getLayoutInflater()
                .inflate(R.layout.activity_list_cursos_list_item, parent,false);

        TextView campoNome = view.findViewById(R.id.acitivity_list_cursos_list_item_campo_nome);
        TextView campoDescricao = view.findViewById(R.id.acitivity_list_cursos_list_item_campo_descricao);
        ImageView campoImagem = view.findViewById(R.id.acitivity_list_cursos_list_item_imagem);

        Curso curso = cursos.get(position);

        campoNome.setText("ID: "+curso.getId()+" "+curso.getNome());
        campoDescricao.setText(curso.getDescricao());
        campoImagem.setImageResource(R.drawable.ic_launcher_background);

        return view;
    }
}
