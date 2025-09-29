/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.actividad3;

/**
 *
 * @author Pamela Gonzalez
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Actividad3 {

    // ===== Clase Card =====
    static class Card {
        private String palo;   // tréboles, corazones, picas o diamantes
        private String color;  // rojo o negro
        private String valor;  // 2-10, A, J, Q, K

        public Card(String palo, String color, String valor) {
            this.palo = palo;
            this.color = color;
            this.valor = valor;
        }

        public String getPalo() { return palo; }
        public String getColor() { return color; }
        public String getValor() { return valor; }

        @Override
        public String toString() {
            return palo + "," + color + "," + valor;
        }
    }

    // ===== Clase Deck =====
    static class Deck {
        private ArrayList<Card> cartas; // atributo principal (Collection Framework)

        public Deck() {
            cartas = new ArrayList<>();
            String[] palos = {"Treboles", "Corazones", "Picas", "Diamantes"};
            String[] valores = {"2","3","4","5","6","7","8","9","10","A","J","Q","K"};

            for (String palo : palos) {
                String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? "Rojo" : "Negro";
                for (String valor : valores) {
                    cartas.add(new Card(palo, color, valor));
                }
            }
        }

        // Mezclar
        public void shuffle() {
            Collections.shuffle(cartas);
            System.out.println("Se mezcla el Deck.");
        }

        // Mostrar la primera carta y removerla
        public void head() {
            if (!cartas.isEmpty()) {
                Card c = cartas.remove(0);
                System.out.println(c + " Quedan " + cartas.size() + " cartas en deck.");
            } else {
                System.out.println("No quedan cartas.");
            }
        }

        // Seleccionar una carta al azar y removerla
        public void pick() {
            if (!cartas.isEmpty()) {
                Random rand = new Random();
                Card c = cartas.remove(rand.nextInt(cartas.size()));
                System.out.println(c + " Quedan " + cartas.size() + " cartas en deck.");
            } else {
                System.out.println("No quedan cartas.");
            }
        }

        // Regresar 5 cartas
        public void hand() {
        if (cartas.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card c = cartas.remove(0);
                System.out.println(c);  // cada carta en una línea
            }
        System.out.println("Quedan " + cartas.size() + " cartas en deck.");
        } else {
            System.out.println("No hay suficientes cartas.");
        }
}
        
        
    }

    // ===== main para probar =====
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}
