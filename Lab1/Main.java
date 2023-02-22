package jdbcone;
 import java.sql.*;

public class Main{
    public static void main(String[] args) {
        ContactPerson p=new ContactPerson();
        
        p.setId(1);
        p.setName("peter parker");
        p.setNickName("spiderman");
        p.setAddress("newwork");
        p.setHomePhone("01111");
        p.setCellPhone("333");
        p.setWorkPhone("spidey");
        p.setEmail("spidey@gmail.com");
        p.setWebSite("spidey.com");
        p.setProfession("spider man");
        
        ContactDAO testDB=new ContactDAO();
        
        testDB.Insert(p);
        testDB.getContacts().forEach((s)->{
        System.out.println(s.getId()+""+s.getName()+""+s.getProfession());
        });
        
        testDB.closeConnection();
        
    }
}
