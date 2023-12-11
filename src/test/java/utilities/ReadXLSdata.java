package utilities;
//import testcases.MyFirstTestFW;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

//import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import org.apache.poi.EncryptedDocumentException;

public class ReadXLSdata{
	
	@DataProvider(name = "bvtdata")
	public String[][] getData() throws EncryptedDocumentException, IOException {
		String excelSheetName = "login";
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");	// storing excel sheet file directory in f object 
		System.out.println("f: " + f);	
		FileInputStream fis = new FileInputStream(f);	//  FileInputStream is meant for reading streams of raw bytes such as image data.
		System.out.println("fis: " + fis);
		Workbook wb = WorkbookFactory.create(fis);		// represents the entire collection of sheets.
		System.out.println("wb: " + wb);
		Sheet sheetName = wb.getSheet(excelSheetName);	// which is represented as a grid of cells.
		System.out.println("sheetName: " + sheetName);

		int totalRows = sheetName.getLastRowNum();
		System.out.println("totalRows: " + totalRows);
		Row rowCells = sheetName.getRow(0);
		System.out.println("rowCells: " + rowCells);
		int totalCols = rowCells.getLastCellNum();
		System.out.println("totalCols: " + totalCols);

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
//				System.out.println("i: " + i);
//				System.out.println("j: " + j);
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}
		}
		System.out.println("testData: " + testData);

		return testData;
	}

}