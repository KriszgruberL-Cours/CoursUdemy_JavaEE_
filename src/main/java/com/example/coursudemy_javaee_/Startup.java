package com.example.coursudemy_javaee_;

import com.example.coursudemy_javaee_.entities.Artist;
import com.example.coursudemy_javaee_.entities.Catalogue;
import com.example.coursudemy_javaee_.entities.Work;


public class Startup {
    public static void main(String[] args) {

        Work mr = new Work(1L,"Minority Report", "Science Fiction", 2002, "A future technology makes it possible for police officers to catch criminals before a crime is committed. John Anderton is accused of one such crime and sets out to prove his innocence.", new Artist("Tom Cruise"));
        Work bad = new Work(2L,"Bad", "Pop", 1987, "Bad is the seventh studio album by the American singer and songwriter Michael Jackson.", new Artist("Michael Jackson"));
        Work gendarme = new Work(3L,"Le Gendarme de Saint-Tropez", "Comédie", 1964, "A French police officer's daughter tries to pass herself off as a wealthy heiress.", new Artist("Louis de Funès"));

        Catalogue.listOfWork.add(mr);
        Catalogue.listOfWork.add(bad);
        Catalogue.listOfWork.add(gendarme);

        for (Work work : Catalogue.listOfWork) {
            System.out.printf("%s ( %s ) %n", work.getTitle(), work.getRelease());
        }
    }
}
