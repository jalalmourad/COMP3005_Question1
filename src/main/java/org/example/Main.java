package org.example;

import java.sql.*;

public class Main {


    public void getAllStudents(){

        String url = "jdbc:postgresql://localhost:5432/Question1";
        String user = "postgres";
        String password = "postgres";

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);

            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                System.out.print(resultSet.getInt("student_id")+ "\t");
                System.out.print(resultSet.getString("first_name")+ "\t");
                System.out.print(resultSet.getString("last_name")+ "\t");
                System.out.print(resultSet.getString("email")+ "\t");
                System.out.println(resultSet.getString("enrollment_date"));
            }
        }
        catch(Exception e){
        }
    }
    public void addStudent(int student_id,String first_name,String last_name,String email, String enrollment_date ){

        String url = "jdbc:postgresql://localhost:5432/Question1";
        String user = "postgres";
        String password = "postgres";

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);

            String insert = "INSERT INTO students(student_id,first_name,last_name,email,enrollment_date) VALUES(?,?,?,?,?)";
            try(PreparedStatement prepare = connection.prepareStatement(insert)){
            prepare.setInt(1,student_id);
            prepare.setString(2,first_name);
            prepare.setString(3,last_name);
            prepare.setString(4,email);
            prepare.setDate(5, Date.valueOf(enrollment_date));
            prepare.executeUpdate();
            System.out.println("Data is inserted/n");
            }


        }
        catch(Exception e){
        }
    }
    public void updateStudentEmail(int student_id,String email){

        String url = "jdbc:postgresql://localhost:5432/Question1";
        String user = "postgres";
        String password = "postgres";

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);

            String insert = "UPDATE students SET email = ? WHERE student_id = ?";
            try(PreparedStatement prepare = connection.prepareStatement(insert)){
                prepare.setString(1,email);
                prepare.setInt(2,student_id);

                prepare.executeUpdate();
                System.out.println("Data is updated/n");
            }


        }
        catch(Exception e){
        }
    }

    public void deleteStudent(int student_id){

        String url = "jdbc:postgresql://localhost:5432/Question1";
        String user = "postgres";
        String password = "postgres";

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);

            String insert = "DELETE FROM students WHERE student_id = ?";
            try(PreparedStatement prepare = connection.prepareStatement(insert)){
                prepare.setInt(1,student_id);

                prepare.executeUpdate();
                System.out.println("Data is Deleted/n");
            }


        }
        catch(Exception e){
        }
    }


    public static void main(String[] args) {

       Main main = new Main();
      // main.getAllStudents();
       //main.addStudent(6,"Alex","M","Alex@email.com","2023-10-01");
        //main.updateStudentEmail(2,"test@test.com");
        main.deleteStudent(6);
       main.getAllStudents();
    }
}