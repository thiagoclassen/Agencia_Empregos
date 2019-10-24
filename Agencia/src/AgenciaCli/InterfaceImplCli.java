package AgenciaCli;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.InterfaceCli;

public class InterfaceImplCli extends UnicastRemoteObject implements InterfaceCli {

    protected InterfaceImplCli() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    private static final long serialVersionUID = -2564510475347059842L;

    @Override
    public void echo(String msg) throws RemoteException {
        System.out.println("Resposta Recebida:" + msg);
    }

}