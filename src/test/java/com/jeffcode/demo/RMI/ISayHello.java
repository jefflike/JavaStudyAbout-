package com.jeffcode.demo.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
*  一、定义一个接口继承rmi.Remote,注一定要throws这个RemoteException异常，否则不能启动
*  我们底层的通信依然是遵循的socket的通信，网络的异常依然需要被抛出
* */
public interface ISayHello extends Remote {
    public String ISayHello(String name) throws RemoteException;
}
