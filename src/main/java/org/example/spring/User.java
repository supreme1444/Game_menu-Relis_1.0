package org.example.spring;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@Data
public class User implements Serializable {

public int id;
 public String  name;
 public String nicknames;
 public int rateGN;
 public int rate0X;

    public User( int id, String name, String nicknames, int rateGN, int rate0X) {
        this.id = id;
        this.name = name;
        this.nicknames = nicknames;
        this.rateGN = rateGN;
        this.rate0X = rate0X;
    }


}
