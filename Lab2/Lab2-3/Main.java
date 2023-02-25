package jdbcone;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        ContactDAO c1 = new ContactDAO();
        System.out.println("DB!");
        try{
        c1.Connect();
        }catch(SQLException s)
        {
            System.out.println(s.getMessage());
        }
      //c1.Update();
 //c1.DeletefromTable();
            
//        ContactPerson p=new ContactPerson();
//        
//        p.setId(19);
//        p.setName("Mai");
//        p.setNickName("dude");
//        p.setAddress("NasrCity");
//        p.setHomePhone("4568788");
//        p.setCellPhone("890");
//        p.setWorkPhone("0098799");
//        p.setEmail("ibrahim@gmail.com");
//        p.setWebSite("dude.com");
//        p.setProfession("suffering..");
//        
//        c1.Insert(p);

c1.testBatch();

        c1.Select().forEach((s)->{
        System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getEmail());
        });

      
     c1.closeConnection();
     
    }
}
