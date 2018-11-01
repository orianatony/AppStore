/*
Clase que maneja la tienda:  Cada item seleccionado se carga en un ArrayList que se maneja de forma
Global.  Desde aquí se carga la lista de items seleccionados y se puede realizar la compra al
dar click al botón Pagar
 */

package com.store.appstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeSale extends AppCompatActivity {

    int sizeCarroCompra;
    ArrayList<ItemCarro> alCarroCompra = new ArrayList<ItemCarro>();
    CarroCompra carroCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_sale);

        carroCompra = (CarroCompra) getApplicationContext();

        TextView prodSumaTotal = (TextView) findViewById(R.id.productSumaTotal);
        Button btnPay = (Button) findViewById(R.id.btnPay);

        sizeCarroCompra = carroCompra.getAlCarroCompra().size();
        alCarroCompra = (ArrayList<ItemCarro>) carroCompra.getAlCarroCompra();

        ListView listaCarroCompra = (ListView) findViewById(R.id.listaCarroCompra);
        CarroAdapter carroAdapter = new CarroAdapter();
        listaCarroCompra.setAdapter(carroAdapter);

        prodSumaTotal.setText(String.format("$ %,d",carroCompra.getiTotalCompra()));


        if (sizeCarroCompra == 0)
            btnPay.setEnabled(false);
        else
            btnPay.setEnabled(true);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                carroCompra.setiTotalCompra(0);
                carroCompra.setAlCarroCompra(new ArrayList<ItemCarro>());
                Toast.makeText(getBaseContext(), R.string.orderSuccess , Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    class CarroAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return sizeCarroCompra;
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.carro_item,null);

            TextView txtCantidad = (TextView)convertView.findViewById(R.id.txtCantidad);
            TextView txtProducto = (TextView)convertView.findViewById(R.id.txtProducto);
            TextView txtTotal = (TextView)convertView.findViewById(R.id.txtTotal);
            ImageView btnDelete = (ImageView) convertView.findViewById(R.id.btnDelete);

            txtCantidad.setText(String.valueOf(alCarroCompra.get(position).getCantidadItem()));
            txtProducto.setText(alCarroCompra.get(position).getNombreItem());
            txtTotal.setText(String.format("$ %,d", alCarroCompra.get(position).getCantidadItem() * alCarroCompra.get(position).getPrecioItem()));

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    carroCompra.setiTotalCompra(carroCompra.getiTotalCompra() - (alCarroCompra.get(position).getPrecioItem() * alCarroCompra.get(position).getCantidadItem()));
                    alCarroCompra.remove(position);
                    carroCompra.setAlCarroCompra(alCarroCompra);
                    sizeCarroCompra--;
                    Toast.makeText(getBaseContext(), R.string.itemDelete , Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(getIntent());
                }
            });

            return convertView;
        }
    }
}
