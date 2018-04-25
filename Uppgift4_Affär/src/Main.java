import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ItemStorage myStorage = new ItemStorage();
        ShoppingCart myCart = new ShoppingCart();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
//callar funktion som fyller myStorage listan med samtliga items        
        myStorage.initializeItems();

        while (!command.equals("EXIT")) {
            System.out.println("-------MENU-------\n[1] Show storage\n[2] Go to cart\n" +
                    "[EXIT] to exit\n------------------");
            command = reader.readLine();
//printar ut myStorage listan                
             if(command.equals("1")){
            	try {        		
            		myStorage.itemList();
            		System.out.println("[1] To search\n[2] Add items to cart\n[MENU] Back to menu");
            		command = reader.readLine();
//stämmer userinput så söker programmet igenom listan efter artNumber
//genom att calla funktion i ItemStorage klassen       		
            			if(command.equals("1")) {
            				System.out.println("Search by Art.number\n[MENU] Back to menu");
            				command = reader.readLine();
            					if(command.equals("MENU")) {
            						continue;
            					}
            				int index = Integer.parseInt(command);
            				myStorage.findItemByArtNumber(index);
            				continue;
            			}
//stämmer userinput visas index som hör till vilket item
//lägger sedan in item från myStorage till myCart och input stämmer            			
            			if(command.equals("2")) {               				
            				myStorage.showWhatToAdd();
            				System.out.println("[MENU] Back to menu");
            				command = reader.readLine();
            					if(command.equals("MENU")) {
            						continue;
            					}
            				int index = Integer.parseInt(command);
            				myCart.addItem(myStorage.getAndRemoveItem(index));           				
            			}
            			if(command.equals("MENU")) {
            				continue;
            			}           			
            	}
            	catch (IndexOutOfBoundsException | NumberFormatException e) {
            		System.out.println("Invalid input!");
            		continue;
            	}
            }
//printar myCart listan om den ej är tom             
            if(command.equals("2")) {
                if(!myCart.isEmpty()){
                    myCart.itemList();
                    System.out.println("[1] To remove from cart\n[2] Back to menu\n[3] Checkout");
                    command = reader.readLine();
//stämmer userinput visas index som hör till vilket item
//tar sedan bort item från myCart till myStorage och input stämmer                   
                    if(command.equals("1")) {
                        myCart.showWhatToRemove();
                        command = reader.readLine();
                        int index = Integer.parseInt(command);
                        myStorage.addItem(myCart.getAndRemoveItem(index));
                    }
                    else if(command.equals("2")){
                        continue;
                    }
//skriver ut ett kvitto med alla items i listan totalsumma genom
//att calla funktion i ShoppingCart klassen om tömmer myCart listan                    
                    else if(command.equals("3")) {                    
                    	System.out.println("------RECEIPT------");
                    	myCart.itemList();
                    	System.out.println("Total: " + myCart.cartSumOfItems(0) + "kr"
                    			+ "\n-------------------");
                    	myCart.storageList.clear();
                        continue;
                    }
                }
                else
                    System.out.println("Cart is empty");
                    continue;
            }             
        }
    }
}