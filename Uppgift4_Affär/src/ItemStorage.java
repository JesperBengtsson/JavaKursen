public class ItemStorage extends Storage<Item> {

//loopar igenom listan och printar ut vilken index som hör till vilket element	
    public void showWhatToAdd(){
        for(Item item : storageList) {
            System.out.println("[" + storageList.indexOf(item) + "] to put "
            		+ item.getArtNumber() + " in your cart.\n");
        }
    }
//sökmotor, loopar igenom listan, stämmer userinput med artNumber så printas det elementet ut
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