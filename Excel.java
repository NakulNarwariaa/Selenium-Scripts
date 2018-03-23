package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {


	public void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
  //      Excel e=new Excel();
		FileInputStream fis = new FileInputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		int rc=s.getLastRowNum();
		System.out.println("Last row number = " +rc);
		for(int i=1;i<=rc;i++)
		{
			s.getRow(i).createCell(3).setCellValue(0);
			s.getRow(i).createCell(4).setCellValue(0);
			s.getRow(i).createCell(5).setCellValue(0);
		}
		FileOutputStream fos=new FileOutputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		wb.write(fos);

        
	}

	public void pass(int row) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c= r.getCell(3);
		int v =(int) c.getNumericCellValue();
		System.out.println(v);
		int WriteThisValue=v+1;
		s.getRow(row).createCell(3).setCellValue(WriteThisValue);
		FileOutputStream fos=new FileOutputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		wb.write(fos);
	}
	
	public void fail(int row) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c= r.getCell(4);
		int v =(int) c.getNumericCellValue();
		System.out.println(v);
		int WriteThisValue=v+1;
		s.getRow(row).createCell(4).setCellValue(WriteThisValue);
		FileOutputStream fos=new FileOutputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		wb.write(fos);
	}
	
	public void notExecuted(int row) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c= r.getCell(5);
		int v =(int) c.getNumericCellValue();
		System.out.println(v);
		int WriteThisValue=v+1;
		s.getRow(row).createCell(5).setCellValue(WriteThisValue);
		FileOutputStream fos=new FileOutputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		wb.write(fos);
	}

	
	public void timeTaken(int row, long tt) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		
		
		FileInputStream fis = new FileInputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet("Sheet1");
		s.getRow(row).createCell(6).setCellValue(tt);
		FileOutputStream fos=new FileOutputStream("C://Users/Dinesh B M/Desktop/AutomationTestReportForLauncher.xlsx");
		wb.write(fos);
		
	}
}
