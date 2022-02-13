public class LibraryItem{
    protected String title;
    protected int year;

    public LibraryItem(){
        this.title = "";
        this.year = 0;
    }

    public LibraryItem(String title, int year){
        this.title = title;
        this.year = year;
    }

    public String getTitle(){
        return this.title;
    }

    public int getYear(){
        return this.year;
    }

    public boolean matches(String keyword){
        String yearToString = String.valueOf(this.year);
        if (keyword.equals(this.title) || keyword.equals(yearToString)){
            return true;
        }
        return false;
    }
}
