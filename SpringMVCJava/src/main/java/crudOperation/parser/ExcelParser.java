package crudOperation.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import crudOperation.user.User;

public class ExcelParser {

	public List<User> parse() throws IOException {

		List<User> users = new ArrayList<User>();

		String dir = "c://users//Nirmit Kumar//workspace//SpringMVCJava//temp//";
		String temp = "";
		File[] file = new File(dir).listFiles();

		for (File f : file) {
			if (f.isFile()) {
				temp = f.getName();
			}
		}

		dir = dir + temp;
		System.out.println(dir);
		// System.out.println("ni");
		
		File file2 = new File(dir);
		System.out.println(file2.toString());
		// System.out.println("nirmit");
		FileInputStream fileInputStream = new FileInputStream(file2);

		System.out.println(fileInputStream.toString());

		String ext = temp.substring(temp.lastIndexOf('.') + 1);
		HSSFWorkbook hssfWorkbook;
		HSSFSheet hssfSheet;
		XSSFWorkbook xssfWorkbook;
		XSSFSheet xssfSheet;
		Iterator<Row> row;
		if (ext.compareTo("xls") == 0) {
			hssfWorkbook = new HSSFWorkbook(fileInputStream);
			hssfSheet = hssfWorkbook.getSheetAt(0);
			row = hssfSheet.iterator();
		} else {
			xssfWorkbook = new XSSFWorkbook(fileInputStream);
			xssfSheet = xssfWorkbook.getSheetAt(0);
			row = xssfSheet.iterator();

		}

		int flag = 0;
		while (row.hasNext()) {
			Row r = row.next();
			User user = new User();
			Iterator<Cell> celliterator = r.iterator();
			//while (celliterator.hasNext()) {

				if (flag == 0) {

					celliterator.next();
					celliterator.next();
					celliterator.next();
					celliterator.next();

				} else {

					
					user.setUsername(celliterator.next().getStringCellValue());
					user.setEmail(celliterator.next().getStringCellValue());
					user.setAge(""+(int)celliterator.next().getNumericCellValue());
					user.setPhone(""+(long)celliterator.next().getNumericCellValue());
					users.add(user);

				}
			//}

			flag = 1;
			
		}

		System.out.println(users);
		boolean result=file2.delete();
		if(result)
		{
			System.out.println("true");
		}
		else
			System.out.println("false");
		return users;
	}
}
