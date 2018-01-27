package GenerateExcel;
/*
 * 
 * �˴����ȡexcel����Ķ���
 * ���ڲ���excel�ļ�
 */

//����������
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * ��ȡexcel�ļ�����
 * ���������excel�ļ�·��
 *
 */
public class ReadExcelObject {
      
	//��Ҫ��ȡ��excel�ļ�·��
	private String excel_file_path;
	
	//�޲ι��췽��
	public ReadExcelObject(){
		excel_file_path=null;
	}
	
	//�вι��췽��
	public ReadExcelObject(String _file_path){
		this.excel_file_path = _file_path;
	}
	
	public String getExcel_file_path() {
		return excel_file_path;
	}

	public void setExcel_file_path(String excel_file_path) {
		this.excel_file_path = excel_file_path;
	}
    
    //	��ȡexcel�ļ����вι��췽��
	
	public ArrayList<ArrayList> read_excel_data(String excel_file_path){
		
		this.setExcel_file_path(excel_file_path);
		
		 //����һ����ά���ϣ����ڴ������
		ArrayList<ArrayList> data_list=null;
		
		//����һ���ļ�������
		FileInputStream excelFile = null;
		//����������
		Workbook workbook = null;
		
		//ÿһ����¼��ʶ
		int data_line = 0;
		
		//����ʹ��
		System.out.println("===>"+this.excel_file_path);
		try {
			 
			 excelFile = new FileInputStream(new File(this.excel_file_path));
			 
			 workbook = new XSSFWorkbook(excelFile);
			 
			 //��ȡ��һҳ
			 Sheet datatypeSheet = workbook.getSheetAt(0);
			 
			 //��ȡ��һ��
			 Iterator<Row> iterator = datatypeSheet.iterator();
			 
			//data_list����ռ�
			 data_list = new ArrayList<ArrayList>();
			 
			 while (iterator.hasNext()) {
                    
				    //��ȡ��ǰ��
	                Row currentRow = iterator.next();
	                //��ȡһ�����еĵ�Ԫ
	                Iterator<Cell> cellIterator = currentRow.iterator();
                    
	                //��data_list�����һ��
	                
	                data_list.add(new ArrayList<String>());
	                
	                while (cellIterator.hasNext()) {

	               
	                    Cell cell = cellIterator.next();
	                    
	                    //���������ж����
						switch (cell.getCellType()) 
						{ 
						    case Cell.CELL_TYPE_STRING: 
//						    	System.out.print(cell.getStringCellValue() + "\t"); 
						    	data_list.get(data_line).add(cell.getStringCellValue());
						    	break; 
							case Cell.CELL_TYPE_NUMERIC: 
//								System.out.print(cell.getNumericCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_BOOLEAN: 
//								System.out.print(cell.getBooleanCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getBooleanCellValue());
								break; 
							default : 
						} 

	                }
	                data_line++;
//	                System.out.println("");

	            }
			 	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data_list;
		
		
	}
	
	//��ȡexcel�ļ����޲ι��췽��
	public ArrayList<ArrayList> read_excel_data(){
		
		
        //����һ����ά���ϣ����ڴ������
		ArrayList<ArrayList> data_list=null;
		
		//����һ���ļ�������
		FileInputStream excelFile = null;
		//����������
		Workbook workbook = null;
		
		//ÿһ����¼��ʶ
		int data_line = 0;
		
		//����ʹ��
		System.out.println("===>"+this.excel_file_path);
		try {
			 
			 excelFile = new FileInputStream(new File(this.excel_file_path));
			 
			 workbook = new XSSFWorkbook(excelFile);
			 
			 //��ȡ��һҳ
			 Sheet datatypeSheet = workbook.getSheetAt(0);
			 
			 //��ȡ��һ��
			 Iterator<Row> iterator = datatypeSheet.iterator();
			 
			//data_list����ռ�
			 data_list = new ArrayList<ArrayList>();
			 
			 while (iterator.hasNext()) {
                    
				    //��ȡ��ǰ��
	                Row currentRow = iterator.next();
	                //��ȡһ�����еĵ�Ԫ
	                Iterator<Cell> cellIterator = currentRow.iterator();
                    
	                //��data_list�����һ��
	                
	                data_list.add(new ArrayList<String>());
	                
	                while (cellIterator.hasNext()) {

	               
	                    Cell cell = cellIterator.next();
	                    
	                    //���������ж����
						switch (cell.getCellType()) 
						{ 
						    case Cell.CELL_TYPE_STRING: 
//						    	System.out.print(cell.getStringCellValue() + "\t"); 
						    	data_list.get(data_line).add(cell.getStringCellValue());
						    	break; 
							case Cell.CELL_TYPE_NUMERIC: 
//								System.out.print(cell.getNumericCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getNumericCellValue());
								break;
							case Cell.CELL_TYPE_BOOLEAN: 
//								System.out.print(cell.getBooleanCellValue() + "\t"); 
								data_list.get(data_line).add(cell.getBooleanCellValue());
								break; 
							default : 
						} 

	                }
	                data_line++;
//	               System.out.println("");

	            }
			 	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
		
		return data_list;
	}
	
	 
	
}
