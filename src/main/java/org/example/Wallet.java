package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    String owner;
    ArrayList<String> listKartu;
    ArrayList<Integer> listKoin;
    ArrayList<Integer> listUang;

    public Wallet(String owner) {
        this.owner = owner;
        listKartu = new ArrayList<>();
        listKoin = new ArrayList<>();
        listUang = new ArrayList<>();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void tambahKartu(String namaKartu) {
        this.listKartu.add(namaKartu);
    }

    public String ambilKartu(String namaKartu) {
        boolean isDeleted = this.listKartu.remove(namaKartu);
        if (isDeleted) {
            return namaKartu;
        }
        return null;
    }

    public void tambahUang(int jumlahUang) {
        if (jumlahUang < 0) {
            throw new Error("jumlah uang tidak boleh minus");
        }
        if (jumlahUang > 1000) {
            listUang.add(jumlahUang);
        }else {
            listKoin.add(jumlahUang);
        }
    }

    public int ambilUang(int jumlahUang) {
        boolean isUangLembaranTaken = this.listUang.remove(Integer.valueOf(jumlahUang));
        if (isUangLembaranTaken) {
            return jumlahUang;
        }
        boolean isUangKoinTaken = this.listKoin.remove(Integer.valueOf(jumlahUang));
        if (isUangKoinTaken) {
            return jumlahUang;
        }
        return 0;
    }

    public int tampilkanUang() {
        int totalUang = 0;
        for (Integer uang : listKoin) {
            totalUang += uang;
        }
        for (Integer uang : listUang) {
            totalUang += uang;
        }
        return totalUang;
    }

    public String getOwner() {
        return this.owner;
    }

    public List<String> getListKartu() {
        return new ArrayList<>(this.listKartu);
    }

    public List<Integer> getListUangLembaran() {
        return new ArrayList<>(this.listUang);
    }

    public List<Integer> getListUangKoin() {
        return new ArrayList<>(this.listKoin);
    }
}
