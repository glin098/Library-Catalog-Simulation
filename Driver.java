import java.util.ArrayList;
import java.io.IOException;

public class Driver
{
   public static void main(String[] args){
      try{
         if(args.length > 0){
            String fileName = new String();
            fileName = args[0];
            CatalogItemLoaderCSV catalogItemLoaderCSV = new CatalogItemLoaderCSV();
            ArrayList<CatalogItem> items = new ArrayList<CatalogItem>();
            ArrayList<String> unique_id = new ArrayList<String>();
      
            catalogItemLoaderCSV.loadItems(fileName);
            items = catalogItemLoaderCSV.getItems();
            Catalog catalog = new Catalog(items);
            
            unique_id = catalog.search("Mike");
            System.out.println("Items with Mike: ");
            for(String id : unique_id){
               LibraryItem libraryItem = catalog.getLibraryItem(id);
               System.out.println(libraryItem);
            }
         }
         else{
            System.out.println("No command line arguments.");
         }
      }
      catch(IOException i){
         System.out.println("Books cannot be loaded.");
      }
      catch(IllegalArgumentException e){
         System.out.println(e);
      }
   }
}
