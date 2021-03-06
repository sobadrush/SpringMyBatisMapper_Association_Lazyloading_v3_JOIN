package com.ctbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ctbc.model.vo.DeptVO;

/**
 * (1)
 *    org.mybatis.'spring'.annotation.@MapperScan 掃描 
 *    @Mapper 所在的包
 * (2)
 *    映射xml中，<mapper namespace="com.ctbc.mapper.DeptMapper">  
 *    namespace 要指到 Mapper介面
 * (3)
 *    Mapper介面的抽象方法名稱 ooo，要與映射xml中 <select id="ooo" ...> 一致
 * (4)
 *    @Param(value = "ggg")  vs XML中的 #{ggg}
 */
@Mapper
public interface DeptMapper {
	//@Select("SELECT * FROM dept_TB10")
	public abstract List<DeptVO> getDept();

	@Select("SELECT * FROM dept_TB10")
	public List<DeptVO> getAllByMapperAnnotation();
	public DeptVO getDept(@Param("deptNoGGG") Integer deptNo);
	public List<DeptVO> getDeptsInMulitId(@Param("deptNoInArr") int[] deptNos);	
	public int addDept(@Param("deptVOgg") DeptVO deptVO);
	public int updateDept(@Param("deptVOgg") DeptVO deptVO);
	public int updateDeptUseSetTag(@Param("deptVOgg") DeptVO deptVO);
	public int delDept(@Param("deptNumber") Integer deptNNN);

	// 關聯查詢( 使用 JOIN ) 
	public List<DeptVO> getDeptsWithEmps();
	// 關聯查詢( 使用 JOIN ) 
	public List<DeptVO> getDeptsWithEmps(@Param("deptId") int dept_id);
}


