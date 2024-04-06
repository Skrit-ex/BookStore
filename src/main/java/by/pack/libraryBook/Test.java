package by.pack.libraryBook;

import by.pack.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        saveBook();
    }

    public static void saveBook() throws IOException {
        File file = new File("G:\\JDK\\BookStore\\src\\main\\java\\by\\pack\\libraryBook\\Bookfile");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = bufferedReader.readLine();
            System.out.println(s);
        } finally {

        }
    }
}
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                if (!line.isEmpty()) {
//                    String[] data = line.split(",");
//                    if (data.length >= 4) {
//                        String nameBook = data[0];
//                        String nameAuthor = data[1];
//                        String lastNameAuthor = data[2];
//                        String genre = data[3];
//                        Book book = new Book(nameBook, nameAuthor, lastNameAuthor, genre);
//                        System.out.println(book);}
//                    }
//                }
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

