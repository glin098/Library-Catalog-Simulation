public class Book extends LibraryItem{
    private String authorsFirstName;
    private String authorsLastName;
    private String isbn;
    private String publisher;

    public Book(){
        super();
        this.authorsFirstName = "";
        this.authorsLastName = "";
        this.isbn = "";
        this.publisher = "";
    }

    public Book(String title, int year, String firstName, String lastName, String publisher, String isbn){
        super(title, year);
        this.authorsLastName = lastName;
        this.authorsLastName = firstName;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public String getAuthorFirstName(){
        return this.authorsFirstName;
    }

    public String getAuthorLastName(){
        return this.authorsLastName;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public String getISBN(){
        return this.isbn;
    }

    public boolean matches(String keyword){
        if (super.matches(keyword) || keyword.equals(this.authorsFirstName) || keyword.equals(this.authorsLastName)
        || keyword.equals(this.isbn) || keyword.equals(this.publisher)){
            return true;
        }
        return false;
    }

    public String toString(){
        String bookResult = this.title + ", " + this.authorsLastName
         + ", " + this.authorsFirstName + ", " + this.publisher + ", " + this.isbn;
        return bookResult;
    }
}
