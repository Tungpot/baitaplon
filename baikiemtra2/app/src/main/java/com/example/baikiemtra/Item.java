package com.example.baikiemtra;

import java.io.Serializable;

public class Item implements Serializable {
    String tentu,phanloai,nghia;

    public Item(String tentu, String phanloai, String nghia) {
        this.tentu = tentu;
        this.phanloai = phanloai;
        this.nghia = nghia;
    }

    public String getTentu() {
        return tentu;
    }

    public void setTentu(String tentu) {
        this.tentu = tentu;
    }

    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    public String getNghia() {
        return nghia;
    }

    public void setNghia(String nghia) {
        this.nghia = nghia;
    }
}
