package com.cn.dao;



import com.cn.pojo.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 * @email
 */
@Component
public interface UserDAO extends JpaRepository<UserTest,Long> {
    /*
    * 我们在这里直接继承 JpaRepository
    * 这里面已经有很多现场的方法了
    * 这也是JPA的一大优点
    *
    * */



}
