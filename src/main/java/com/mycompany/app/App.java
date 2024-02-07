package com.mycompany.app;

import com.google.gson.Gson;

import java.io.*;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Татьяна", "Ларина", 16);

        Gson gson = new Gson();
        String gsonString = gson.toJson(person);
        System.out.println("Person " + gsonString);

        try (FileOutputStream fileOutputStream = new FileOutputStream("person.gson");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(person);
            System.out.println("\nОбъект person сериализован");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream fileInputStream = new FileInputStream("person.gson");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            person = (Person) objectInputStream.readObject();
            System.out.println("\nОбъект person десериализован");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
