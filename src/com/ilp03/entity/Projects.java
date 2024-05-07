package com.ilp03.entity;


	
	import java.util.Date;
import java.time.LocalDate;

	public class Projects {
	    private int projectId;
	    private String projectName;
	    private Clients clients;
	    private Employees employees;
	    private Employees employees1;
	    private Date createdDate;
	    private Date updatedDate;
	    private String description;
	    private double totalAmount;
	    private double spentAmount;
	    private double balanceAmount;
		public Projects(int projectId, String projectName, Clients clients, Employees employees,Employees employees1, Date createdDate,
				Date updatedDate, String description, double totalAmount) {
			super();
			this.projectId = projectId;
			this.projectName = projectName;
			this.clients = clients;
			this.employees = employees;
			this.employees1 = employees1;
			this.createdDate = createdDate;
			this.updatedDate = updatedDate;
			this.description = description;
			this.totalAmount = totalAmount;
		}
		public Projects(int projectId, String projectName1, double totalAmount2, double spentAmount, double balanceAmount) {
			// TODO Auto-generated constructor stub
			this.projectId = projectId;
			this.projectName = projectName1;
			this.totalAmount = totalAmount2;
			this.spentAmount = spentAmount;
			this.balanceAmount = balanceAmount;
		}
		public int getProjectId() {
			return projectId;
		}
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public Clients getClients() {
			return clients;
		}
		public void setClients(Clients clients) {
			this.clients = clients;
		}
		public Employees getEmployees() {
			return employees;
		}
		public void setEmployees(Employees employees) {
			this.employees = employees;
		}
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		public Date getUpdatedDate() {
			return updatedDate;
		}
		public void setUpdatedDate(Date updatedDate) {
			this.updatedDate = updatedDate;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Employees getEmployees1() {
			return employees1;
		}
		public void setEmployees1(Employees employees1) {
			this.employees1 = employees1;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public double getSpentAmount() {
			return spentAmount;
		}
		public void setSpentAmount(double spentAmount) {
			this.spentAmount = spentAmount;
		}
		public double getBalanceAmount() {
			return balanceAmount;
		}
		public void setBalanceAmount(double balanceAmount) {
			this.balanceAmount = balanceAmount;
		}
	}