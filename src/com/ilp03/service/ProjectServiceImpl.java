package com.ilp03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.ProjectsDAO;

import com.ilp03.entity.Projects;

public class ProjectServiceImpl implements ProjectService {

	public void getProjectDetails() {
		
		Connection connection = ProjectsDAO.getConnection();
		ArrayList<Projects> projectList = ProjectsDAO.getProjectDetails(connection);
		
		System.out.println("     ");
		
		System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s|\n",
		                    "Project Name", "Client Name", "CreatedBy", "UpdatedBy",
		                    "CreatedDate", "UpdatedDate", "Description", "TotalAmount");
		
		System.out.println("-".repeat(15) + " | " + "-".repeat(15) + " | " + "-".repeat(15) + " | " + "-".repeat(15) +
		                    " | " + "-".repeat(15) + " | " + "-".repeat(15) + " | " + "-".repeat(15) + " | " + "-".repeat(15));

		
		for (Projects project : projectList) {
		    System.out.printf("%-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s\n",
		                      project.getProjectName(),
		                      project.getClients().getClientName(),
		                      project.getEmployees().getFirstName(),
		                      project.getEmployees1().getFirstName(),
		                      project.getCreatedDate(),
		                      project.getUpdatedDate(),
		                      project.getDescription(),
		                      project.getTotalAmount());
		}


		Scanner scanner = new Scanner(System.in);

		String goMainMenu = "y";
		do {
			try {
				Connection connection1 = ProjectsDAO.getConnection();
				System.out.println("***************************************************************For More Details**********************************************************");
				System.out.println("What is the project name?");
				String projectName = scanner.nextLine();
				ArrayList<Projects> projectList1 = ProjectsDAO.getProjectBalanceamount(connection1, projectName);
				
				System.out.printf("%-15s | %-15s | %-15s | %-15s\n", "Project Name", "TotalAmount", "Spent Amount", "Balance Amount");
				
				System.out.println("-".repeat(15) + " | " + "-".repeat(15) + " | " + "-".repeat(15) + " | " + "-".repeat(15));

				
				for (Projects projects : projectList1) {
				    System.out.printf("%-15s | %-15.2f | %-15.2f | %-15.2f\n",
				                      projects.getProjectName(),
				                      projects.getTotalAmount(),
				                      projects.getSpentAmount(),
				                      projects.getBalanceAmount());
				}

				connection.close();
				connection1.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("     ");
			System.out.println("Do you want to see project details(y/n)");
			goMainMenu = scanner.nextLine();
		}while (goMainMenu .equals("y"));

	}


}

