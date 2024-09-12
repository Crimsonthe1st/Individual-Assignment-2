package com.csc340.apiPractice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ApiController {

    //default @return index
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Extracts json information from PokeAPI to create a pokemon object
     *
     * @param ditto the new Pokemon using id and name as string variables
     * @return instance of the Pokemon class, specifically ditto
     **/
    @GetMapping("/ditto")
    public Object getDitto() {
        try {
            String url = "https://pokeapi.co/api/v2/pokemon/ditto";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jsonResult = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jsonResult);


            String id = root.get("id").asText();
            String name = root.get("name").asText();

            //for some reason the name would not work in the constructor and would give null so this is the work around
            Pokemon ditto = new Pokemon();
            ditto.setName(name);
            ditto.setId(id);

            return ditto;

        } catch (JsonProcessingException ex) {
            Logger.getLogger(ApiController.class.getName()).log(Level.SEVERE,
                    null, ex);
            return "error in /ditto";
        }

    }

    /**
     * Underconstruction, ended up not working
     * Gets a list of pokemon from PokeAPI and extracts info for creating an instance of the Pokemon class
     *
     * @return array of Pokemon objects
     **/
//    @GetMapping("/pokemon")
//    public Object getPokemon() throws JsonProcessingException {
//        String url = "https://pokeapi.co/api/v2/pokemon?limit=3&offset=0";
//
//        RestTemplate restTemplate = new RestTemplate();
//        ObjectMapper mapper = new ObjectMapper();
//
//        //We are expecting a String object as a response from the above API.
//        String jsonPoke = restTemplate.getForObject(url, String.class);
//        JsonNode root = mapper.readTree(jsonPoke);
//
//        System.out.println(jsonPoke.indexOf("results")); //gives index 91
//        String[] results = new String[5]; //hard coded for testing
//        String[] parsing = jsonPoke.split(",");
//        String combing = parsing.toString();
//        parsing = combing.split(":");
//
//        System.out.println(Arrays.toString(parsing));
//
//
//        System.out.println(Arrays.toString(results));
//
//        return root;
//
//    }



}



