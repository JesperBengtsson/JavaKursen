
public class ShoppingCart extends Storage<Item> {
	
//loopar igenom listan och printar ut vilken index som h�r till vilket element
    public void showWhatToRemove(){
        for(Item item : storageList) {
            System.out.println("[" + storageList.indexOf(item) + "] to remove "
            		+ item.getArtNumber() + " from your cart.\n");
        }
    }
//kollar ifall listan �r tom    
    public boolean isEmpty() {
        return storageList.size() == 0;
    }
//summerar price p� alla element i lista
    public int cartSumOfItems(int price) {
    	int sum = 0;
    	for(Item item : storageList)
    	    sum += item.getPrice();
    	return sum;
    }
}