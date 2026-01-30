package com.rafamompo.maventest;

import java.util.ArrayList;
import java.util.Objects;

public class Entrenador {


    private final String nombre;
    private final String ciudad;
    private final ArrayList<Pokemon> pokemons;

    public Entrenador(String nombre, String ciudad, ArrayList<Pokemon> pokedex) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pokemons = pokedex;
    }

    public void crearPokemon(String nombre, int vida, int danyo, String tipo) {
        pokemons.add(new Pokemon(nombre, vida, danyo, tipo));
    }

    public void anyadirPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entrenador that)) return false;
        return Objects.equals(nombre, that.nombre) && Objects.equals(ciudad, that.ciudad) && Objects.equals(pokemons, that.pokemons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ciudad, pokemons);
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pokedex=" + pokemons +
                '}';
    }
}



