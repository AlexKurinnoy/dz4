package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Contacts contact = new Contacts();
        while (true) {
            System.out.println("- Просмотр контактов: 0");
            System.out.println("- Добавить контакт: 1");
            System.out.println("- Выход: 2");
            Scanner entery  = new Scanner(System.in);
            int inputMenu = entery.nextInt();

            if (inputMenu == 1){
                contact.addContact();
            }
            else if (inputMenu == 0){
                contact.showContact();
            }
            else {
                return;
            }
        }
    }

    public static class Contacts{
        Map<String, String> contactList = new HashMap<String, String>();

        void addContact(){
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}");
            System.out.println("Введите имя:");
            Scanner n = new Scanner(System.in);
            String newName = n.nextLine();
            System.out.println("Введите почту:");
            Scanner e = new Scanner(System.in);
            String newMail = e.nextLine();
            Matcher validatorRegex = pattern.matcher(newMail);
            if (!validatorRegex.matches() ){
                System.out.println("Не валидно");
            }
            else {
            contactList.put(newName, newMail);
            }
        }
        void showContact(){
            for( Map.Entry<String, String> entry : contactList.entrySet() ){
                System.out.println( entry.getKey() + " " + entry.getValue() );
            }
        }
    }
}
