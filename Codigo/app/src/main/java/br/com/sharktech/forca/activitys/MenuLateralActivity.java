package br.com.sharktech.forca.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.sharktech.forca.R;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;

public class MenuLateralActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        exibirActivity(1);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        int menu = 0;

        if (id == R.id.nav_jogar) {

            menu = 0;

        } else if (id == R.id.nav_categoria) {

            menu = 1;

        } else if (id == R.id.nav_ranking) {

            menu = 2;

        } else if (id == R.id.nav_desafio) {

            menu = 3;

        } else if (id == R.id.nav_amigos) {
            menu = 4;

        } else if (id == R.id.nav_meuperfil) {

            menu = 5;
        } else if (id == R.id.nav_sobre) {

            menu = 6;
        }
        exibirActivity(menu);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

     private void exibirActivity(int menu){


         Fragment fragment = null;
         String title = "";

         switch (menu){
             case 0:
                 title = getString(R.string.menu_jogar);
                 Intent intent = new Intent(this, JogoActivity.class);

                 //Provavelmente isso vai ser refatorado
                 TratamentoDeBancoDeDados.buscaPalarasAleatoriasNaoRespondida();
                 Bundle bundle = new Bundle();
                 bundle.putInt("pontuacao",0);
                 bundle.putInt("desafios",5);
                 intent.putExtras(bundle);
                 TratamentoDeBancoDeDados.inserePalavrasDoServidor();

                 startActivityForResult(intent, 1);
             break;
             case 1:
                 fragment = new CategoriaFragment();
                 title = getString(R.string.menu_categoria);
             break;
             case 2:
                 fragment = new RankingFragment();
                 title = getString(R.string.menu_ranking);
             break;
             case 3:
                 fragment = new DesafioFragment();
                 title = getString(R.string.menu_desafios);
             break;
             case 4:
                 fragment = new AmigosFragment();
                 title = getString(R.string.menu_amigos);
             break;
             case 5:
                 fragment = new MeuPerfilFragment();
                 title = getString(R.string.menu_meu_perfil);
             break;
             case 6:
                 title = getString(R.string.menu_sobre);
             break;
         }

         getSupportActionBar().setTitle(title);
         if(fragment != null) {
             FragmentManager fragmentManager = getSupportFragmentManager();
             fragmentManager.beginTransaction().replace(R.id.frame, fragment).commit();
         }
     }
}
