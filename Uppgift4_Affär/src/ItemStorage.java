public class ItemStorage extends Storage<Item> {

//loopar igenom listan och printar ut vilken index som h�r till vilket element	
    public void showWhatToAdd(){
        for(Item item : storageList) {
            System.out.println("[" + storageList.indexOf(item) + "] to put "
            		+ item.getArtNumber() + " in your cart.\n");
        }
    }
//s�kmotor, loopar igenom listan, st�mmer userinput med artNumber eller description s� printas det elementet ut
	public void searchForItem(String inData){		
	    for (Item item : storageList) {
	        if (item.getArtNumber().contains(inData) || item.getDescription().contains(inData)) {
	            System.out.println(item);
	        }	        
	    }     
    }
}