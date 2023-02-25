/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webrowset;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author DELL
 */
public class NewWebRowSet {

    public void connect() {
        Properties props = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("C:\\Users\\DELL\\Documents\\NetBeansProjects\\WebRowSet\\src\\webrowset\\newproperties.properties");
            props.load(fis);
            WebRowSet rowset = RowSetProvider.newFactory().createWebRowSet();
            rowset.setUrl(props.getProperty("MYSQL_URL"));
            rowset.setUsername(props.getProperty("USER"));
            rowset.setPassword(props.getProperty("PASSWORD"));
            rowset.setCommand("SELECT * FROM contact");
            rowset.execute();
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
            FileOutputStream fos= new FileOutputStream("C:\\Users\\DELL\\Documents\\NetBeansProjects\\WebRowSet\\src\\webrowset\\fos.xml");
            rowset.writeXml(fos);
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    public static void main(String[] args) {
////        
////        NewWebRowSet wrs=new NewWebRowSet();
////        wrs.connect();
////        
//        
//    }

}
