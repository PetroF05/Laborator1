package md.usm.lab1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReaderOpenCsv {
    public static void main(String[] args) {
        CSVReader csvReader = null;
        try{
            csvReader = new CSVReader(new FileReader("books.csv"));
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null){
                for(String token : nextLine){
                    System.out.println(token);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                csvReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
