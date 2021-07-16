package com.example.spring_marvelapi;
/*
Here is your key: 1b3bb77c
OMDb API: http://www.omdbapi.com/?i=tt3896198&apikey=1b3bb77c
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

@RestController
public class PersonajeController {

@GetMapping("/{nombre}")
    public String buscarPersonajes(@PathVariable String nombre){
        RestTemplate apiMarvel = new RestTemplate();
        String apiKeyPublica="21b4887441a16ab0ff84a18506963811";
        String apiKeyPrivada="9d917c02bd3981af3b8fc6ecd96b75c8107b8cd3";
        String timeStamp="1624296805";
        //String hash= timeStamp  + apiKeyPrivada + apiKeyPublica;
        String hashMD5= "4f9a8bcbdeb5af8cd1d37215767fc948";

        String urlApi="https://gateway.marvel.com:443/v1/public/characters?apikey=" + apiKeyPublica +
                "&ts=" + timeStamp + "&hash=" + hashMD5 + "&name=" + nombre;

        String respuesta = apiMarvel.getForObject(urlApi,String.class);

        return respuesta;
    }

}
