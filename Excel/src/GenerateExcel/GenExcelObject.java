package GenerateExcel;
/*excel���ɵĵ��ඨ��
 * 
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class GenExcelObject {
	
	//����Excel�ļ���·�����ɵ�����ָ��
	private String excel_file_path;
	//�����ߴ���Excel����ֶ�
	private ArrayList<String> data_field;
	//�����ߴ��������б���
	private ArrayList<ArrayList> data_list;
	//�޲ι��췽��
	public GenExcelObject() {	
		this.excel_file_path=null;
		this.data_field =null;
		this.data_list=null;
	}
	
	//�вι��췽��
	public GenExcelObject(String _file_path,ArrayList<String> _field, ArrayList<ArrayList> _list) {	
		this.excel_file_path=_file_path;
		this.data_field = _field;
		this.data_list=_list;			
	}
	//���û�ȡ�������Եķ���
	public String getExcel_file_path() {
		return excel_file_path;
	}

	public void setExcel_file_path(String excel_file_path) {
		this.excel_file_path = excel_file_path;
	}

	public Object getData_list() {
		return data_list;
	}

	public void setData_list(ArrayList<ArrayList> data_list) {
		this.data_list = data_list;
	}
	//ִ������excel�ļ�,�޲����
	public void generate_excel_file() {
		
		HSSFRow row=null;
		//����һ������excel�ļ�����
		HSSFWorkbook workbook = new HSSFWorkbook();
        //����excel����һ��ҳ
		HSSFSheet sheet = workbook.createSheet("FirstSheet");
        //����excel���һҳ�е�һ��
        HSSFRow rowhead = sheet.createRow((short)0);
        //��ʼ�����ֶ���
        for( int i=0 ; i<data_field.size() ; i++ ) 
        	rowhead.createCell(i).setCellValue(data_field.get(i));
        
        //��ArrayList�������������ӵ�Excel��
        for(int j=0 ; j<data_list.size() ; j++) {
        	
        	row = sheet.createRow((short)(j+1));
        	
        	for(int k=0 ; k<data_list.get(j).size() ; k++) {
        		 
        		row.createCell(k).setCellValue(String.valueOf(data_list.get(j).get(k)));
        		System.out.println(data_list.get(j).get(k));
        		
                 
        	}
        	System.out.println("");
        }
        //����һ���ļ������
            FileOutputStream fileOut=null;
		
			try {
				fileOut = new FileOutputStream(this.excel_file_path);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				workbook.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Your excel file has been generated!");
					   	
	}
	//ִ������excel�ļ����в����
    public void generate_excel_file(String _file_path,ArrayList<String> _fields,ArrayList<ArrayList> _list) {
    	
    	this.setExcel_file_path(_file_path);
    	this.setData_colums(_fields);
    	this.setData_list(_list);
    	
    	HSSFRow row=null;
		//����һ������excel�ļ�����
		HSSFWorkbook workbook = new HSSFWorkbook();
        //����excel����һ��ҳ
		HSSFSheet sheet = workbook.createSheet("FirstSheet");
        //����excel���һҳ�е�һ��
        HSSFRow rowhead = sheet.createRow((short)0);
        //��ʼ�����ֶ���
        for( int i=0 ; i<data_field.size() ; i++ ) 
        	rowhead.createCell(i).setCellValue(data_field.get(i));
        
        //��ArrayList�������������ӵ�Excel��
        for(int j=0 ; j<data_list.size() ; j++) {
        	
        	row = sheet.createRow((short)(j+1));
        	
        	for(int k=0 ; k<data_list.get(j).size() ; k++) {
        		 
        		row.createCell(k).setCellValue(String.valueOf(data_list.get(j).get(k)));
        		System.out.println(data_list.get(j).get(k));
        		
                 
        	}
        	System.out.println("");
        }
        //����һ���ļ������
            FileOutputStream fileOut=null;
		
			try {
				fileOut = new FileOutputStream(this.excel_file_path);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				workbook.write(fileOut);
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("Your excel file has been generated!");
					   
    	
    }

	public ArrayList<String> getData_colums() {
		return data_field;
	}

	public void setData_colums(ArrayList<String> _field) {
		this.data_field = _field;
	}
	
	
}
