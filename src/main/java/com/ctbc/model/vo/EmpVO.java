package com.ctbc.model.vo;

import java.io.Serializable;
import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias(value = "EmpVOgg")
public class EmpVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer empNo;
	private String empName;
	private String empJob;
	private java.sql.Date empHiredate;
	private DeptVO deptVO;
	
	public EmpVO() {
	}

	public EmpVO(String empName, String empJob, Date empHiredate) {
		super();
		this.empName = empName;
		this.empJob = empJob;
		this.empHiredate = empHiredate;
	}

	public DeptVO getDeptVO() {
		return deptVO;
	}

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpJob() {
		return empJob;
	}

	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	public java.sql.Date getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(java.sql.Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	@Override
	public String toString() {
		return "EmpVO [empNo=" + empNo + ", empName=" + empName + ", empJob=" + empJob + ", empHiredate=" + empHiredate + "]";
	}

}
