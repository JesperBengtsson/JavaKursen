import java.util.*;

public abstract class Storage<T> {

    protected List<Item> storageList = new ArrayList<>();

//lägger in samtliga items i lista
    public void initializeItems() {
        Item item1 = new Item("1001", 11, "item1");
        Item item2 = new Item("1002", 22, "item2");
        Item item3 = new Item("1003", 33, "item3");       

        storageList.add(item1);
        storageList.add(item2);
        storageList.add(item3);        
    }
//loopar igenom listan och printar ut den
    public void itemList() {
        for(Item item : storageList) {
            System.out.println(item);
        }
    }
//lägger till items i lista
    public void addItem(Item item) {
        storageList.add(item);
    }
//plockar ut eller sätter in element i lista
    public Item getAndRemoveItem(int index) {
        Item item = storageList.get(index);
        storageList.remove(index);
        return item;
    }
}