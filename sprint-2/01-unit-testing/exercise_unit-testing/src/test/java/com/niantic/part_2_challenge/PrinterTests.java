package com.niantic.part_2_challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrinterTests {
    private static final int MAX_SHEET_CAPACITY = 500;
    private static final int MAX_TONER = 1000;
    private final int sheets = 300;
    private final int toner = 500;
    private Printer printer;

    @BeforeEach
    public void setup() {
        printer = new Printer(sheets, toner);
    }

    @Test
    public void quiz_parameterizedConstructor_ShouldCreatePrinter_WithGivenNumberOfSheetsAndToner() {
        // arrange
        // act

        // assert
        assertNotNull(printer, "Printer object should be created");
        assertEquals(sheets, printer.getSheets(), "The Printer should have " + sheets + " sheets that was set in the constructor");
        assertEquals(toner, printer.getToner(), "The Printer should have toner=" + toner + " that was set in the constructor");
    }

    @Test
    public void print_shouldNotPrint_whenAmountOfCopiesIsNegative() {
        // arrange
        int pages = -20;
        int expectedNumberOfPagesPrinted = 0;

        // set
        int actualNumberOfPagesPrinted = printer.print(pages);

        //assert
        assertEquals(expectedNumberOfPagesPrinted, actualNumberOfPagesPrinted, "Printer should not print negative amount of pages");
    }

    @Test
    public void print_shouldPrintAllPages_whenEnoughSheetsAndToner() {
        int pages = 150;
        int expectedNumberOfPagesPrinted = pages;
        int expectedSheets = sheets - pages;
        int expectedToner = toner - pages;

        // set
        int actualNumberOfPagesPrinted = printer.print(pages);

        //assert
        assertEquals(expectedNumberOfPagesPrinted, actualNumberOfPagesPrinted,
                "Printer should print " + expectedNumberOfPagesPrinted +
                        " pages when number of pages to be printed is " + pages + ", sheets=" + sheets +
                        " and toner=" + toner);
        assertEquals(expectedSheets, printer.getSheets(), "Printer should reduce number of sheets by number of pages printed");
        assertEquals(expectedToner, printer.getToner(), "Printer should reduce toner by number of pages printed");
    }

    @Test
    public void print_shouldPrintPages_whenEnoughSheetsAndNotEnoughToner() {
        // arrange
        int pages = 150;
        int sheets = 500;
        int toner = 100;
        printer = new Printer(sheets, toner);
        int expectedNumberOfPagesPrinted = toner;
        int expectedSheets = sheets - expectedNumberOfPagesPrinted;
        int expectedToner = 0;

        // set
        int actualNumberOfPagesPrinted = printer.print(pages);

        //assert
        assertEquals(expectedNumberOfPagesPrinted, actualNumberOfPagesPrinted,
                "Printer should print " + expectedNumberOfPagesPrinted +
                        " pages when number of pages to be printed is " + pages + ", sheets=" + sheets +
                        " and toner=" + toner);
        assertEquals(expectedSheets, printer.getSheets(), "Printer should reduce number of sheets by number of pages printed");
        assertEquals(expectedToner, printer.getToner(), "Printer should reduce toner by number of pages printed");
    }

    @Test
    public void print_shouldPrintPages_whenEnoughTonerAndNotEnoughSheets() {
        // arrange
        int pages = 400;
        int expectedNumberOfPagesPrinted = sheets;
        int expectedSheets = 0;
        int expectedToner = toner - expectedNumberOfPagesPrinted;

        // set
        int actualNumberOfPagesPrinted = printer.print(pages);

        //assert
        assertEquals(expectedNumberOfPagesPrinted, actualNumberOfPagesPrinted,
                "Printer should print " + expectedNumberOfPagesPrinted +
                        " pages when number of pages to be printed is " + pages + ", sheets=" + sheets +
                        " and toner=" + toner);
        assertEquals(expectedSheets, printer.getSheets(), "Printer should reduce number of sheets by number of pages printed");
        assertEquals(expectedToner, printer.getToner(), "Printer should reduce toner by number of pages printed");
    }

    @Test
    public void print_shouldPrintPages_whenNotEnoughTonerAndNotEnoughSheets() {
        // arrange
        int pages = 600;
        int expectedNumberOfPagesPrinted = Math.min(sheets, toner);
        int expectedSheets = sheets - expectedNumberOfPagesPrinted;
        int expectedToner = toner - expectedNumberOfPagesPrinted;

        // set
        int actualNumberOfPagesPrinted = printer.print(pages);

        //assert
        assertEquals(expectedNumberOfPagesPrinted, actualNumberOfPagesPrinted,
                "Printer should print " + expectedNumberOfPagesPrinted +
                        " pages when number of pages to be printed is " + pages + ", sheets=" + sheets +
                        " and toner=" + toner);
        assertEquals(expectedSheets, printer.getSheets(), "Printer should reduce number of sheets by number of pages printed");
        assertEquals(expectedToner, printer.getToner(), "Printer should reduce toner by number of pages printed");
    }


    @Test
    public void replaceToner_shouldResetTonerToMaximumCapacity() {
        // arrange
        int expectedToner = MAX_TONER;

        // set
        printer.replaceToner();
        int actualToner = printer.getToner();

        // assert
        assertEquals(expectedToner, actualToner, "replaceToner should reset toner to it's maximum capacity");

    }

//    @Test
//    public void addPaper_should




}