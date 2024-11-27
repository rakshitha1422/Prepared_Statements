import com.prepared.JdbcPrepared;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner sc=new Scanner(System.in);


        JdbcPrepared jdbc=new JdbcPrepared();
        while (true) {
            System.out.println("Enter operation: ");
            String op = sc.nextLine();

            switch (op.toLowerCase()) {
                case "create":
                    String query = "Create table emp11 (name varchar(20), id int)";
                    boolean res = jdbc.CreateTable(query);
                    if (!res)
                        System.out.println("Table created successfully");
                    else
                        System.out.println("Table creation failed");
                    break;

                case "insert":
                    System.out.println("Enter the employee name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    int rowsAffected = jdbc.insertData(name, id);
                    if (rowsAffected != 0)
                        System.out.println("Data inserted successfully");
                    else
                        System.out.println("Data insertion failed");
                    break;

                case "delete":
                    System.out.println("Enter the employee id  to be deleted: ");
                    int empid=sc.nextInt();
                    sc.nextLine();

                    int raffect = jdbc.deleteData(empid);
                    if (raffect != 0)
                        System.out.println("Data deleted successfully");
                    else
                        System.out.println("Data deletion failed");
                    break;
                case "retreive":
                    jdbc.retrieveData();break;

                case "exit":
                    System.out.println("Exiting the program...");
                    System.exit(0);
                case "update":
                    System.out.println("Enter the name to replace");
                    String uname=sc.nextLine();
                    System.out.println("enter id to update");
                    int uid=sc.nextInt();
                    sc.nextLine();
                    int urowsaffected=jdbc.updatetable(uname,uid);
                    if(urowsaffected!=0) System.out.println("Updated Successfully");
                    else System.out.println("Updation Failed");
                    break;
                default:
                    System.out.println("Enter a valid operation");
            }
        }




    }
}