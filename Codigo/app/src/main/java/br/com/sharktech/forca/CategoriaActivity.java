package br.com.sharktech.forca;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategoriaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView lvListaCayegorias;
    private ArrayAdapter<String> aaCategorias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        lvListaCayegorias = (ListView) findViewById(R.id.lvListaCategorias);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        aaCategorias = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
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
        //lvListaCayegorias.add
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) throws RuntimeException{
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_categoria) {

        } else if (id == R.id.nav_ranking) {

        } else if (id == R.id.nav_desafio) {

        } else if (id == R.id.nav_meuperfil) {

        } else if (id == R.id.nav_amigos) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
