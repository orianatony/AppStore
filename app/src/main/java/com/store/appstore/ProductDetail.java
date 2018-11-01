/*
Esta clase permite mostrar la informacion de cada Producto que se ha seleccionado, mostrando
la imagen del producto, el precio y además dando la opción de cargar el producto al carro de compra

 */

package com.store.appstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class ProductDetail extends AppCompatActivity {

    int iCantProd = 1;
    long iProductPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        final CarroCompra carroCompra = (CarroCompra) getApplicationContext();

        ImageView imageProd = (ImageView) findViewById(R.id.productImage);
        ImageView imageMas = (ImageView) findViewById(R.id.btnMas);
        ImageView imageMenos = (ImageView) findViewById(R.id.btnMenos);

        final TextView prodName = (TextView) findViewById(R.id.productName);
        final TextView prodPrice = (TextView) findViewById(R.id.productPrice);
        final TextView prodCant = (TextView) findViewById(R.id.productCant);
        final TextView totalPrice = (TextView) findViewById(R.id.totalPrice);

        Button btnAdd = (Button) findViewById(R.id.addToBuy);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        prodCant.setText(String.valueOf(iCantProd));
        toolbar.setTitle("Total Carro : " + String.format("$ %,d", carroCompra.getiTotalCompra()) );

        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            imageProd.setImageResource(bundle.getInt("ProductImage"));
            prodName.setText(bundle.getString("ProductName"));
            prodPrice.setText(String.format("$ %,d", bundle.getLong("ProductPrice")));
            iProductPrice = bundle.getLong("ProductPrice");
        }

        totalPrice.setText(String.format("$ %,d", iProductPrice * iCantProd));

        imageMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iCantProd < 10) {
                    iCantProd++;
                    prodCant.setText(String.valueOf(iCantProd));
                    totalPrice.setText(String.format("$ %,d", iProductPrice * iCantProd));
                }
            }
        });

        imageMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iCantProd > 1) {
                    iCantProd--;
                    prodCant.setText(String.valueOf(iCantProd));
                    totalPrice.setText(String.format("$ %,d", iProductPrice * iCantProd));
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemCarro itemCarro = new ItemCarro();

                carroCompra.setiTotalCompra(carroCompra.getiTotalCompra() + (iProductPrice * iCantProd));
                toolbar.setTitle("Total Carro : " + String.format("$ %,d", carroCompra.getiTotalCompra()) );

                itemCarro.setNombreItem(prodName.getText().toString());
                itemCarro.setCantidadItem(Integer.parseInt(prodCant.getText().toString()));
                itemCarro.setPrecioItem(iProductPrice);

                carroCompra.addItemCarro(itemCarro);

            }
        });

    }
}
