package com.cn.design.factory;

public class SendFactoryMore {
    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
