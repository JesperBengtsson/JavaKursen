import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";

        int[] arr = {1, 2, 2, 3, 4, 4};

        while(!command.equals("EXIT")) {
            System.out.println("--------MENU--------\n[1] Array duplicates\n[2] Set duplicates\n"
                    + "[3] Add element\n[4] Remove first element\n[5] Map");
            command = reader.readLine();
            if(command.equals("1") || command.equals("2")) {
                System.out.println("Input: " + Arrays.toString(arr));
//kollar efter dubbletter genom att göra två for loops
//kollar först sista elementet och sen kollar om nästa är = förra
//isf är det dubblett
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = i+1; j < arr.length; j++) {
                        if ((arr[i] == arr[j])) {
                            if (command.equals("1")) {
                                System.out.println("Duplicates: " + arr[j]);
                            }
//använder föregående for loop och gör om arrayen till en HashSet och printar ut
                            if (command.equals("2")) {
                                Set<Integer> mySet = new HashSet<>(Arrays.asList(arr[j]));
                                System.out.println("Duplicates: " + mySet);  
                            }
                        }
                    }
                }
            }
            if(command.equals("3")) {
//skapar en ArrayList som tar in arrayen och lägger till 5 i listan och printar ut
                List<Integer> myList = new ArrayList<>();
                for (int i : arr) {
                    myList.add(i); }
                System.out.println("Input: " + myList);
                myList.add(5);
                System.out.println(myList + "\n5 is added to the list");
            }
            if(command.equals("4")) {
                System.out.println("Input: " + Arrays.toString(arr));
//skapar en ny array som är en plats mindre därav tar bort första elementet
                int[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
                System.out.println(Arrays.toString(newArr) + "\nFirst element(1) was deleted");
            }
            if(command.equals("5")) {
//skapar en int och string array som jag sätter in som key och value i mapen
//printar sedan ut mapens key och value
                int[] intArray = {1, 2, 3, 4};
                String[] stringArray = {"abc", "def", "ghi", "jkl"};
                Map<int[], String[]> map = new HashMap<>();
                map.put(intArray, stringArray);
                System.out.println(Arrays.toString(intArray) + " : " + Arrays.toString(stringArray));
            }
        }
    }
}