package com.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.entity.Employee;
import com.service.EmployeeService;

@ManagedBean
@ViewScoped
public class EmployeeBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private List<Employee> employees;
	private Employee employee = new Employee();

	@PostConstruct
	public void init() {
		//initialize datatable 
		employees = employeeService.getEmployees();
		
	}

	public void add() {
		// Calling Service
		employeeService.add(employee);
		employees = employeeService.getEmployees();
	}

	// update employee 
	public void onRowEdit(RowEditEvent event) {
		// get object
		Employee emp = (Employee) event.getObject();
		employeeService.updateEmployee(emp);
		FacesMessage msg = new FacesMessage("Employee with" + emp.getId()
				+ "Updated");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	// cancel employee update
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	

	// getters and setters

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
