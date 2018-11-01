/*
Clase que maneja el catalogo de Pizzas
Desde aqui se carga la lista de productos desayunos que estan disponibles
Una vez seleccionado un Item se llama a la clase ProductDetail para mostrar la información del precio
la imagen del producto y desde ahi poder cargarlo al carro de compra
 */
package com.store.appstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HomeDesayuno extends AppCompatActivity {

    int[] IMAGES = {R.drawable.desayunogold, R.drawable.granja, R.drawable.mediterraneo, R.drawable.sano, R.drawable.pasteles};

    String[] NAMES = {"Desayuno Gold", "Desayuno de la Granja", "Desayuno Mediterraneo", "Desayuno Sano", "Surtido de Pasteles"};
    long[] PRICES = {20000, 12000, 30000, 9500, 15000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_desayuno);

        ListView listaDesayuno = (ListView) findViewById(R.id.ListaDesayuno);
        CustomAdapter customAdapter = new HomeDesayuno.CustomAdapter();
        listaDesayuno.setAdapter(customAdapter);

        listaDesayuno.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeDesayuno.this, ProductDetail.class);
                intent.putExtra("ProductImage", IMAGES[position]);
                intent.putExtra("ProductName", NAMES[position]);
                intent.putExtra("ProductPrice", PRICES[position] );
                startActivity(intent);
            }
        });

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return NAMES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_item,null);

            ImageView image_icon = (ImageView)convertView.findViewById(R.id.image_icon);
            TextView textView_name = (TextView)convertView.findViewById(R.id.textView_name);

            image_icon.setImageResource(R.drawable.desayunos);
            textView_name.setText(NAMES[position]);

            return convertView;
        }
    }
}
