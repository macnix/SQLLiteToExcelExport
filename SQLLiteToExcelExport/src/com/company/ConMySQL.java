package com.company;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * @author dubetskyi_ov on 04.02.2019
 */

public class ConMySQL {
    private Connection con = null;
    int key1;
    Date date = new Date();

    public ConMySQL(String driver, String url) {

        key1=0;

        try
        {
            Class.forName(driver);/*загружаем статическим методом forName дравер для базы данных.*/
            con = DriverManager.getConnection(url);

        } catch (ClassNotFoundException ex)
        {
            System.err.println("conMySQL.Cannot find this db driver classes.");
            ex.printStackTrace();
            System.out.println("!1");
        } catch (SQLException e)
        {
            System.err.println("conMySQL.Cannot connect to this db.");
            e.printStackTrace();
            System.out.println("!2");
        }

    }
    public Vector<Vector<Object>> getSelect(String query)/*Метод возвращающий информацию избазы данных*/ {

        Vector<Vector<Object>> retVector = new Vector<Vector<Object>>();

        try {
            Statement st = con.createStatement();/*поле для обращения к базе данных с запросом*/


            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            while (rs.next())
            {
                Vector<Object> newRow = new Vector<Object>();
                for (int i = 1; i <= cols; i++)
                {
                    newRow.add(rs.getObject(i));
                }
                retVector.add(newRow);
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.err.println("conMySQL.There are problems with the query " + query);
            e.printStackTrace();
            System.out.println("!3");
        }


        return retVector;
    }


}
