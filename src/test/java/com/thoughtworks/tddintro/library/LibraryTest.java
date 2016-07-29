package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private List<String> books;
    private PrintStream printStream;
    private DateTimeFormatter dateTimeFormatter;
    private Library library;
    private DateTime time;
    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    @Before
    public void setUp() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
        time = new DateTime();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        setUp();
        String title = "Book Title";
        books.add(title);
        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        // implement me
        setUp();
        library.listBooks();
        //modified src code to print empty string if no books added
        verify(printStream).println("");
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        // implement me
        setUp();
        String firstBook = "Book Title A";
        String secondBook = "Book Title B";
        books.add(firstBook);
        books.add(secondBook);
        library.listBooks();
        //Not sure if we're allowed to call verify twice
        verify(printStream).println(firstBook);
        verify(printStream).println(secondBook);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        setUp();

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        setUp();

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
        //I'm not exactly sure what I'm supposed to verify.
        verify(printStream).println("Welcome to the library! The current time is ");
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        // then move common test variables into a setup method
        setUp();
        String testTime = "12:00 PM";
        when(dateTimeFormatter.print(time)).thenReturn(testTime);
        library.welcome(time);
        verify(printStream).println(contains(testTime));

    }
}
