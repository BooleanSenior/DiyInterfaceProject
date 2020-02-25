package com.cn.dao;



import com.cn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author
 * @date
 * @email
 */
@Component
public interface UserDAO extends JpaRepository<User,Long> {
    /*
    * 我们在这里直接继承 JpaRepository
    * 这里面已经有很多现场的方法了
    * 这也是JPA的一大优点
    *
    * */

    @Query("select p from t_inv_personal p where p.personal_id=?1")
    public  User getUserOne(String personal_id);

    @Query("select p from t_inv_personal p where p.area_code like ?1%")
    public List<User> getUserLike(String area_code);

}
