package md.usm.lab1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CsvReaderCommonCSV {
    private static final String SAMPLE_CSV_FILE = "books.csv";

    public static void main(String[] args) {
        try(
                Reader reader = new BufferedReader(new FileReader(SAMPLE_CSV_FILE));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ){
            System.out.println("List of books");
            for(CSVRecord csvRecord : csvParser){
                String title = csvRecord.get(0);
                String author = csvRecord.get(1);
                String id = csvRecord.get(2);
                String pages = csvRecord.get(3);
                System.out.println("--------------------------------");
                System.out.println("Record No - "+csvRecord.getRecordNumber());
                System.out.println("Title : "+title);
                System.out.println("Author : "+author);
                System.out.println("Id : "+id);
                System.out.println("Pages : "+pages);
                System.out.println("--------------------------------\n");
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
