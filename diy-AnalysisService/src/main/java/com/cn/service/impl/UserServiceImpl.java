package com.cn.service.impl;



import com.cn.dao.UserDAO;
import com.cn.pojo.UserTest;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    public List<UserTest> findAll() {
        return userDAO.findAll();
    }

    @Transactional
    public List<UserTest> findDiySql(){

        StringBuilder sqljoint=new StringBuilder(300);
        sqljoint.append("SELECT * FROM user where 1=1");
        //sqljoint.apped("附加的where子句")
        String sql=sqljoint.toString();

        Query query = entityManager.createNativeQuery(sql);
        List<UserTest> obj=query.getResultList();
        return  obj;
    }



}
