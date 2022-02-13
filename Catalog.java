import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class Catalog {
    private ArrayList<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
    private int id = 0;

    public Catalog(ArrayList<CatalogItem> items) throws IllegalArgumentException{
        ArrayList<String> idList = new ArrayList<String>();
        catalogItems = new ArrayList<>();
        CatalogItem newId;
        for(int i = 0; i < items.size(); i++){
            newId = items.get(i);
            if(idList.contains(newId.getId())){
                throw new IllegalArgumentException("IDs are not unique.");
            }
            else{
                catalogItems.add(newId);
            }
        }
    }

    public String add(LibraryItem libraryItem){
        id++;
        CatalogItem item = new CatalogItem(libraryItem, String.valueOf(id), true);
        this.catalogItems.add(item);
        return String.valueOf(id); 
    }

    public boolean checkout(String id){
        for(CatalogItem item : catalogItems){
            if (item.getId().equals(id) && item.isAvailable() == true){
                item.setUnavailable();
                return true;
            }
        }
        return false; 
    }

    public boolean checkin(String id){
        for(CatalogItem item : catalogItems){
            if (item.getId() == id && item.isAvailable() == false){
                item.setAvailable();
                return true;
            }
        }
        return false;     
    }
    
    public ArrayList<String> search(String searchTerm){
        ArrayList<String> bookIDs = new ArrayList<String>();
        for(CatalogItem item : this.catalogItems){
            if (item.getLibraryItem().matches(searchTerm)){
                bookIDs.add(item.getId());
            }
        }
        return bookIDs;
    }

    public LibraryItem getLibraryItem(String id){
        LibraryItem foundBook = null;
        for(CatalogItem item : this.catalogItems){
            if(item.getId().equals(id)){
                foundBook = item.getLibraryItem();
            }
        }
        return foundBook;
    }

    public boolean remove(String id){
        for(CatalogItem item : catalogItems){
            if(item.getId().equals(id) && item.isAvailable() == true){
                catalogItems.remove(item);
                return true;
            }
        }
        return false;
    }
}


