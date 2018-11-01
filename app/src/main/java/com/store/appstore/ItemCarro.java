/*
Esta clase permite mantener cada Item del Carro de Compra
El ArrayList global es del tipo ItemCarro
 */

package com.store.appstore;

public class ItemCarro {
    private String nombreItem;
    private long precioItem;
    private int cantidadItem;

    public ItemCarro() {
        this.nombreItem = "";
        this.precioItem = 0;
        this.cantidadItem = 0;
    }

    public ItemCarro(String nombreItem, long precioItem, int cantidadItem) {
        this.nombreItem = nombreItem;
        this.precioItem = precioItem;
        this.cantidadItem = cantidadItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public long getPrecioItem() {
        return precioItem;
    }

    public void setPrecioItem(long precioItem) {
        this.precioItem = precioItem;
    }

    public int getCantidadItem() {
        return cantidadItem;
    }

    public void setCantidadItem(int cantidadItem) {
        this.cantidadItem = cantidadItem;
    }
}
