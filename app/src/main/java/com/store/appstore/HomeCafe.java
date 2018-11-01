/*
Clase que maneja el catalogo de Café
Desde aqui se carga la lista de productos de Café que estan disponibles
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

public class HomeCafe extends AppCompatActivity {

    int[] IMAGES = {R.drawable.trigo, R.drawable.capuchino, R.drawable.arabe, R.drawable.mocachino, R.drawable.cafehelado};

    String[] NAMES = {"Café de Trigo", "Capucchino", "Café Árabe", "Mockachino", "Café Helado"};
    //String[] PRICES = {"$ 1.500", "$ 1.800", "$ 2.500", "$ 2.100", "$ 3.000" };
    long[] PRICES = {1500, 1800, 2500, 2100, 3000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cafe);

        ListView listaDrink = (ListView) findViewById(R.id.listaCoffe);
        CustomAdapter customAdapter = new CustomAdapter();
        listaDrink.setAdapter(customAdapter);

        listaDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeCafe.this, ProductDetail.class);
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

            image_icon.setImageResource(R.drawable.cafe);
            textView_name.setText(NAMES[position]);

            return convertView;
        }
    }
}
