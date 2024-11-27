package com.prepared;

import java.sql.*;

public class JdbcPrepared {
    static String url="";
    static Connection con=null;
    static PreparedStatement pst = null;
    static Statement st=null;
    static {
        try{
            url="jdbc:sqlserver://HRUTHIC;databaseName=jdbcprac;encrypt=true;trustServerCertificate=true;IntegratedSecurity=true";

            con= DriverManager.getConnection(url);


            if(con==null){
                System.out.println("connection failed");
            }
            else{
                System.out.println("Connection Successfull");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public boolean CreateTable(String query){
        boolean iscreate=false;
        try{
            st=con.createStatement();
            //String sql="Create table emp1 (name varchar(20),id int)";
            iscreate=st.execute(query);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return iscreate;
    }

    public int insertData(String name,int id){

        int reffected=0;
        try {
            String query="insert into emp11 (name, id) VALUES (?,?)";
            pst=con.prepareStatement(query);
            pst.setString(1,name);
            pst.setInt(2,id);
            reffected= pst.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

        return reffected;
    }

    public int deleteData(int id){
        int reffected=0;
        try {
            String query="DELETE FROM emp11 WHERE id = ?" ;
            pst=con.prepareStatement(query);
            pst.setInt(1,id);
            reffected= pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return reffected;
    }

    public void retrieveData(){
        try{
            this.st=con.createStatement();
            String query="select * from emp11";
            ResultSet rs=st.executeQuery(query);

            while(rs.next()){
                System.out.println(rs.getString("name")+" "+rs.getInt("id"));
            }


        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public int updatetable(String name,int id)  {
        int reffected=0;
        try
        {
            String query="update emp11 set name=? where id=?";
            pst=con.prepareStatement(query);
            pst.setString(1,name);
            pst.setInt(2,id);
            reffected= pst.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return reffected;

    }
}
