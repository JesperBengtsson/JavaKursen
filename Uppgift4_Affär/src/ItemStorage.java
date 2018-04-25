public class ItemStorage extends Storage<Item> {

//loopar igenom listan och printar ut vilken index som h�r till vilket element	
    public void showWhatToAdd(){
        for(Item item : storageList) {
            System.out.println("[" + storageList.indexOf(item) + "] to put "
            		+ item.getArtNumber() + " in your cart.\n");
        }
    }
//s�kmotor, loopar igenom listan, st�mmer userinput med artNumber s� printas det elementet ut
	public void findItemByArtNumber(int artNumber){		
	    for (Item item : storageList) {
	        if (item.getArtNumber() == artNumber) {
	            System.out.println(item);
	            return;
	        }	        
	    }
        System.out.println("Invalid input");
    }
}