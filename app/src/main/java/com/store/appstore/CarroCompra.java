/*
Clase Global que mantiene a nival de aplicación el ArrayList del carro de compra, con el detalle
del nombre del producto, la cantidad seleccionada y el precio
Además maneja una variable con el Total a pagar
 */


package com.store.appstore;

import android.app.Application;
import java.util.ArrayList;

public class CarroCompra extends Application {

    private long iTotalCompra;
    private ArrayList<ItemCarro> alCarroCompra;

    public CarroCompra() {
        this.iTotalCompra = 0;
        this.alCarroCompra = new ArrayList<ItemCarro>();
    }

    public CarroCompra(long iTotalCompra, ArrayList<ItemCarro> alCarroCompra) {
        this.iTotalCompra = iTotalCompra;
        this.alCarroCompra = alCarroCompra;
    }

    public long getiTotalCompra() {
        return iTotalCompra;
    }

    public void setiTotalCompra(long iTotalCompra) {
        this.iTotalCompra = iTotalCompra;
    }

    public ArrayList<ItemCarro> getAlCarroCompra() {
        return alCarroCompra;
    }

    public void setAlCarroCompra(ArrayList<ItemCarro> alCarroCompra) {
        this.alCarroCompra = alCarroCompra;
    }

    public boolean addItemCarro(ItemCarro itemCarro) {
        return (this.alCarroCompra.add(itemCarro));
    }
}
