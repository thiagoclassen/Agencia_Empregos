package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Objects.Curriculo;
import Objects.Vaga;

public interface InterfaceAgencia extends Remote {
    // cadastra uma nova vaga
    public void cadastroVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException;

    // consulta curriculos
    public ArrayList<Curriculo> consultaCurriculos(InterfaceCli referenciaCli, Curriculo curriculo) throws RemoteException;

    // subscribe para novos candidatos
    public void registrarInteresseProfissionais(InterfaceCli referenciaCli, String areaOferta) throws RemoteException;

}