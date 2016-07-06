package br.com.sharktech.forca.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.sharktech.forca.R;

public class CategoriaFragment extends Fragment
        /*implements NavigationView.OnNavigationItemSelectedListener */{
    private ListView lvListaCayegorias;
    private ArrayAdapter<String> aaCategorias;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categoria, container, false);
        ListView lvListaCayegorias = (ListView) view.findViewById(R.id.lvListaCategorias);

        aaCategorias = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1);
        lvListaCayegorias.setAdapter(aaCategorias);

        aaCategorias.add("Alimentos");
        aaCategorias.add("Animais");
        aaCategorias.add("Artes");
        aaCategorias.add("Ciência");
        aaCategorias.add("Diversos");
        aaCategorias.add("Entretenimento");
        aaCategorias.add("Esportes");
        aaCategorias.add("Geografia");
        aaCategorias.add("História");
        return view;
    }
}
