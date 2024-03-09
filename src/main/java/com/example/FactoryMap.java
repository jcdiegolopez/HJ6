package com.example;



public class FactoryMap {

    public CardManager<String,Card> createMap(String type) throws Exception{
        switch (type) {
            case "HashMap":
                return new HashMapCardManager();
               
            case "LinkedHashMap":
                return new LinkedHashCardManager();
                
            case "TreeMap":
                return new TreeMapCardManager();  
            default:
                return null;
        }
    }
    
}
