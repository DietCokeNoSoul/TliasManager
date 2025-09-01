package com.yep.web.service;


import java.util.List;

import com.yep.web.pojo.Emp;
import com.yep.web.pojo.EmpQueryParam;
import com.yep.web.pojo.LoginInfo;
import com.yep.web.pojo.PageResult;

/**
 * 员工服务
 */
public interface EmpService {

    PageResult<Emp> list(EmpQueryParam empQueryParam);

    void createEmp(Emp emp);

    void deleteEmp(List<Integer> ids);

    Emp getEmpById(Integer id);

    void updateEmp(Emp entity);

    LoginInfo login(Emp emp);
}
