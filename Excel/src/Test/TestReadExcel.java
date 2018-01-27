package Test;

import java.util.ArrayList;

import GenerateExcel.ReadExcelObject;

public class TestReadExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList> employ_list = null;
		
		employ_list = new ReadExcelObject("D:/2018.xlsx").read_excel_data();
		
		for(int i=0;i<employ_list.size();i++){
			for(int j=0;j<employ_list.get(i).size();j++){
				System.out.print(employ_list.get(i).get(j)+"\t");
			}
			System.out.println("");
		}
		
		
	}

}
