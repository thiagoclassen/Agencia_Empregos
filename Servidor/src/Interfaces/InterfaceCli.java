package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCli extends Remote{
    // metodo para notificações do servidor
    public void echo(String msg) throws RemoteException;
    
}