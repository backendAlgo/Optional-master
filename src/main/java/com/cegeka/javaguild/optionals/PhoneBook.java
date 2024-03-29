package com.cegeka.javaguild.optionals;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class PhoneBook {

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
        {
            put("Jos de Vos", "016/161616");
            put("An de Toekan", "016/161617");
            put("Kris de Vis", null);
        }
    };

    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    PhoneBook() { }

    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }

    public Optional<String> findPhoneNumberByName(String name){
        if (phoneBookEntries.containsKey(name)){
            return Optional.of(phoneBookEntries.get(name));
        }
        return Optional.empty();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber){
        for (Map.Entry<String, String> entry : phoneBookEntries.entrySet()){
            if (entry.getValue().equals(phoneNumber)){
                return Optional.of(entry.getKey());
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        Predicate<String> predicate = (name) -> {
            throw new IllegalArgumentException();
//            return name.length() > 3;
        };
//        predicate.test("mirshod");
//        Optional.empty()
//                .map()
    }

    @Override
    public String toString() {
        System.out.println("Hello from PhoneBook's toString method");
        return "PhoneBook{" +
                "phoneBookEntries=" + phoneBookEntries +
                '}';
    }
}
