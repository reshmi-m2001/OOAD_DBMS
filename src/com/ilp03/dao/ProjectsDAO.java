package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.Statement;

import com.ilp03.entity.Clients;
import com.ilp03.entity.Employees;
import com.ilp03.entity.Projects;

public class ProjectsDAO {
	public  static Connection getConnection()
	{
		String connectionString="jdbc:mysql://localhost:3306/billingsystem_db?useSSL=false";
		String userName="root";
		String password ="Santhi@2001";
		Connection connection =null;
		try {
			connection=DriverManager.getConnection(connectionString,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return connection;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	public static ArrayList<Projects> getProjectDetails(Connection connection ){
	
	
	
	PreparedStatement preparedStatement;
	ArrayList<Projects>projectList=new ArrayList<Projects>();
    try {
        

        
        Statement statement1 = connection.createStatement();
        ResultSet resultSet1 = statement1.executeQuery("select p.project_name as projectName,c.client_name as clientName,e1.first_name as createdByName, e2.first_name as updatedByName,p.created_date as createdDate,p.updated_date as updatedDate,p.description,p.total_amount AS totalAmount from projects p join employees e1 on p.created_by = e1.emp_no join employees e2 on p.updated_by = e2.emp_no join clients c on p.client_id = c.client_id;");
        while(resultSet1.next()) {
        	String projectName1 =resultSet1.getString(1);
        	String clientName =resultSet1.getString(2);
        	String firstName =resultSet1.getString(3);
        	String firstName1=resultSet1.getString(4);
        	Date createdDate =resultSet1.getDate(5);
        	Date updatedDate =resultSet1.getDate(6);
        	String description =resultSet1.getString(7);
        	double totalAmount=resultSet1.getDouble(8);
        	
        	Clients clients =new Clients(0, clientName, null, 0);
        	Employees employees=new Employees(0, null, firstName, null, null, null, 0);
        	Employees employees1 =new Employees(0, null, firstName1, null, null, null, 0);
        	Projects projects=new Projects(0, projectName1, clients,employees, employees1, createdDate, updatedDate, description, totalAmount);
        	projectList.add(projects);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return projectList; 
}
	
       

        public static ArrayList<Projects> getProjectBalanceamount(Connection connection, String projectName ){
        ArrayList<Projects> projectList1 = new ArrayList<Projects>();
        try {
        String query2 = "select p.project_name,p.total_amount as total_project_budget,sum(te.hours_worked*e.hourly_rate) as total_spent,(p.total_amount-sum(te.hours_worked*e.hourly_rate)) as balance_remaining from projects p join time_entries te on p.project_id=te.project_id join employees e on te.emp_no=e.emp_no where p.project_name = ? group by p.project_id;;";
        PreparedStatement statement2 = connection.prepareStatement(query2);
        statement2.setString(1, projectName);
        ResultSet resultSet2 = statement2.executeQuery();
        while(resultSet2.next()) {
        String projectName1 =resultSet2.getString(1);
        double totalAmount=resultSet2.getDouble(2);
        double spentAmount=resultSet2.getDouble(3);
        double balanceAmount=resultSet2.getDouble(4);
        Projects projects = new Projects(0, projectName1, totalAmount,spentAmount, balanceAmount);
        projectList1.add(projects);
        }
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
		return projectList1; 
        

}
        
    }




