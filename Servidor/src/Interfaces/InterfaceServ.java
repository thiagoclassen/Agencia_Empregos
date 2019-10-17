package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServ extends Remote {
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException;
}