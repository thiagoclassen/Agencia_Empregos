package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Interfaces.InterfaceAgencia;
import Interfaces.InterfaceCli;
import Objects.Curriculo;
import Objects.Vaga;

public class AgenciaImpl extends UnicastRemoteObject implements InterfaceAgencia {

    private Base base;

    // recebe construtor da implementação do Agencia, recebe a base
    protected AgenciaImpl(Base base) throws RemoteException {
        super();
        this.base = base; // seta referencia da base
    }

    private static final long serialVersionUID = 2241569544740392197L;

    // cadastra uma nova vaga
    @Override
    public void cadastroVagas(InterfaceCli referenciaCli, Vaga vaga) throws RemoteException {
        this.base.addVaga(vaga);
        this.base.notifyVagas(vaga); // inicia processo de notificação
    }

    // consulta curriculos
    @Override
    public ArrayList<Curriculo> consultaCurriculos(InterfaceCli referenciaCli, Curriculo curriculo)
            throws RemoteException {
        return this.base.consultaCurriculo(curriculo);

    }

    // subscribe para novos candidatos
    @Override
    public void registrarInteresseProfissionais(InterfaceCli referenciaCli, String areaOferta) throws RemoteException {
        this.base.addCandidatosSubscribers(areaOferta, referenciaCli);
    }

}