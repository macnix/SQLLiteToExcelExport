package com.company;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    static private ConMySQL baza; /*Создаем объект базы*/

    public static void main(String[] args) {
        baza = new ConMySQL("org.sqlite.JDBC", "jdbc:sqlite:logger.db");

        HSSFWorkbook workbookS = new HSSFWorkbook ();
        HSSFSheet sheetS = workbookS.createSheet("Secret");
        String requestS = "select * from Secret";
        List<DataModelExcel> dataListS = fillData(requestS);
        int rowNumS = 0;

        Row rowS = sheetS.createRow(rowNumS);
        int zS = 0;
        //идет запись имен ВСЕХ колонок, без привязки к реквэсту
       ArrayList<String> colunmNamesS = new ModelMySQLExcel ().getColumnNames();

        for (int i = 0; i < colunmNamesS.size(); i++) {
          rowS.createCell(i).setCellValue(colunmNamesS.get(i));
        }

        // заполняем лист данными
        for (DataModelExcel dataModel : dataListS) {

            createSheetHeaderS(sheetS, ++rowNumS, dataModel);
        }



        // записываем созданный в памяти Excel документ в файл
        try (FileOutputStream out = new FileOutputStream(new File ("Rezult" + Long.toString(System.currentTimeMillis())  + ".xls"))) {

            workbookS.write(out);
            System.out.println("Excel файл успешно создан!");
        } catch (IOException er) {
            er.printStackTrace();
            System.out.println("excel problem printStackTrace");
        }

    }

    private static void createSheetHeaderS(HSSFSheet sheet, int rowNum, DataModelExcel dataModel) {

        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getKEY () );
        row.createCell(1).setCellValue(dataModel.getW () );
        row.createCell(2).setCellValue(dataModel.getTIMELog () );
        row.createCell(3).setCellValue(dataModel.getSTRINGDATA () );
        row.createCell(4).setCellValue(dataModel.getSTRINGTIME () );
        row.createCell(5).setCellValue(dataModel.getOPERADOR () );

    }

    private static List<DataModelExcel> fillData(String query) {
        Vector<Vector<Object>>    dMs = new Vector<Vector<Object>>();

        dMs=baza.getSelect(query);
        List<DataModelExcel> dataModels=new Vector<DataModelExcel>();

    for (Vector<Object> dM : dMs) {


        dataModels.add (new DataModelExcel (

                (Integer) dM.get (0),
                (Double) dM.get (1),
                (Long) dM.get (2),
                (String) dM.get (3),
                (String) dM.get (4),
                (String) dM.get (5)
                )
             );
    }

        return dataModels;
    }
}
