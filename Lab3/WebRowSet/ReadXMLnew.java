/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webrowset;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

/**
 *
 * @author DELL
 */
public class ReadXMLnew {

    public static void main(String[] args) {
        try {
            System.out.println("ReadXML File..");
            WebRowSet rowset = RowSetProvider.newFactory().createWebRowSet();
            FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Documents\\NetBeansProjects\\WebRowSet\\src\\webrowset\\fos.xml");
            rowset.readXml(fis);
             while (rowset.next()) {
                System.out.println("id: " + rowset.getInt("id"));
                System.out.println("Name: " + rowset.getString("name"));
                System.out.println("NickName: " + rowset.getString("nick_name"));
                System.out.println("Address: " + rowset.getString("address"));
                System.out.println("HomePhone: " + rowset.getString("home_phone"));
                System.out.println("CellPhone: " + rowset.getString("cell_phone"));
                System.out.println("WorkPhone: " + rowset.getString("work_phone"));
                System.out.println("Email: " + rowset.getString("email"));
                System.out.println("Birthday: " + rowset.getDate("birthday"));
                System.out.println("Website: " + rowset.getString("web_site"));
                System.out.println("Profession: " + rowset.getString("profession"));
                System.out.println("\t");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
