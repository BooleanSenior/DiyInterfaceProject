package com.cn.service;



import com.cn.pojo.User;

import java.util.List;

/**
 * @author
 * @email
 */
public interface UserService {

    List<User> findAll();

    List<User> findDiySql();

    public  User getUserOne(String personal_id);

    public  List<User>  getUserLike(String area_code);


}
