package com.ilp03.entity;

import java.time.LocalDate;

public class invoices {

	private int invoiceId;
    private int projectId;
    private LocalDate date;
    private double totalAmount;
    private String status;
	public invoices(int invoiceId, int projectId, LocalDate date, double totalAmount, String status) {
		super();
		this.invoiceId = invoiceId;
		this.projectId = projectId;
		this.date = date;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    
}
