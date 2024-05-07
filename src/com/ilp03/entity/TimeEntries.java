package com.ilp03.entity;

	
	import java.time.LocalDate;
	import java.time.LocalTime;

	public class TimeEntries {
	    private int timeEntryId;
	    private int employeeId;
	    private int projectId;
	    private LocalDate date;
	    private LocalTime startTime;
	    private LocalTime endTime;
	    private double hoursWorked;

	    
	    public TimeEntries() {
	    }

	    public TimeEntries(int timeEntryId, int employeeId, int projectId, LocalDate date, LocalTime startTime, LocalTime endTime, double hoursWorked) {
	        this.timeEntryId = timeEntryId;
	        this.employeeId = employeeId;
	        this.projectId = projectId;
	        this.date = date;
	        this.startTime = startTime;
	        this.endTime = endTime;
	        this.hoursWorked = hoursWorked;
	    }

	    
	    public int getTimeEntryId() {
	        return timeEntryId;
	    }

	    public void setTimeEntryId(int timeEntryId) {
	        this.timeEntryId = timeEntryId;
	    }

	    public int getEmployeeId() {
	        return employeeId;
	    }

	    public void setEmployeeId(int employeeId) {
	        this.employeeId = employeeId;
	    }

	    public int getProjectId() {
	        return projectId;
	    }

	    public void setProjectId(int projectId) {
	        this.projectId = projectId;
	    }

	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

	    public LocalTime getStartTime() {
	        return startTime;
	    }

	    public void setStartTime(LocalTime startTime) {
	        this.startTime = startTime;
	    }

	    public LocalTime getEndTime() {
	        return endTime;
	    }

	    public void setEndTime(LocalTime endTime) {
	        this.endTime = endTime;
	    }

	    public double getHoursWorked() {
	        return hoursWorked;
	    }

	    public void setHoursWorked(double hoursWorked) {
	        this.hoursWorked = hoursWorked;
	    }

	    // toString() method for debugging
	    @Override
	    public String toString() {
	        return "TimeEntries{" +
	                " employeeId=" + employeeId +
	                ", projectId=" + projectId +
	                ", date=" + date +
	                ", startTime=" + startTime +
	                ", endTime=" + endTime +
	                ", hoursWorked=" + hoursWorked +
	                '}';
	    }
	}



