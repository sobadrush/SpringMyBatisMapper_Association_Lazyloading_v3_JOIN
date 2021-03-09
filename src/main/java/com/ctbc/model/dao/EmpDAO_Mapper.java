package com.ctbc.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.ctbc.config.RootConfig;
import com.ctbc.mapper.EmpMapper;
import com.ctbc.model.vo.DeptVO;
import com.ctbc.model.vo.EmpVO;

@Repository
public class EmpDAO_Mapper {

	@Autowired
	private EmpMapper empMapper;

	public List<EmpVO> getAll() {
		return empMapper.getEmp();
	}

	public EmpVO getOneEmpById(Integer empno) {
		return empMapper.getEmp(empno);
	}

	public int addEmp(EmpVO empVO) {
		return empMapper.addEmp(empVO);
	}

	public int updateEmp(EmpVO empVO) {
		return empMapper.updateEmp(empVO);
	}

	public int deleteEmp(int empNo) {
		return empMapper.delEmp(empNo);
	}

	public List<EmpVO> getEmpsByHiredate(List<java.sql.Date> dList) {
		return empMapper.getEmpByDateInteval(dList);
	}

	public List<EmpVO> getEmpsWithDeptData() {
		return empMapper.getEmpsWithDept();
	}
	
	public EmpVO getEmpsWithDeptData(int empId) {
		return empMapper.getEmpsWithDept(empId);
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
		EmpDAO_Mapper dao = ctx.getBean("empDAO_Mapper", EmpDAO_Mapper.class);

		//【新增一筆】
//		EmpVO empVO = new EmpVO();
//		empVO.setEmpName("Roger");
//		empVO.setEmpJob("Programer");
//		empVO.setEmpHiredate(java.sql.Date.valueOf("2017-06-11"));
//		empVO.setDeptVO(new DeptVO(10));
//		dao.addEmp(empVO);

		//【更新一筆】
//		EmpVO empVO = new EmpVO();
//		empVO.setEmpNo(7016);
//		empVO.setEmpName("Roger222");
//		empVO.setEmpJob("Programer222");
//		empVO.setEmpHiredate(java.sql.Date.valueOf("2017-06-11"));
//		empVO.setDeptNo(10);
//		dao.updateEmp(empVO);

		//【刪除一筆】
//		int pen = dao.deleteEmp(7014);
//		System.out.println("刪除成功資料：" + pen +" 筆");
		//【查一筆】
//		System.err.println(dao.getOneEmpById(7001));

		//【查全部】
//		for (EmpVO vo : dao.getAll()) {
//			System.err.println(vo.toString());
//		}

		//【查全部 - myBatis <association>】
		List<EmpVO> emplist = dao.getAll();
		for (EmpVO empVO : emplist) {
			System.err.println(empVO.toString());
			
			// 查詢員工所屬的部門
			DeptVO deptVO = empVO.getDeptVO();
			System.out.println(" >>>>>>> " + deptVO.toString());
		}
		
		//【根據到職日期查詢】
//		List<java.sql.Date> dateList = new ArrayList<>();
//		dateList.add(java.sql.Date.valueOf("1981-12-03"));
//		dateList.add(java.sql.Date.valueOf("1982-01-23"));
//		dateList.add(java.sql.Date.valueOf("1981-01-09"));
//		for (EmpVO vo : dao.getEmpsByHiredate(dateList)) {
//			System.err.println(vo.toString());
//		}
		
		//【查全部 --- 關聯查詢(使用JOIN) Dept】
//		List<EmpVO> alist = dao.getEmpsWithDeptData();
//		for (EmpVO empVO : alist) {
//			System.err.println(empVO.toString() + empVO.getDeptVO().toString());
//		}
		
		//【查一筆 by Id --- 關聯查詢(使用JOIN) Dept】
//		EmpVO empvo = dao.getEmpsWithDeptData(7009);
//		System.err.println(empvo.toString() + "  部門為：" + (empvo.getDeptVO().toString()));
		ctx.close();
	}

}
