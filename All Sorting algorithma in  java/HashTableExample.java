
import java.util.HashMap;
import java.util.Map;

public class HashTableExample {

    public static void main(String[] args) {

        HashMap<Integer, String> table = new HashMap<>();

        // Insert
        table.put(101, "Aniket");
        table.put(102, "Rahul");
        table.put(103, "Aman");

        System.out.println("Hash Table: " + table);

        // Search
        int key = 102;

        if (table.containsKey(key)) {
            System.out.println("Found: " + table.get(key));
        } else {
            System.out.println("Key not found");
        }

        // Update
        table.put(102, "Rohit");
        System.out.println("After Update: " + table.get(102));

        // Delete
        table.remove(103);
        System.out.println("After Delete: " + table);

        // Iterate
        System.out.println("All Entries:");

        for (Map.Entry<Integer, String> entry : table.entrySet()) {
            System.out.println(
                entry.getKey() + " -> " + entry.getValue()
            );
        }
    }
}
