package readers.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReadWriteAppend {

    @Test
    public void readExcel() throws IOException {
        //okunacak excel dosyasi
        String file = "src/test/resources/datafiles/ExcelA.xlsx";

        // javanin dosyayı okumasi icin
        FileInputStream fileInputStream = new FileInputStream(file);

        // okunan dosya excel sayfası olarak belirlendi APACHE POI
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // okunacak sayfa belirlendi
        Sheet sheet = workbook.getSheetAt(0); //ilk sayfa acilir
//      Sheet sheet = workbook.getSheet("Sheet1");

        // sheet içindeki oluşturulmuş row sayısını verir
        int lastRow = sheet.getPhysicalNumberOfRows();

        // sheet içindeki row okunur
        Row row = sheet.getRow(0);

        int lastCell = row.getPhysicalNumberOfCells();


        // row içindeki cell okunur
        Cell cell = row.getCell(0);
        System.out.println(cell);

        cell = row.getCell(1);
        System.out.println(cell);

        cell = row.getCell(2);
        System.out.println(cell);

        workbook.close();
        fileInputStream.close();


    }

    @Test
    public void writeNewExcelFile() throws IOException {
        //Ram de bir excel workbook dosyası oluşturuldu
        XSSFWorkbook workbook = new XSSFWorkbook();     // xlsx için
//        HSSFWorkbook workbook1 = new HSSFWorkbook();    //xls için

        //workbook'ta bir sheet açıldı
        XSSFSheet sheet = workbook.createSheet("sayfam");

        //Sheet içine ilk yani (index = 0) row oluşturuldu
        Row row = sheet.createRow(0);

        //Row içine ilk (index = 0) cell oluşturuldu
        Cell cell = row.createCell(0);

        //Cell'e deger atandi
        cell.setCellValue("Tiga");

        //oluşturulacak excel dosyasının yolu ve adi, xlsx oalrak
        String file = "src/test/resources/datafiles/ExcelNew.xlsx";

        // olusturulan workbook'un diske java ile yazdirilmasi icin
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //apachePOI ram'de oluşturulan xlsx dosyasını java araciligi ile diske yazdırır.
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

    }

    @Test
    public void writeNewExcelFile1() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Adi");

        cell = row.createCell(1);
        cell.setCellValue(":");

        cell = row.createCell(2);
        cell.setCellValue("Hasan");

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Soyadi");
        row1.createCell(1).setCellValue(":");
        row1.createCell(2).setCellValue("Özyer");

        String file = "src/test/resources/datafiles/ExcelNew.xlsx";

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();


    }


    @Test
    public void addDataToExcelFile() throws IOException {
        String file = "src/test/resources/datafiles/ExcelB.xlsx";

        //javanin dosyayi okuması için
        FileInputStream fileInputStream = new FileInputStream(file);

        //okunan dosya excel sayfasi olarak belirlendi
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("person");
        int lastRow = sheet.getPhysicalNumberOfRows();

        // Son kisma bir satir eklendi
        Row row = sheet.createRow(lastRow);

        // eklenen satira hücreler ve degerleri veriliyor
        row.createCell(0).setCellValue("Hasan");
        row.createCell(1).setCellValue("Özyer");

        // ramdeki workbook'un dosyaya yazdirilmasi için
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // workbook dosyaya yazdirilir
        workbook.write(fileOutputStream);

        //kapatma işlemleri
        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();


    }


}
