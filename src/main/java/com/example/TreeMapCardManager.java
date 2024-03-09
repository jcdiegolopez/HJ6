package com.example;


import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TreeMapCardManager implements CardManager<String,Card>{
    private TreeMap<String,Card> cards ;
    private TreeMap<String,Card> userCards ;

    public TreeMapCardManager() {
        this.cards = new TreeMap<String,Card>();
        this.userCards = new TreeMap<String,Card>();
    }

    @Override
    public void addCard(String key, Card value) {
        cards.put(key, value);
    }

    @Override
    public void addUserCard(String key, Card value) {
        userCards.put(key, value);
    }

    @Override
    public Card getCard(String key) {
        return cards.get(key);
    }

    @Override
    public Card getCardUser(String key) {
        return userCards.get(key);
    }

    @Override
    public void showUserCards() {
        for (String key : userCards.keySet()) {
            System.out.println("Nombre: " + key + ", Tipo: " + userCards.get(key).getType());
        }
        System.out.println("Cantidad de cartas: "+userCards.size());  
    }

    @Override
    public void showCards() {
        for (String key : cards.keySet()) {
            System.out.println("Nombre: " + key + ", Tipo: " + cards.get(key).getType());
        }
        
    }

    @Override
    public void showSortedUserCards() {
        List<Map.Entry<String, Card>> entryList = new ArrayList<>(userCards.entrySet());
        Collections.sort(entryList, Comparator.comparing(entry -> entry.getValue().getType()));
        for (Map.Entry<String, Card> entry : entryList) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue().getType());
        }
        System.out.println("Cantidad de cartas: "+userCards.size());  
    }

    @Override
    public void showSortedCards() {
        List<Map.Entry<String, Card>> entryList = new ArrayList<>(cards.entrySet());
        Collections.sort(entryList, Comparator.comparing(entry -> entry.getValue().getType()));
        for (Map.Entry<String, Card> entry : entryList) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue().getType());
        }      
    }

}

