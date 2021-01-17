import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.*;

public class SQL {
    static Connection con;
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Lectures.Tables.Lectures","root","");
        }catch(Exception e){ System.out.println(e);}
        Scanner input= new Scanner(System.in);
        int selection;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lectures.Tables.Lecture", "root", "")) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        while(true)
        {
            System.out.println("*************");
            System.out.println("1.is exist?");
            System.out.println("2.insert");
            System.out.println("3.exit");
            System.out.print("your choice:");
            selection=input.nextInt();

            System.out.println("*************");

            if(selection==1) IsExist("ce303");
            if(selection==2) Add(con);
            if(selection==3) {
                try{
                    con.close();
                }catch(Exception e){ System.out.println(e);}

                break;
            }
            }
        }
    public static boolean IsExist(String cn)
    {
        try{
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Lectures");
            while(rs.next())
                if (rs.getString("course name").equals(cn)){
                    return true;
                }

        }catch(Exception e){ System.out.println(e);}

        return false;
    }

    public static void Add(Connection con)
    {
        String courseName;
        Scanner scan= new Scanner(System.in);
        System.out.print("Course name     :");
        courseName = scan.nextLine();

        try{
           Statement stmt=con.createStatement();
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
            String query=String.format("INSERT INTO Lectures (course name, saved date) VALUES (%s,%s)", courseName,String.format(String.valueOf(startDate)));
            int add = stmt.executeUpdate(query);
            System.out.println("Registration added");
        }catch(Exception e){ e.printStackTrace();}


    }



}
