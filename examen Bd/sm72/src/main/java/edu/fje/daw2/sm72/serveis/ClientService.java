package edu.fje.daw2.sm72.serveis;

import edu.fje.daw2.sm72.model.Client;
import edu.fje.daw2.sm72.repositoris.ClientRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepositori cr;

    public List<Client> trobarTots() {
        var it = cr.findAll();
        var clients = new ArrayList<Client>();
        it.forEach(clients::add); //equivalent a it.forEach(e -> usuaris.add(e));
        return clients;
    }

    public Long comptar() {
        return cr.count();
    }

    public void modificarPerId(Long UsuariId) {
        cr.deleteById(UsuariId);
    }

    public Client trobarPerId(Long id){
       return cr.findById(id).get();
    }

    public void afegirClient(String nom, String cognom, int volum){
        var u1 = new Client(nom, cognom, volum);
        cr.save(u1);
    }
    public void afegirClient(Client u){
        cr.save(u);
    }

}