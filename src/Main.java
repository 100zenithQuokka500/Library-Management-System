import model.Book;
import model.Member;
import service.LibraryService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Library!!");
        System.out.println("""
                Select any one options:
                1.Add book
                2.Remove book
                3.Issue book
                4.Search book
                5.Return book
                6.Add member
                7.Delete member
                """);
        int choiceNo=sc.nextInt();
        LibraryService libraryService=new LibraryService();
        switch(choiceNo){
            case 1:
                System.out.println("Enter book name,author and ISBN no of the book that you want to add:");
                libraryService.addBook(new Book(sc.nextLine(), sc.nextLine(), sc.nextLine()));
                break;
            case 2:
                System.out.println("Enter book ISBN no of the book that you want to remove:");
                libraryService.removeBook(sc.next());
                break;
            case 3:
                System.out.println("Enter ISBN no and your member id to issue the book:");
                libraryService.issueBook(sc.next(), sc.next());
                break;
            case 4:
                System.out.println("Enter the book title of the book you want to search:");
                libraryService.searchBook(sc.nextLine());
                break;
            case 5:
                System.out.println("Enter the book ISBN no and your member id to return the book:");
                libraryService.returnBook(sc.next(), sc.next());
                break;
            case 6:
                System.out.println("Enter member name and id");
                Member member=new Member(sc.nextLine(), sc.next());
                libraryService.addMember(member);
                break;
            case 7:
                System.out.println("Enter the member id");
                libraryService.removeMember(sc.next());
                break;
            default:
                System.out.println("Invalid Number");

        }


    }
}