package org.example.spring;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class User implements Serializable {

    public int id;
    public String name;
    public String nicknames;
    public int rateGN;
    public int rate0X;


}
