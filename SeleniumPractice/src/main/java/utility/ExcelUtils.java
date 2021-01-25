package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet; // sheet object XSSF+Sheet
    private static XSSFWorkbook ExcelWBook; //excel file object XSSF+Workbook
    private static XSSFCell Cell;  // cell object XSSF+CEll
    private static XSSFRow Row; //Row object XSSF+Row





    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

        String[][] tabArray = null;

        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);  // excel file load
            ExcelWSheet = ExcelWBook.getSheet(SheetName);  // t get sheet name
            int startRow = 1;   int startCol = 1;   //from where to star
            int ci,cj;

            int totalRows = ExcelWSheet.getLastRowNum();
            // you can write a function as well to get Column count

            int totalCols = 2;
            tabArray=new String[totalRows][totalCols];//tabArray[3][2]
            ci=0; // index intlizee

            for (int i=startRow;i<=totalRows;i++, ci++) {
                cj=0;
                for (int j=startCol;j<=totalCols;j++, cj++){
                    tabArray[ci][cj]=getCellData(i,j);
                    System.out.println(tabArray[ci][cj]);
                }
            }
        }

        catch (FileNotFoundException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }

        catch (IOException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return(tabArray);

    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {

        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
                String CellData = Cell.getStringCellValue();
                return CellData;
            }catch (Exception e){
                System.out.println(e.getMessage());

                throw (e);

            }

        }

    }