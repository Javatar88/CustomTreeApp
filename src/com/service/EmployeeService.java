package com.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Employee;
@Component
public class EmployeeService implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private SessionFactory sessionFactory;
	


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

	@Transactional
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery("from Employee").list();
		return employees;
	}
	@Transactional
	public void updateEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Employee  set name =:name,"
				+ "department =:department," + "hireDate =:hireDate ,"
				+ "salary =:salary" + " where id=:id");
		query.setString("name", emp.getName());
		query.setString("department", emp.getDepartment());
		query.setDate("hireDate", emp.getHireDate());
		query.setDouble("salary", emp.getSalary());
		query.setDouble("id", emp.getId());
		query.executeUpdate();
	}
	public void add(Employee emp) {
		// Acquire session
		System.out.println("Done Service");
		Session session = sessionFactory.getCurrentSession();
		// Save employee
		session.save(emp);
	}
}