package com.ctbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ctbc.model.vo.EmpVO;

@Mapper
public interface EmpMapper {
	public List<EmpVO> getEmp();
	public EmpVO getEmp(@Param("empNoGG") Integer empNo);
	public int addEmp(EmpVO empVO);
	public int updateEmp(@Param("empNoGG") EmpVO empVO);
	public int delEmp(int empId);
	public List<EmpVO> getEmpByDateInteval(List<java.sql.Date> dList);

	// 關聯查詢( 使用 JOIN )
	public List<EmpVO> getEmpsWithDept();
	// 關聯查詢( 使用 JOIN )
	public EmpVO getEmpsWithDept(@Param("empnoGG") Integer empNoo);
}
