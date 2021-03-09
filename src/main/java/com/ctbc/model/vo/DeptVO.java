package com.ctbc.model.vo;

import java.io.Serializable;
import java.util.Set;

import org.apache.ibatis.type.Alias;

/**
 * sqlSessionFactory.setTypeAliasesPackage("com.ctbc.model.vo");
 * 搭配 @Alias(value = "fuckDeptVO")
 * → <resultMap id="resultMapDept" type="fuckDeptVO">
 */
@Alias(value = "fuckDeptVO")
public class DeptVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer deptNo;
	private String deptName;
	private String deptLoc;
	private Set<EmpVO> emps;
	
	public DeptVO() {
	}

	public DeptVO(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public DeptVO(String deptName, String deptLoc) {
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public DeptVO(Integer deptNo, String deptName, String deptLoc) {
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public Set<EmpVO> getEmps() {
		return emps;
	}

	public void setEmps(Set<EmpVO> emps) {
		this.emps = emps;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}

	@Override
	public String toString() {
		return "DeptVO [deptNo=" + deptNo + ", deptName=" + deptName + ", deptLoc=" + deptLoc + "]";
	}

}
