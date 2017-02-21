package com.example.renosyahputra.simplelistview.myCustomList;


public class ItemList {
    public String id;
    public String nama;
    public String keterangan;

    public ItemList() {
        super();
    }

    public ItemList(String id,String nama,String keterangan) {
        super();
        this.id = id;
        this.nama = nama;
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
