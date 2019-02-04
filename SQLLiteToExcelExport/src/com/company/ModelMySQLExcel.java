package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author dubetskyi_ov on 04.02.2019
 */

public class ModelMySQLExcel  extends AbstractTableModel {

    //Имена колонок;
    protected Vector<String> columnNames;
    //Данные;
    private Vector<Vector<Object>> tableData;
    //Классы колонок;
    protected Vector<Object> vColClass;

    public ArrayList<String> getColumnNames() {
        ArrayList<String> list = new ArrayList<String>(columnNames);
        return list;
    }

    public ModelMySQLExcel()
    {
        super();
        vColClass = new Vector<Object>();
        vColClass.add(0, Integer.class);
        vColClass.add(1, Double.class);
        vColClass.add(2, Long.class);
        vColClass.add(3, String.class);
        vColClass.add(4, String.class);
        vColClass.add(5, String.class);


        columnNames = new Vector<String>();
        columnNames.add("KEY");
        columnNames.add("Weigt");
        columnNames.add("TIMELog");
        columnNames.add("STRINGDATA");
        columnNames.add("STRINGTIME");
        columnNames.add("OPERADOR");

    }


    @Override
    public int getRowCount() {
        return getTableData().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public void setValueAt(Object obj, int row, int column)
    {
        if(column == 0)
        {
            (getTableData().get(row)).set(column, (Integer)obj);
        }
        else if(column == 1)
        {
            (getTableData().get(row)).set(column, (String)obj);
        }
        fireTableCellUpdated(row, column);
    }

    @Override
    public Class<?> getColumnClass(int col)
    {
        Class<?> c = Object.class;
        try
        {
            c = (Class<?>)vColClass.get(col);
        } catch (RuntimeException e)
        {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void setTableData(Vector<Vector<Object>> tableData)
    {
        this.tableData = tableData;
    }

    public Vector<Vector<Object>> getTableData()
    {
        return tableData;
    }
}
