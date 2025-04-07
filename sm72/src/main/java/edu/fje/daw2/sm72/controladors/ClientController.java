package edu.fje.daw2.sm72.controladors;

import edu.fje.daw2.sm72.model.Client;
import edu.fje.daw2.sm72.repositoris.ClientRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("llistaClients")
public class ClientController {

    @Autowired
    private ClientRepositori clientRepositori;

    @ModelAttribute("llistaClients")
    public List<Client> inicialitzarClients() {
        return (List<Client>) clientRepositori.findAll();
    }

    @GetMapping("/clients")
    public String llistarClients(Model model) {
        model.addAttribute("llistaClients", clientRepositori.findAll());
        return "clients/llistarClients";
    }

    @PostMapping("/clients/afegir")
    public String afegirClient(
            @RequestParam String nom,
            @RequestParam String cognom,
            @RequestParam int volumCompres,
            Model model) {
        Client client = new Client(nom, cognom, volumCompres);
        clientRepositori.save(client);
        model.addAttribute("llistaClients", clientRepositori.findAll());
        return "clients/llistarClients";
    }

    @PostMapping("/clients/esborrar")
    public String esborrarClient(@RequestParam Long id, Model model) {
        clientRepositori.deleteById(id);
        model.addAttribute("llistaClients", clientRepositori.findAll());
        return "clients/llistarClients";
    }

    @PostMapping("/clients/modificar")
    public String modificarClient(
            @RequestParam Long id,
            @RequestParam String nom,
            @RequestParam String cognom,
            @RequestParam int volumCompres,
            Model model) {

        Client client = clientRepositori.findById(id).orElse(null);
        if (client != null) {
            client.setNom(nom);
            client.setCognom(cognom);
            client.setVolumCompres(volumCompres);
            clientRepositori.save(client);
        }
        model.addAttribute("llistaClients", clientRepositori.findAll());
        return "clients/llistarClients";
    }
}
