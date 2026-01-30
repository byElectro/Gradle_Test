package com.rafamompo.maventest;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Esto es para que el objeto pase a estar en idioma de España.
    private static final Faker faker = new Faker(new Locale.Builder().setLanguage("es").build());
    static Entrenador[] entrenadores = new Entrenador[10];


    public static void main(String[] args) {

        //Añado la dependencia en build.gradle.kts.     implementation 'net.datafaker:datafaker:2.5.3'


        // Crear 10 entrenadores con Pokémons aleatorios
        entrenadores = crearEntrenadores(10);

        // Mostrar los entrenadores usando
        for (int i = 0; i < entrenadores.length; i++) {
            Entrenador e = entrenadores[i];
            System.out.println("Entrenador #" + (i+1));
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Ciudad: " + e.getCiudad());
            System.out.println("Pokémons:");

            ArrayList<Pokemon> pokedex = e.getPokemons();
            for (int j = 0; j < pokedex.size(); j++) {
                Pokemon p = pokedex.get(j);
                System.out.println("  - " + p.getNombre() + " (Vida: " + p.getVida() + ", Danyo: " + p.getDanyo() + ", Tipo: " + p.getTipo() + ")");
            }

            System.out.println("-----------");
        }


    }

    private static Entrenador[] crearEntrenadores(int contador) {

        for (int i = 0; i < contador; i++) {
            ArrayList<Pokemon> pokedex = new ArrayList<>();

            // Creamos entre 1 y 6 Pokemons random
            int numPokemons = faker.number().numberBetween(1, 6);
            for (int j = 0; j < numPokemons; j++) {
                String nombrePokemon = faker.animal().name(); // puedes usar animal como nombre random
                int vida = faker.number().numberBetween(50, 150);
                int danyo = faker.number().numberBetween(10, 50);
                String tipo = faker.options().option("Fuego", "Agua", "Planta", "Eléctrico", "Tierra");
                pokedex.add(new Pokemon(nombrePokemon, vida, danyo, tipo));
            }

            entrenadores[i] = new Entrenador(faker.name().fullName(), faker.address().cityName(), pokedex);
        }

        return entrenadores;
    }
}