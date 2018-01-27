package GenerateExcel;

//Find jar from here "http://poi.apache.org/download.html"
import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;

public class GenExcel2{
	
  public static void main(String[]args) {
	  
      try {
    	  
          String filename = "D:/NewExcelFile.xls" ;
          
          HSSFWorkbook workbook = new HSSFWorkbook();
          
          HSSFSheet sheet = workbook.createSheet("FirstSheet");  
          
          HSSFRow rowhead = sheet.createRow((short)0);
          rowhead.createCell(0).setCellValue("No.");
          rowhead.createCell(1).setCellValue("Name");
          rowhead.createCell(2).setCellValue("Address");
          rowhead.createCell(3).setCellValue("Email");

          HSSFRow row = sheet.createRow((short)1);
          row.createCell(0).setCellValue("1");
          row.createCell(1).setCellValue("Sankumarsingh");
          row.createCell(2).setCellValue("India");
          row.createCell(3).setCellValue("sankumarsingh@gmail.com");
          
          HSSFRow row1 = sheet.createRow((short)2);
          row1.createCell(0).setCellValue("2");
          row1.createCell(1).setCellValue("Mike");
          row1.createCell(2).setCellValue("China");
          row1.createCell(3).setCellValue("1103009779@qq.com");

          FileOutputStream fileOut = new FileOutputStream(filename);
          workbook.write(fileOut);
          fileOut.close();
          System.out.println("Your excel file has been generated!");

      } catch ( Exception ex ) {
          System.out.println(ex);
      }
  }
  
}





