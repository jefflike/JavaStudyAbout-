package com.jeffcode.demo.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
* 二、定义一个实现类，实现以上接口
* 三、 继承UnicastRemoteObject，为了让我们的类实例变成一个可以给远程客户端服务的一个对象，简而言之，让远程对象访问到我么这个类就必须
* 继承UnicastRemoteObject
* 四、实现一个空参构造器，并抛出异常RemoteException
* */
public class SayHelloImpl extends UnicastRemoteObject implements ISayHello {

    public SayHelloImpl() throws RemoteException {
    };

    public String ISayHello(String name) {
        return "Hello jeff ->" + name;
    }
}
