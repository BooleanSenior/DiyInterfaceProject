package com.cn.util;

import com.cn.pojo.User;
import com.cn.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

@Component   //关键点
public class TopThread extends Thread {
    @Autowired
    private  UserService userService; //添加所需service的私有成员
    private static TopThread topThread; // 关键点1 静态初使化 一个工具类 这样是为了在spring初使化之前

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @PostConstruct     //关键二   通过@PostConstruct 和 @PreDestroy 方法 实现初始化和销毁bean之前进行的操作
    public void init() {
        topThread = this;
        topThread.userService = this.userService;   // 初使化时将已静态化的testService实例化
    }


    Logger logger= Logger.getLogger(TopThread.class);
    private static List<User> users;
    private static AtomicLong numSexNv = new AtomicLong(0);
    private static AtomicLong numSexNan = new AtomicLong(0);
    @Override
    public void run() {
       // super.run();
        logger.info("开始"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
        try {
            Thread.sleep(1000);
            //for(User user:users){
              /*  logger.info(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"))
                        +Thread.currentThread().getName()
                        +"run---"
                        +user.getPersonal_id());*/
              User user = getTopOne();
              while(user != null){
                  int   gender =   topThread.userService.getUserOne(user.getPersonal_id()).getGender();
                  if( gender % 2 == 0){
                     // logger.info(Thread.currentThread().getName()+"---女性");
                      //numSexNv++;
                      numSexNv.incrementAndGet();
                      logger.info(Thread.currentThread().getName()+"numSexNv:"+numSexNv);
                  }else if( gender % 2 == 1){
                     // logger.info(Thread.currentThread().getName()+"---男性");
                      numSexNan.incrementAndGet();
                      logger.info(Thread.currentThread().getName()+"numSexNan:"+numSexNan);
                  }
                  user = getTopOne();
              }

            //}

           // System.out.println(Thread.currentThread().getName()+"男性："+numSexNan+"女性："+numSexNv);
            logger.info("结束"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
         }
             catch(InterruptedException e)
             {
                 e.printStackTrace();
             }
    }

    private static String execTopJob(){
        ExecutorService fixedThreadPool= Executors.newFixedThreadPool(2);
        Thread t2 = new TopThread();
        Thread t3=new TopThread();
        fixedThreadPool.execute(t2);
        fixedThreadPool.execute(t3);

        fixedThreadPool.shutdown();
        while (true) {
            if (fixedThreadPool.isTerminated()) {
                System.out.println("男性："+numSexNan+"女性："+numSexNv);
                System.out.println("结束了！");
                break;
            }
        }
        return "男性："+numSexNan+"女性："+numSexNv;
    }

    //@Scheduled(cron = "0 50 11 ? *  *  *")
    public static String  springQuzeJob(){
        users = topThread.userService.getUserLike("130102003015");
        return execTopJob();
    }

    private synchronized User getTopOne(){
        Iterator<User> iter = users.iterator();
        User user=null;
        if (iter.hasNext()) {
            user = iter.next();
            iter.remove();
            logger.info("获取"+user.getPersonal_id());
        }else{
            logger.info("执行完毕");
        }

        return user;
    }
}
