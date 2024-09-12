/**
 *
 *
 * **/

package com.csc340.apiPractice;

public class Pokemon {
    public String id;
    public String name;


    public Pokemon(String type, String id) {
        this.name = name;
        this.id = id;
    }
    public Pokemon() {

    }

    public String getid() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
