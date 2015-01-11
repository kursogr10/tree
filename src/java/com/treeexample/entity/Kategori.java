package com.treeexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kategori",schema="public")
public class Kategori  implements java.io.Serializable {

     private int kategoriId;
     private String kategoriAdi;
     private int katUstId;

    public Kategori() {
    }

    public Kategori(int kategoriId, String kategoriAdi, int katUstId) {
       this.kategoriId = kategoriId;
       this.kategoriAdi = kategoriAdi;
       this.katUstId = katUstId;
    }
   
    @Id     
    @Column(name="kategoriId", unique=true, nullable=false, precision=131089, scale=0)
    public int getKategoriId() {
        return this.kategoriId;
    }
    
    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }
    
    @Column(name="kategoriAdi", nullable=false, length=200)
    public String getKategoriAdi() {
        return this.kategoriAdi;
    }
    
    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }
    
    @Column(name="katUstId", nullable=false, precision=131089, scale=0)
    public int getKatUstId() {
        return this.katUstId;
    }
    
    public void setKatUstId(int katUstId) {
        this.katUstId = katUstId;
    }
}


