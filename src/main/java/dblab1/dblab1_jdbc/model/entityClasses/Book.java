package dblab1.dblab1_jdbc.model.entityClasses;

import dblab1.dblab1_jdbc.model.Dialog.FooBook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representation of a book.
 * 
 * @author anderslm@kth.se
 */
public class Book {
    //TODO: check if all ints has to be converted to strings when displayed in
    // the booksPaneView
    private int bookId;
    private String isbn; // should check format
    private String title;
    private java.sql.Date published;
    private int year;
    private int grade;
    private int pages;
    private String language =" ";
     private Genre genre;
    //private String genre;

    private String storyLine = "";
  //  private String author;

       private ArrayList<Author> authors;
    // TODO:
    // Add authors, as a separate class(!), and corresponding methods, to your implementation
    // as well, i.e. "private ArrayList<Author> authors;"

    //TODO: avkommentera arraylist med authors då detta krävs för att representera relationen mellan book och author
    // avkommentera också String author som parameter i konstruktiorn
    // när detta göra behöver man anpassa implementeringen i övriga programmet
    public Book(int bookId, String isbn, String title, /*Author author ,*/ java.sql.Date published, String genre, int grade   ) {
        this.bookId = bookId;

        this.isbn = isbn;
        this.title = title;
        this.authors = new ArrayList<>();
//        this.authors.add(new Author(author));
        //    this.author.setfName(author);

        this.published = published;
        this.genre = Genre.UNDEFINED;
        this.grade = 0;

    }

    public Book(){
        this.bookId = 0;

        this.isbn = null;
        this.title = null;
        this.authors = new ArrayList<>();
//        this.authors.add(new Author(author));
        //    this.author.setfName(author);

        this.published = new java.sql.Date(2000);
        this.genre;
        this.grade = grade;


    }


    public int getBookId() { return bookId; }
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public Date getPublished() { return published; }
    public String getStoryLine() { return storyLine; }

    public List<Author> getAuthors() {
        ArrayList<Author> copy = new ArrayList<>();
      for (int i = 0; i <authors.size(); i++){
          copy.add(new Author(authors.get(i).getId(), authors.get(i).getFullName()));
      }
      return copy;
    }

public String getAuthorAtIndex(int index){
return authors.get(index).toString();
}

    public String getGenre() {
        return genre;
    }

    public int getGrade() {
        return grade;
    }

    //TODO: use with Authors list
//    public ArrayList<Author> getAuthors() {
//        return authors;
//    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublished(java.sql.Date published) {
        this.published = published;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void addAuthor(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setStoryLine(String storyLine) {
        this.storyLine = storyLine;
    }

public void printAuthors(){

        for (int i=0; i < authors.size(); i++){
            System.out.println("Name:" + authors.get(i).getFullName());
            System.out.println("ID: "+ authors.get(i).getId());

        }

}

public ArrayList<String> getAuthorsNames(ArrayList<Author> authors){
  ArrayList<String> nameList = new ArrayList<>();

        for (int i=0; i < authors.size(); i++){
            nameList.add(authors.get(i).getFullName()) ;
        }
        return nameList;
}

    @Override
    public String toString() {
        return bookId +", "+ isbn + ", " + title + ", " + getAuthorsNames(this.authors) + ", " +  published + ", " + genre + ", " + grade;
    }
}
