package md.usm.lab1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvWriter {

    private static final String SAMPLE_CSV_FILE = "books.csv";

    public static void main(String[] args) {

        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE), StandardOpenOption.CREATE_NEW);
                CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter, CSVFormat.DEFAULT
                        .withHeader("Title", "Author", "ISBN13", "Pages"))
        ) {
            csvPrinter.printRecord("1984", "George Orwell", "978-0451526342", "268");
            csvPrinter.printRecord("Animal Farm", "George Orwell", "978-0454326342", "144");
            csvPrinter.printRecord("Brave New World", "Aldous Huxley", "978-0451598442", "288");
            csvPrinter.printRecord("Fahrenheit 451", "Ray Bradbury", "978-0948526342", "208");
            csvPrinter.printRecord("Jane Eyre", "Charlotte Bronte", "978-0021526342", "532");
            csvPrinter.printRecord("Agnes Grey", "Anne Bronte", "978-0451765342", "256");

            csvPrinter.flush();


        } catch (Exception e) {

        }
    }
}
