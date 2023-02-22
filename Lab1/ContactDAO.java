/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbcone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactDAO {

    private String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/addressbook";
    private String USER = "root";
    private String PASSWORD = "root";
    private boolean conflag = false;
    private Connection con;

    public boolean Connect() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            if (con != null) {
                conflag = true;
                return true;

            }
        } catch (SQLException se) {
            System.out.println("error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<ContactPerson> getContacts() {
        String sql = "Select * from contact";
        List<ContactPerson> list = new ArrayList<>();
        try {
            if (Connect()) {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    ContactPerson p = createContactPerson(rs);
                    list.add(p);
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    private ContactPerson createContactPerson(ResultSet rs) {
        ContactPerson p = new ContactPerson();
        try {
            p.setId(rs.getInt("ID"));
            p.setName(rs.getString("Name"));
            p.setNickName(rs.getString("NickName"));
            p.setAddress(rs.getString("address"));
            p.setHomePhone(rs.getString("home_phone"));
            p.setWorkPhone(rs.getString("work_phone"));
            p.setCellPhone(rs.getString("cell_phone"));
            p.setEmail(rs.getString("email"));
            p.setBD(rs.getDate("birthday"));
            p.setWebSite(rs.getString("web_site"));
            p.setProfession(rs.getString("profession"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    public void Insert(ContactPerson newp) {
        if (Connect()) {
            try {
                String sql = "INSERT INTO contact(id, name, nick_name, address, home_phone, work_phone, cell_phone, email, birthday, web_site, profession) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement newstmt = con.prepareStatement(sql);
                newstmt.setInt(1, newp.getId());
                newstmt.setString(2, newp.getName());
                newstmt.setString(3, newp.getNickName());
                newstmt.setString(4, newp.getAddress());
                newstmt.setString(5, newp.getHomePhone());
                newstmt.setString(6, newp.getWorkPhone());
                newstmt.setString(7, newp.getCellPhone());
                newstmt.setString(8, newp.getEmail());
                newstmt.setDate(9, newp.getBD());
                newstmt.setString(10, newp.getWebsite());
                newstmt.setString(11, newp.getProfession());
                newstmt.execute();

            } catch (SQLException ex) {
                Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void closeConnection() {
        try {
            con.close();
            conflag = false;
        } catch (SQLException ex) {
            Logger.getLogger(ContactDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
