package br.com.sharktech.forca.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.sharktech.forca.R;
import br.com.sharktech.forca.entidades.Usuario;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;

public class AmigosFragment extends Fragment {
    private ListView lvwAmigos;
    private ArrayAdapter<String> aaAmigos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amigos, container, false);

        lvwAmigos = (ListView) view.findViewById(R.id.lvwAmigos);

        List<Usuario> listaAmigos = TratamentoDeBancoDeDados.buscarAmigos(TratamentoDeBancoDeDados.buscarUsuario().getId());
        aaAmigos = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1);

        for(int i = 0; i < listaAmigos.size(); i++){
            aaAmigos.add(listaAmigos.get(i).getNome());
        }

        aaAmigos.add("Anailson");
        aaAmigos.add("Rafael");
        lvwAmigos.setAdapter(aaAmigos);

        return view;
    }
}
