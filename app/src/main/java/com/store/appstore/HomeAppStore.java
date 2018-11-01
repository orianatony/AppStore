/*
Clase Principal:  Desde aqui se carga y muestra el menú inicial de la App con las opciones
para seleccionar Cafe, Pizzas y hacer el Pedido

 */

package com.store.appstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.content.Intent;

public class HomeAppStore extends AppCompatActivity {

    int[] IMAGES = {R.drawable.cafe, R.drawable.desayunos, R.drawable.cocker};

    int[] NAMES = { R.string.drinkmenu, R.string.eatmenu, R.string.paymenu };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app_store);

        CarroCompra carroCompra = (CarroCompra) getApplicationContext();
        carroCompra = new CarroCompra();


        ListView listaHome=(ListView)findViewById(R.id.listaHome);
        CustomAdapter customAdapter = new CustomAdapter();
        listaHome.setAdapter(customAdapter);

        listaHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(HomeAppStore.this, HomeCafe.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(HomeAppStore.this, HomeDesayuno.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(HomeAppStore.this, HomeSale.class);
                    startActivity(intent);
                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
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

            image_icon.setImageResource(IMAGES[position]);
            textView_name.setText(NAMES[position]);

            return convertView;
        }
    }
}
