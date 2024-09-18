package service;
import model.Book;
import model.Member;
import util.InputValidator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class LibraryService {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members=new ArrayList<>();
    private HashMap<String,Book> bookMap = new HashMap<>();
    private HashMap<String,Member> memberMap=new HashMap<>();
    private TreeMap<String,Book> sortedBooks =new TreeMap<>();
    private TreeMap<String,Member> sortedMembers= new TreeMap<>();
    private HashSet<String> issuedBooks=new HashSet<>();

    public void addBook(Book book){
        if(InputValidator.validateBook(book)){
            books.add(book);
            bookMap.put(book.getISBN(),book);
            sortedBooks.put(book.getTitle(),book);
            System.out.println(book.getTitle()+" added successfully");
        }else{
            System.out.println("Invalid book details.");
        }

    }
    public boolean removeBook(String ISBN){
        if(!bookMap.containsKey(ISBN)){
            System.out.println("Book not found,");
            return false;
        }
        if(issuedBooks.contains(ISBN)){
            System.out.println("Book is currently issued and cannot be removed.");
            return false;
        }
        Book book =bookMap.remove(ISBN);
        books.remove(book);

        sortedBooks.remove(book.getTitle());
        System.out.println("Book removed successfully.");
        return true;
    }
    public void searchBook(String title){
       for(Book e:books){
           if(e.getTitle().equals(title)){
               System.out.println(e);
           }
       }
    }
    public void addMember(Member member){
        if(InputValidator.validateMember(member)){
            members.add(member);
            memberMap.putIfAbsent(member.getID(), member);
            System.out.println("member added successfully.");
        }else{
            System.out.println("Invalid member details.");
        }

    }
    public void removeMember(String memberId){
       Member member=memberMap.get(memberId);
        if(memberMap.containsKey(memberId)){
            if(!issuedBooks.contains(memberId)){
                memberMap.remove(memberId);
                members.remove(member);
                System.out.println("Member removed successfully.");
            }else{
                System.out.println("Member has issued books and cannot be removed.");
            }
        } else {
            System.out.println("Member not found.");
        }
    }
    public void issueBook(String ISBN,String memberId){
      //  Book book = bookMap.get(ISBN);
        if(bookMap.containsKey(ISBN) && memberMap.containsKey(memberId) && !issuedBooks.contains(ISBN)){
            issuedBooks.add(ISBN);
            System.out.println("book avilable for issue");
        }else{
            System.out.println("Sorry Book cannot be issued!!");
        }
    }
    public void returnBook(String ISBN, String memberId){
        if(issuedBooks.contains(ISBN)){
            issuedBooks.remove(ISBN);
            System.out.println(sortedBooks.get(ISBN)+" returned successfully");
        }else{
            System.out.println("Sorry book cannot be returned!!");
        }
    }

}
