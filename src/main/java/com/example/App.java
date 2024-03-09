package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;






public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        FactoryMap factory = new FactoryMap();
        String implementation = "HashMap";
        CardManager<String,Card> cardManager;
        boolean bucle = true;
        try {
            
            System.out.println("1. HashMap ");
            System.out.println("2. LinkedHashMap ");
            System.out.println("3. TreeMap ");
            System.out.println("Ingrese el tipo de implementación que desea utilizar: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    implementation = "HashMap";
                    break;
                case 2:
                    implementation = "LinkedHashMap";
                    break;
                case 3:
                    implementation = "TreeMap";
                    break;
                default:
                    break;
            }
            cardManager = factory.createMap(implementation);
            ArrayList<String[]> myCards = readCSV("C:\\Users\\dijol\\OneDrive - UVG\\Universidad\\Ciclo 3\\Algoritmos\\programas\\hj6\\src\\main\\java\\com\\example\\cards_desc.txt");
            long startTime = System.nanoTime();
            for (String[] card : myCards) {
                cardManager.addCard(card[0], new Card(card[0], card[1]));
            }
            long deltaTimeMap = System.nanoTime() - startTime;

            while (bucle) {
                System.out.println("1. Agregar carta a usuario ");
                System.out.println("2. Mostrar el tipo de una carta específica ");
                System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección. ");
                System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo ");
                System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes ");
                System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo. ");
                System.out.println("7. Salir ");
                System.out.println("8. Test de HashMap ");
                System.out.println("Ingrese que desea hacer: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Ingrese el nombre de la carta que desea agregar: ");
                        String card = scanner.nextLine();
                        Card cardToAdd = cardManager.getCard(card);
                        if (cardToAdd == null) {
                            System.out.println("La carta no existe");
                            break;
                        }else{
                            cardManager.addUserCard(card, cardToAdd);
                            break;
                        }
                    case 2:
                        scanner.nextLine();
                        System.out.println("Ingrese el nombre de la carta: ");
                        String cardName = scanner.nextLine();
                        Card finded = cardManager.getCard(cardName);
                        if (finded == null) {
                            System.out.println("La carta no existe");
                            break;
                        }else{
                            System.out.println("El tipo de la carta es: " + finded.getType());
                            break;
                        }
                        
                    case 3:
                        cardManager.showUserCards();
                        break;
                    case 4:
                        cardManager.showSortedUserCards();
                        break;
                    case 5:
                        long startTimeShow = System.nanoTime();
                        cardManager.showCards();
                        long deltaTimeTotal = (System.nanoTime() - startTimeShow) + deltaTimeMap;
                        System.out.println("Tiempo de ejecución total: " + deltaTimeTotal);
                        break;
                    case 6:
                        cardManager.showSortedCards();
                        break;
                    case 7:
                        bucle = false;
                        System.out.println("Saliendo ");
                        break;
                    case 8:
                        runTimeTestHash(myCards);
                        break;
                    default:
                        System.out.println("No es una opción válida");
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String[]> readCSV(String filePath) {
        ArrayList<String[]> data = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                
                String[] values = line.split("\\|");
                
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void runTimeTestHash(ArrayList<String[]> myCards){
        
        ArrayList<String[]> myTimes = new ArrayList<String[]>();
        for (int i = 0; i < myCards.size(); i++) {
            
            CardManager<String,Card> cardManager = new HashMapCardManager();
            List<String[]> subList = myCards.subList(0, i);
            long startTime = System.nanoTime();
            for (String[] card : subList) {
                cardManager.addCard(card[0], new Card(card[0], card[1]));
            }
            long deltaTimeMap = System.nanoTime() - startTime;
            myTimes.add(new String[]{String.valueOf(i), String.valueOf(deltaTimeMap)});
        }
        exportToCSV(myTimes, "C:\\Users\\dijol\\OneDrive - UVG\\Universidad\\Ciclo 3\\Algoritmos\\programas\\hj6\\src\\main\\java\\com\\example\\times.csv");
        
    }

    private static void exportToCSV(ArrayList<String[]> data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.write(row[i]);
                    if (i == 0) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}