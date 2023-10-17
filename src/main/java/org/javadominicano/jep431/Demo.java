package org.javadominicano.jep431;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        /*
        List<Integer> list = new ArrayList<>();
        list.add(2014);                         // Adds 2014 to the list.
        list.addFirst(1996);                    // Adds 1996 to the beginning of the list.
        //list.add(0, 1996);                    // Before java 21
        list.addLast(2023);                     // Adds 2023 to the end of the list.
        //list.add(2023);                       // Before java 21
        System.out.println(list);               // Output: [1996, 2014, 2023]
        System.out.println(list.getFirst());    // Output: 1996
        System.out.println(list.getLast());     // Output: 2023
        System.out.println(list.reversed());    // Output: [2023, 2014, 1996]
        System.out.println(list.removeFirst()); // Output: 1996
        //list.remove(0);                       // Before java 21
        System.out.println(list.removeLast());  // Output: 2023
        //list.remove(list.size() - 1);         // Before java 21
        System.out.println(list);               // Output: [2014]
        */

        /*
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(Set.of(1996, 2014, 2018, 2021, 2023));
        System.out.println("Contents: " + hashSet);                 // Output: [2018, 1996, 2014, 2023, 2021]
        System.out.println("First element: " + hashSet.getFirst()); // Output: 2018
        System.out.println("Last element: " + hashSet.getLast());   // Output: 2021
        System.out.println("Reversed view: " + hashSet.reversed()); // Output: [2021, 2023, 2014, 1996, 2018]
        */

        /*
        LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();
        hashMap.put(2014, "1.8");
        hashMap.put(2018, "11");
        hashMap.put(2021, "17");
        hashMap.put(2023, "21");
        System.out.println("hashmap: " + hashMap);
        // Output: {2014=1.8, 2018=11, 2021=17, 2023=21}

        hashMap.put(1996, "1.0");
        hashMap.put(2024, "22");

         System.out.println("hashmap: " + hashMap);
        // Output: {2014=1.8, 2018=11, 2021=17, 2023=21, 1996=1.0, 2024=22}

        // Fetching the first entry
        System.out.println("Fetching first entry: " + hashMap.entrySet().iterator().next());
        // Output: 2014=1.8

        // Fetching the last entry
        Map.Entry<Integer, String> lastEntry = null;
        for (java.util.Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            lastEntry = entry;
        }
        System.out.println("Fetching last entry: " + lastEntry);
        // Output: 2024=22

        // Removing the first entry
        Map.Entry<Integer, String> removedFirstEntry = hashMap.entrySet().iterator().next();
        hashMap.remove(removedFirstEntry.getKey());
        System.out.println("Removing first entry: " + removedFirstEntry);
        // Output: 2014=1.8

        hashMap.remove(lastEntry.getKey());
        System.out.println("Removing last entry: " + lastEntry);
        // Output: 2024=22

        System.out.println("hashMap: " + hashMap);
        // Output: {2018=11, 2021=17, 2023=21, 1996=1.0}

        LinkedHashMap<Integer, String> reversedMap = new LinkedHashMap<>();
        List<Map.Entry<Integer, String>> entries = new ArrayList<>(hashMap.entrySet());

        Collections.reverse(entries);

        for (Map.Entry<Integer, String> entry : entries) {
            reversedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Reversed view of the map: " + reversedMap);
        // Output: {1996=1.0, 2023=21, 2021=17, 2018=11}
        */


        LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();
        hashMap.put(2014, "1.8");
        hashMap.put(2018, "11");
        hashMap.put(2021, "17");
        hashMap.put(2023, "21");

        System.out.println("HashMap: " + hashMap);
        // Output: {2014=1.8, 2018=11, 2021=17, 2023=21}

        hashMap.putFirst(1996, "1.0");
        hashMap.putLast(2024, "22");

        System.out.println("HashMap: " + hashMap);
        // Output: {1996=1.0, 2014=1.8, 2018=11, 2021=17, 2023=21, 2024=22}

        System.out.println("Fetching first entry: " + hashMap.firstEntry());
        // Output: 2024=22

        System.out.println("Fetching last entry: " + hashMap.lastEntry());
        // Output: 2024=22

        System.out.println("Removing first entry: " + hashMap.pollFirstEntry());
        // Output: 1996=1.0

        System.out.println("Removing last entry: " + hashMap.pollLastEntry());
        // Output: 2024=22

        System.out.println("HashMap: " + hashMap);
        // Output: {2014=1.8, 2018=11, 2021=17, 2023=21}

        System.out.println("Reversed view of the map: " + hashMap.reversed());
        // Output: {2023=21, 2021=17, 2018=11, 2014=1.8}


    }
}
