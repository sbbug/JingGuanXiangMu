package GenerateExcel;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class GenExcel1 {
	
    public static void main(String[] args) throws Throwable {
    	
        SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows in memory
       
        Sheet sh = wb.createSheet();
        
        for(int rownum = 0; rownum < 1000; rownum++){
        	
            Row row = sh.createRow(rownum);
            
            for(int cellnum = 0; cellnum < 10; cellnum++){
            	
                Cell cell = row.createCell(cellnum);
                
                String address = new CellReference(cell).formatAsString();
                
                cell.setCellValue(address);
                
            }

           // manually control how rows are flushed to disk 
           if(rownum % 100 == 0) {
                ((SXSSFSheet)sh).flushRows(100); // retain 100 last rows and flush all others

                // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                // this method flushes all rows
           }

        }

        FileOutputStream out = new FileOutputStream("D:/hello.xlsx");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
   }





}
