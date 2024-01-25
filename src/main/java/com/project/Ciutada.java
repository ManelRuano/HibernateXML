package com.project;

import javax.persistence.*;

@Entity
@Table(name = "Ciutada")
public class Ciutada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "ciutatId")
    private long ciutatId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "cognom")
    private String cognom;

    @Column(name = "edat")
    private int edat;


    public Ciutada() {
    }

    public Ciutada(long ciutatId, String nom, String cognom, int edat) {
        this.ciutatId = ciutatId;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCiutatId() {
        return ciutatId;
    }

    public void setCiutatId(long ciutatId) {
        this.ciutatId = ciutatId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }


    @Override
    public String toString() {
        return "Ciutada{" +
                "id=" + id +
                ", ciutatId=" + ciutatId +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", edat=" + edat +
                '}';
    }
}
