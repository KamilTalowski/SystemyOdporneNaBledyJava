package main;

import java.util.Random;

public class Test {

    public static void main(String[] args) throws Exception {
        NumberSet numberSet = new NumberSet();
        Random generator = new Random();
        // Wylosowanie 8 elementow do tablicy z zakresu 0-25
        for (int i = 0; i < 8; i++){
            numberSet.add(generator.nextInt(26));
        }

        // Wypisanie tablicy i zwrocenie sumy wszystkich elementow
        numberSet.print();
        numberSet.getSumOfElements();

        // Podzielenie i wpisanie wszystkich elementow i nowej sumy
        numberSet.divideAllElementsBy(3);
        numberSet.print();
        numberSet.getSumOfElements();


        // Uzycie getRandomElement() i wypisanie liczb po zmianie
        numberSet.getRandomValue();
        numberSet.print();


        System.out.println("Dodaje wartosci 2 i 5");
        numberSet.add(2);
        numberSet.add(5);
        numberSet.print();

        // Sprawdzenie czy liczba jest w zestawie
        numberSet.add(5);
        numberSet.contains(5);
        numberSet.remove(5);
        System.out.println("Po usunieciu wszystkich 5");
        numberSet.contains(5);

        // Usuniecie liczby
        numberSet.remove(2);
        System.out.println("Po usunieciu wszystkich 2");
        numberSet.contains(2);

        // Ostatecze wyswietlenie zestawu
        numberSet.print();
    }
}
