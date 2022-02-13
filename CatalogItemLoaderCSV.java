import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CatalogItemLoaderCSV {
    private ArrayList<CatalogItem> itemLoader = new ArrayList<CatalogItem>();
    public void loadItems(String fileName) throws IOException{
        try{
            Scanner reader = new Scanner(new File(fileName));
            String line = reader.nextLine();
            
            while(reader.hasNextLine()){ 
                String[] data = line.split(",");

                if(data.length == 9 && data[4].equals("book")){
                    String id = data[0];
                    String title = data[2];
                    int year = Integer.parseInt(data[3]);
                    String firstName = data[5];
                    String lastName = data[6];
                    String publisher = data[7];
                    String isbn = data[8];
                    Book newBook = new Book(title, year, firstName, lastName, publisher, isbn);
                    if(data[1].equals("1")){
                        CatalogItem catalogItem = new CatalogItem(newBook, id, true);
                        itemLoader.add(catalogItem);
                    }
                    else{
                        CatalogItem catalogItem = new CatalogItem(newBook, data[0], false);
                        itemLoader.add(catalogItem);
                    }            
                }

                if(data.length == 8 && data[4].equals("movie")){
                    String id = data[0];
                    String title = data[2];
                    int year = Integer.parseInt(data[3]);
                    String firstName = data[5];
                    String lastName = data[6];
                    String rating = data[7];
                    Movie newMovie = new Movie(title, year, firstName, lastName, rating);
                    if(data[1].equals("1")){
                        CatalogItem catalogItem = new CatalogItem(newMovie, id, true);
                        itemLoader.add(catalogItem);
                    }
                    else{
                        CatalogItem catalogItem = new CatalogItem(newMovie, data[0], false);
                        itemLoader.add(catalogItem);
                    }
                } 
                line = reader.nextLine();
            }
            reader.close();
        }
        catch(IOException i){
            System.out.println("File not found.");
        }
    }

    public ArrayList<CatalogItem> getItems(){
        return itemLoader;   
    }
}
