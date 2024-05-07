package com.ilp03.entity;

import java.time.LocalDate;

public class Employees {
	
	    private int empNo;
	    private LocalDate birthDate;
	    private String firstName;
	    private String lastName;
	    private String sex;
	    private LocalDate joinDate;
	    private double hourlyRate;
		public Employees(int empNo, LocalDate birthDate, String firstName, String lastName, String sex,
				LocalDate joinDate, double hourlyRate) {
			super();
			this.empNo = empNo;
			this.birthDate = birthDate;
			this.firstName = firstName;
			this.lastName = lastName;
			this.sex = sex;
			this.joinDate = joinDate;
			this.hourlyRate = hourlyRate;
		}
		public int getEmpNo() {
			return empNo;
		}
		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}
		public LocalDate getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public LocalDate getJoinDate() {
			return joinDate;
		}
		public void setJoinDate(LocalDate joinDate) {
			this.joinDate = joinDate;
		}
		public double getHourlyRate() {
			return hourlyRate;
		}
		public void setHourlyRate(double hourlyRate) {
			this.hourlyRate = hourlyRate;
		}
  
}
