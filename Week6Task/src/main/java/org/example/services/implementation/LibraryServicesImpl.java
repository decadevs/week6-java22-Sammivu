package org.example.services.implementation;


import org.example.models.Book;
import org.example.models.Person;
import org.example.services.LibraryServices;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.example.models.Library.*;

public class LibraryServicesImpl implements LibraryServices {

    @Override
    public String giveBookBasedOnRole( String book, List<Book> getBooks) {

        //Comparator comparing the roles using method referencing
        peopleOnQueue.sort(Comparator.comparing(Person::getRole));
        String result ="";

        peopleOnQueue.forEach( p -> {
            if(reduceBookCount(book,getBooks) != null) {
                System.out.println(p.getFullName() + " has borrowed " + book);

            }else {
                System.out.println(p.getFullName()+ " cannot borrow "+ book+ " because it have been borrowed");
            }

            }
        );
        return result;
    }

    @Override
    public Book reduceBookCount(String nameOfBook, List<Book> books) {
        Book book =null;
        for(Book b:books){
            if(nameOfBook.equals(b.getBookTitle()) && b.getQuantityAvailable()!= 0){
                b.setQuantityAvailable(b.getQuantityAvailable()-1);
                book = b;
            }
            else if (!books.contains(b)){
                System.out.println(nameOfBook+ " is not available, check back later");
            }
        }
        return book;
    }





    @Override
    public String addPeopleToQueueOnFirstCome(Person person) {
        peopleOnQueue.add(person);
        return person.getFullName();
    }


    @Override
    public String booksGivenByFirstCome(String book, List<Book> getBooks) {
        String result ="";

        peopleOnQueue.forEach( p->{
            if(reduceBookCount(book,getBooks) != null) {
                System.out.println(p.getFullName() + " has borrowed " + book);
            }else {
                System.out.println(p.getFullName()+ " cannot borrow "+ book+ " because it have been borrowed");
            }
        }
        );
        return result;

    }
}





