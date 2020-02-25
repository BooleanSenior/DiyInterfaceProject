package com.cn.design.factory;

public class FactoryTest {

    public static void main(String[] args) {
        //简单工厂，传入一个参数来决定生产出哪一个实例
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();

        //多个工厂模式。是对普通工厂方法模式的改进，在普通工厂方法模式中，
        // 如果传递的字符串出错，则不能正确创建对象，
        // 而多个工厂模式提供了多个工厂方法，分别创建对象。
        SendFactoryMore factorymore = new SendFactoryMore();
        Sender sendermore = factorymore.produceMail();
        sendermore.Send();

        //静态工厂
        Sender senderStatic = SendFactoryStatic.produceMail();
        senderStatic.Send();


//        总结：总体来说，工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建。
//        在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，不需要实例化工厂。
//        所以，大多数情况下，我们会选用第三种——静态工厂方法模式

    }
}
