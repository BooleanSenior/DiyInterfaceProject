package com.cn.service.impl;



import com.cn.dao.UserDAO;
import com.cn.pojo.User;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date
 * @email
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    public List<User> getUserLike(String area_code){
        return userDAO.getUserLike(area_code);
    }

    public  User getUserOne(String personal_id){
        return userDAO.getUserOne(personal_id);
    }

    @Transactional
    public List<User> findDiySql(){

        StringBuilder sqljoint=new StringBuilder(300);
        sqljoint.append("SELECT * FROM user where 1=1");
        //sqljoint.apped("附加的where子句")
        String sql=sqljoint.toString();

        Query query = entityManager.createNativeQuery(sql);
        List<User> obj=query.getResultList();
        return  obj;
    }



}
