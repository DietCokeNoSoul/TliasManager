package com.yep.web.service;


import java.util.List;

import com.yep.web.pojo.Emp;
import com.yep.web.pojo.EmpQueryParam;
import com.yep.web.pojo.PageResult;

/**
 * 员工服务
 */
public interface EmpService {

    public PageResult<Emp> list(EmpQueryParam empQueryParam);

    public void createEmp(Emp emp);

    public void deleteEmp(List<Integer> ids);

    public Emp getEmpById(Integer id);

    public void updateEmp(Emp entity);
}
