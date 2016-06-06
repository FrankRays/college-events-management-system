package com.buzz.bean;
// default package

import java.util.HashSet;
import java.util.Set;

import com.buzz.formbean.BranchFormBean;
import com.buzz.pojo.Branch;


/**
 * Branch entity. @author MyEclipse Persistence Tools
 */

public class BranchBean  implements java.io.Serializable {


    // Fields    

     private int branchid;
     private String branchname;
     private String branchdesc;

     private Set studentDetailses = new HashSet(0);


    // Constructors

    /** default constructor */
 	public BranchBean() {
	}

	/** minimal constructor */
	public BranchBean(String branchname) {
		this.branchname = branchname;
	}

	/** full constructor */
	public BranchBean(String branchname, String branchdesc,
			Set oraganisedStudentsDetailses, Set praticipantStudentDetailses) {
		this.branchname = branchname;
		this.branchdesc = branchdesc;
	
	}

	public BranchBean(Branch branch) {
		this.branchid = branch.getBranchid();
		this.branchname = branch.getBranchname();
		this.branchdesc = branch.getBranchdesc();
	
	}

	// Property accessors

	public BranchBean(BranchFormBean branchFormBean) {
		this.branchname = branchFormBean.getBranchName();
		this.branchdesc = branchFormBean.getBranchDesc();
	}

   
    // Property accessors

   

    public BranchBean(int studentBranchidref) {
    	this.branchid=studentBranchidref;
	}

	public String getBranchname() {
        return this.branchname;
    }
    
    public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getBranchdesc() {
        return this.branchdesc;
    }
    
    public void setBranchdesc(String branchdesc) {
        this.branchdesc = branchdesc;
    }

    public Set getStudentDetailses() {
        return this.studentDetailses;
    }
    
    public void setStudentDetailses(Set studentDetailses) {
        this.studentDetailses = studentDetailses;
    }
   








}