package com.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.TreeNode;



import com.service.EmployeeService;

@ManagedBean
@ViewScoped
public class TreeBean implements Serializable {

	private static final long serialVersionUID = 2417620239014385855L;

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private TreeNode root;
	private TreeNode selectedNode;


	public TreeBean() {
		root = new TreeNodeImpl("Root", null);
		
		TreeNode Parent = new TreeNodeImpl("Company Employee", root);

		TreeNode firstchild1 = new TreeNodeImpl("First Child", Parent);
		TreeNode secondChild1 = new TreeNodeImpl("secondChild1", firstchild1);
		TreeNode thirdChild1 = new TreeNodeImpl("thirdChild1", secondChild1);
		TreeNode forthChild1 = new TreeNodeImpl("forthChild1", thirdChild1);
		TreeNode fifthChild1 = new TreeNodeImpl("fifthChild1", forthChild1);
		TreeNode fifthChild2 = new TreeNodeImpl("fifthChild2", forthChild1);
	}

	public TreeNode getModel() {
		return root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}