package br.com.sharktech.forca;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AmigosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView lvwAmigos;
    private ArrayAdapter<String> aaAmigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        lvwAmigos = (ListView) findViewById(R.id.lvwAmigos);

        aaAmigos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lvwAmigos.setAdapter(aaAmigos);

        aaAmigos.add("Anailson");
        aaAmigos.add("Rafael");
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
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_ranking) {
            Intent intent = new Intent();
            intent.setClass(AmigosActivity.this, RankingActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_desafio) {
            finish();

            Intent intent = new Intent();
            intent.setClass(AmigosActivity.this, DesafioActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_meuperfil) {
            finish();

            Intent intent = new Intent();
            intent.setClass(AmigosActivity.this, MeuPerfilActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_categoria) {
            finish();

            Intent intent = new Intent();
            intent.setClass(AmigosActivity.this, CategoriaActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
