import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q6 {

    // Define the Book class
    public static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{id=" + bookId + ", title='" + title + "', author='" + author + "'}";
        }
    }

    // Linear search by title
    public static Book linearSearchByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search by title
    public static Book binarySearchByTitle(List<Book> books, String title) {
        // Sort the list by title if not already sorted
        books.sort(Comparator.comparing(Book::getTitle));

        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create a list of books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(4, "Moby Dick", "Herman Melville"));

        // Test linear search
        String searchTitle = "1984";
        Book foundBookLinear = linearSearchByTitle(books, searchTitle);
        System.out.println("Linear Search Result: " + (foundBookLinear != null ? foundBookLinear : "Book not found"));

        // Test binary search
        Book foundBookBinary = binarySearchByTitle(books, searchTitle);
        System.out.println("Binary Search Result: " + (foundBookBinary != null ? foundBookBinary : "Book not found"));
    }
}
