package com.example;

public interface CardManager<K,V> {
    
    public void addCard(K key, V value);
    public void addUserCard(K key, V value);
    public V getCard(K key);
    public V getCardUser(K key);
    public void showUserCards();
    public void showCards();
    public void showSortedUserCards();
    public void showSortedCards();
    

}
