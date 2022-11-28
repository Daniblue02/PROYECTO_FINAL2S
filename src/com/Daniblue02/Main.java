package com.Daniblue02;

import com.Daniblue02.dao.ClienteDao;
import com.Daniblue02.dao.CocheDao;
import com.Daniblue02.dao.RevisionDao;
import com.Daniblue02.model.Cliente;
import com.Daniblue02.model.Coche;
import com.Daniblue02.model.Revision;
import com.Daniblue02.util.ConectorBD;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Cliente cliente = new Cliente("1450", "Carlos Peréz", "Cochabamba", "Av. Ayacucho #2231", 74452229);
        //Cliente laura = new Cliente("1451", "Carlos Peréz", "Cochabamba", "Av. Ayacucho #2231", 74452229);
        //Coche ferrari2 = new Coche ("AH0122","Ferrari","TH800","rojo",200004,"1451");
        //Coche mercedes = new Coche ("AH0142","Ferrari","TH800","rojo",200004,"1451");
        Revision tecnica1 = new Revision("29994","No sirve","Correcto","Cambiados","AH0142");

        ClienteDao clienteDao = new ClienteDao();
        CocheDao cocheDao = new CocheDao();
        RevisionDao revisionDao = new RevisionDao();

        //CREATE
        //clienteDao.addCliente(laura);
        //clienteDao.addCliente(cliente);

        //cocheDao.addCoche(ferrari);
        //cocheDao.addCoche(mercedes);

        //revisionDao.addRevision(tecnica1);

        //READ
        //List<Cliente> clientes = clienteDao.getAllClientes();
        //for (int i = 0; i < clientes.size(); i++){
        //    Cliente cliente = clientes.get(i);

        //    System.out.println(cliente);
        //}

        /*
        List<Coche> coches = cocheDao.getAllCoches();
        for (int i = 0; i < coches.size(); i++){
            Coche coche = coches.get(i);

            System.out.println(coche);
        }
         */

        /*
        List<Revision> revisiones = revisionDao.getAllRevisiones();
        for (int i=0; i< revisiones.size(); i++){
            Revision revision = revisiones.get(i);

            System.out.println(revision);
        }
         */


        //UPDATE
        //Cliente cliente = new Cliente("1450", "Fenando Torrico", "La Paz", "Av. 6Agosto #2231", 73772229);
        //clienteDao.updateCliente(cliente);

        //Coche coche = new Coche ("AH0142" , "tOHSIBApowa" , "II9s11", "Negro", 12000,"1451");
        //cocheDao.updateCoche(coche);

        //Revision revision = new Revision("29994", "Correctos", "Correcto", "Repuestos", "AH0142");
        //revisionDao.updateRevision(revision);

        //DELETE
        //clienteDao.deleteCliente("1456-1B");
        //clienteDao.deleteCliente("1450");

        //cocheDao.deleteCoche("AH0122");

        revisionDao.deleteRevision("29994");
    }
}
