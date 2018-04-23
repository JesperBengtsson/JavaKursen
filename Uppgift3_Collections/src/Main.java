import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = "";

        int[] arr = {1, 3, 4, 2, 2, 3, 4, 4};

        while(!command.equals("EXIT")) {
            System.out.println("--------MENU--------\n[1] Array duplicates\n[2] Set duplicates\n"
                    + "[3] Add element\n[4] Remove first element\n[5] Map");
            command = reader.readLine();
            if(command.equals("1")) {
//printar ut arrayen och skapar en ny array och loopar igenom i for loopen
//som sedan printar ut den nya arrayen utan dubbletter
                System.out.println("Input: " + Arrays.toString(arr));
                Arrays.sort(arr);
                int[] newArr = new int[arr.length];
                int prev = arr[0];
                newArr[0] = prev;
                int count = 1;
                	for (int i = 0; i < arr.length; ++i) {
                		if (arr[i] != prev) {
                        newArr[count++] = arr[i];
                		}
                		prev = arr[i];
                	}
                		int[] comp = new int[count];
                		System.arraycopy(newArr, 0, comp, 0, count);
                		System.out.println("Output: " + Arrays.toString(comp));
            }
            if(command.equals("2")) {
//printar input from arrayen, och skapar en hashset och addar arr in i hashsetten och sedan printar ut            	
            	System.out.println("Input: " + Arrays.toString(arr));
            	Set<Integer> mySet = new HashSet<>();
            	for(int i : arr) {
            		mySet.add(i); }
            	System.out.println("Output: " + mySet);
            }
            if(command.equals("3")) {
//skapar en ArrayList som tar in arrayen och lägger till 5 i listan och printar ut
                List<Integer> myList = new ArrayList<>();
                for(int i : arr) {
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