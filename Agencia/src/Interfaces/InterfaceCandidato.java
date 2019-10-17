package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Objects.Curriculo;
import Objects.Vaga;

public interface InterfaceCandidato extends Remote {
    public void chamar(String msg, InterfaceCli interfaceCli) throws RemoteException;

    public void cadastroCurriculo(InterfaceCli referenciaCli, Curriculo curriculo) throws RemoteException;

    public void consultaVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException;

    public void registrarInteresseVagas(InterfaceCli referenciaCli, String areaInteresse) throws RemoteException;

}