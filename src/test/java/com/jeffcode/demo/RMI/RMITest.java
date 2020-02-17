package com.jeffcode.demo.RMI;

import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMITest {
    @Test
    public void RMIClient() {
        try {
            ISayHello  lookup = (ISayHello) Naming.lookup("rmi://localhost:8888/sayhello");
            String lisa = lookup.ISayHello("Lisa");
            System.out.println("hello " + lisa);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void RMIServer() throws InterruptedException {
        try {
            ISayHello hello = new SayHelloImpl();

            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/sayhello", hello);
            System.out.println("Server Start");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        Thread.currentThread().join();
    }
}
