package com.rafamompo.maventest;

import java.util.Objects;

public class Pokemon {

    private final String nombre;
    private int vida;
    private int danyo;
    private final String tipo;

    public Pokemon(String nombre, int vida, int danyo, String tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.danyo = danyo;
        this.tipo = tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getDanyo() {
        return danyo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDanyo(int danyo) {
        this.danyo = danyo;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pokemon pokemon)) return false;
        return vida == pokemon.vida && danyo == pokemon.danyo && Objects.equals(nombre, pokemon.nombre) && Objects.equals(tipo, pokemon.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, vida, danyo, tipo);
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", danyo=" + danyo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
   