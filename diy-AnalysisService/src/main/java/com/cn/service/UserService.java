package com.cn.service;



import com.cn.pojo.UserTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author
 * @email
 */


public interface UserService {

    List<UserTest> findAll();

    List<UserTest> findDiySql();


}
