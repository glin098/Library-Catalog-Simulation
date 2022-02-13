public class Movie extends LibraryItem{
    private String producerFirstName;
    private String producerLastName;
    private String rating;

    public Movie(){
        super();
        this.producerFirstName = "";
        this.producerLastName = "";
        this.rating = "";
    }

    public Movie(String title, int year, String firstName, String lastName, String rating){
        super(title, year);
        this.producerFirstName = firstName;
        this.producerLastName = lastName;
        this.rating = rating;
    }
    
    public String getProducerFirstName(){
        return this.producerFirstName;
    }

    public String getProducerLastName(){
        return this.producerLastName;
    }

    public String getRating(){
        return this.rating;
    }

    public boolean matches(String keyword){
        if (super.matches(keyword) || keyword.equals(this.producerFirstName) || keyword.equals(this.producerLastName) 
        || keyword.equals(this.rating)){
            return true;
        }
        return false;
    }

    public String toString(){
        String bookResult = this.title + ", " + this.producerLastName
        + ", " + this.producerFirstName + "," + this.rating;
        return bookResult;
    }
}
