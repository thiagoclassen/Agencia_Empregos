package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.InterfaceCli;
import Interfaces.InterfaceServ;

public class ServImpl extends UnicastRemoteObject implements InterfaceServ {

 

    protected ServImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = 2241569544740392197L;

    @Override
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException {
        System.out.println("Recebido: "+msg);
        interfaceCli.echo(msg);
    }

    

}