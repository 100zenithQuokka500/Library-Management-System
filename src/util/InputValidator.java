package util;
import model.Book;
import model.Member;

public class InputValidator {
    public static boolean validateBook(Book book){
        if(book == null) return false;
        if(book.getTitle()==null) return false;
        if(book.getISBN()==null || !book.getISBN().matches("\\d{13}")) return false;
        if(book.getAuthor()==null) return false;
        return true;
    }
    public static boolean validateMember(Member member){
        if(member.getID()==null || !member.getID().matches("[a-zA-Z0-9]+")) return false;
        if(member.getName()==null) return false;

        return true;
    }
}
