package INF101.lab2;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Fridge implements IFridge{

    //int max_size = 20;
    //ArrayList<FridgeItem> FridgeArray = new ArrayList<FridgeItem>(max_size);

    int max_size;
    ArrayList<FridgeItem> FridgeArray;

    public Fridge() {
    
        max_size = 20;
        FridgeArray = new ArrayList<>(max_size);
    }

    @Override
    public int nItemsInFridge() {

        int numItems = 0;
        int maxCapacity = FridgeArray.size();

        for (int i = 0; i < maxCapacity; i++) {
            if (FridgeArray.get(i) != null) {
                numItems++;
            }
        }
        return numItems;
    }

    @Override
    public int totalSize() {
        return max_size;
    }

    @Override
    public boolean placeIn(FridgeItem item) {

        if (nItemsInFridge() != totalSize()) {
            FridgeArray.add(item);
            return true;
        }
        return false;
    }

    @Override
    public void takeOut(FridgeItem item) {
    /*   try {
            FridgeArray.remove(item);
        }
        catch(Exception e) {
            throw new NoSuchElementException("Fridge does not contain "+item);
        }
    }
    */
        if(FridgeArray.contains(item)) {
            FridgeArray.remove(item);
        }
        else throw new NoSuchElementException();
    }
    @Override
    public void emptyFridge() {
        FridgeArray.clear();
    }

    @Override
    public List<FridgeItem> removeExpiredFood() {

        ArrayList<FridgeItem> expired = new ArrayList<>();

        for (int i = 0; i < nItemsInFridge(); i++) {

            FridgeItem item = FridgeArray.get(i);

            if (item.hasExpired()) {
                FridgeArray.remove(item);
                expired.add(item);
                i--;
            }
            
        }
        return expired;
    }
}