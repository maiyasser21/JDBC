package jdbcone;

import java.sql.Date;

public class ContactPerson
{
   private int id;
    private String Name;
    private String NickName;
    private String Address;
    private String HomePhone;
    private String WorkPhone;
    private String CellPhone;
    private String Email;
    private Date Birthday;
    private String WebSite;
    private String Profession;
    
    public void setId(int id)
    {
        this.id=id;
    }
    public void setName(String name)
    {
        this.Name=name;
    }
     public void setNickName(String nickname)
    {
        this.NickName=nickname;
    }
    public void setEmail(String email)
    {
        this.Email=email;
    }
    public void setHomePhone(String hp)
    {
        this.HomePhone=hp;
    }
    public void setWorkPhone(String wp)
    {
        this.WorkPhone=wp;
    }
    public void setCellPhone(String cp)
    {
        this.CellPhone=cp;
    }
    public void setBD(Date bd)
    {
        this.Birthday=bd;
    }
    public void setProfession(String prof)
    {
        this.Profession=prof;
    }
    public void setWebSite(String ws)
    {
        this.WebSite=ws;
    }
    public void setAddress(String ad)
    {
        this.Address=ad;
    }
    ////////////////////////////////
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return Name;
    }
    public String getNickName()
    {
        return NickName;
    }
    public String getHomePhone()
    {
        return HomePhone;
    }
     public String getWorkPhone()
    {
        return WorkPhone;
    }
      public String getCellPhone()
    {
        return CellPhone;
    }
    public String getEmail()
    {
        return Email;
    }
    public String getWebsite()
    {
        return WebSite;
    }
    public Date getBD()
    {
        return Birthday;
    }
     public String getAddress()
    {
        return Address;
    }
      public String getProfession()
    {
        return Profession;
    }
}