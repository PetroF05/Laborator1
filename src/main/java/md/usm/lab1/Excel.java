package md.usm.lab1;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel {
    public static void main(String[] args) {
        HSSFWorkbook workbook = new HSSFWorkbook();

        //create first sheet
        HSSFSheet sheet = workbook.createSheet("Development - 1");

        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);

        HSSFRow row1 = sheet.createRow(0);

        HSSFCell cell1 = row1.createCell(0);
        cell1.setCellValue("Employee id");
        cell1.setCellStyle(style);

        HSSFCell cell2 = row1.createCell(1);
        cell2.setCellValue("Last name");
        cell2.setCellStyle(style);

        HSSFCell cell3 = row1.createCell(2);
        cell3.setCellValue("First name");
        cell3.setCellStyle(style);

        HSSFCell cell4 = row1.createCell(3);
        cell4.setCellValue("Birth date");
        cell4.setCellStyle(style);

        HSSFCell cell5 = row1.createCell(4);
        cell5.setCellValue("Position");
        cell5.setCellStyle(style);

        HSSFCell cell7 = row1.createCell(5);
        cell7.setCellValue("Skills");
        cell7.setCellStyle(style);

        HSSFCell cell8 = row1.createCell(6);
        cell8.setCellValue("Manager id");
        cell8.setCellStyle(style);

        HSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("001");
        row2.createCell(1).setCellValue("Cornelis");
        row2.createCell(2).setCellValue("Willem");
        row2.createCell(3).setCellValue("01.01.1990");
        row2.createCell(4).setCellValue("Department Manager");
        HSSFCell cell25 = row2.createCell(5);
        List<String> listItems = new ArrayList<>();
        listItems.add("Communication");
        listItems.add("Java");
        numberedListInCell(workbook, listItems, cell25, 1, 1);
        row2.createCell(6).setCellValue("0");

        HSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("002");
        row3.createCell(1).setCellValue("Adelung");
        row3.createCell(2).setCellValue("Friedrich Von");
        row3.createCell(3).setCellValue("04.12.1988");
        row3.createCell(4).setCellValue("Developer");
        HSSFCell cell35 = row3.createCell(5);
        List<String> listItems2 = new ArrayList<>();
        listItems2.add("C#");
        listItems2.add("Html");
        listItems2.add("C++");
        numberedListInCell(workbook, listItems2, cell35, 1, 1);
        row3.createCell(6).setCellValue("001");

        //create second sheet
        HSSFSheet sheet2 = workbook.createSheet("Accounting - 2");
        HSSFRow row4 = sheet2.createRow(0);

        HSSFCell cell12 = row4.createCell(0);
        cell12.setCellValue("Employee id");
        cell12.setCellStyle(style);

        HSSFCell cell22 = row4.createCell(1);
        cell22.setCellValue("Last name");
        cell22.setCellStyle(style);

        HSSFCell cell32 = row4.createCell(2);
        cell32.setCellValue("First name");
        cell32.setCellStyle(style);

        HSSFCell cell42 = row4.createCell(3);
        cell42.setCellValue("Birth date");
        cell42.setCellStyle(style);

        HSSFCell cell52 = row4.createCell(4);
        cell52.setCellValue("Position");
        cell52.setCellStyle(style);

        HSSFCell cell72 = row4.createCell(5);
        cell72.setCellValue("Skills");
        cell72.setCellStyle(style);

        HSSFCell cell82 = row4.createCell(6);
        cell82.setCellValue("Manager id");
        cell82.setCellStyle(style);

        HSSFRow row5 = sheet2.createRow(1);
        row5.createCell(0).setCellValue("003");
        row5.createCell(1).setCellValue("Bernhart");
        row5.createCell(2).setCellValue("Johann");
        row5.createCell(3).setCellValue("01.09.1980");
        row5.createCell(4).setCellValue("Department Manager");
        HSSFCell cell45 = row5.createCell(5);
        List<String> listItems3 = new ArrayList<>();
        listItems3.add("Communication");
        listItems3.add("Java");
        listItems3.add("Management");
        numberedListInCell(workbook, listItems3, cell45, 1, 1);
        row5.createCell(6).setCellValue("0");

        HSSFRow row6 = sheet2.createRow(2);
        row6.createCell(0).setCellValue("004");
        row6.createCell(1).setCellValue("Balabin");
        row6.createCell(2).setCellValue("Victor");
        row6.createCell(3).setCellValue("01.01.1995");
        row6.createCell(4).setCellValue("Database administrator");
        HSSFCell cell55 = row6.createCell(5);
        List<String> listItems4 = new ArrayList<>();
        listItems4.add("SQL");
        listItems4.add("JAVA");
        listItems4.add("PHP");
        numberedListInCell(workbook, listItems4, cell55, 1, 1);
        row6.createCell(6).setCellValue("003");

        try(OutputStream fileout = new FileOutputStream("departments.xlsx")){
            workbook.write(fileout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void numberedListInCell(HSSFWorkbook workbook,
                                          List<String> listItems,
                                          HSSFCell cell,
                                          int startingValue,
                                          int increment) {
        StringBuilder buffer = new StringBuilder();
        int itemNumber = startingValue;
        // Note that again, an HSSFCellStye object is required and that
        // it's wrap text property should be set to 'true'
        HSSFCellStyle wrapStyle = workbook.createCellStyle();
        wrapStyle.setWrapText(true);
        // Note that the basic method is identical to the listInCell() method
        // with one difference; a number prefixed to the items text.
        for(String listItem : listItems) {
            buffer.append(itemNumber).append(". ");
            buffer.append(listItem);
            buffer.append("\n");
            itemNumber += increment;
        }
        // The StringBuilder's contents are the source for the contents
        // of the cell.
        cell.setCellValue(new HSSFRichTextString(buffer.toString().trim()));
        cell.setCellStyle(wrapStyle);
    }
}
