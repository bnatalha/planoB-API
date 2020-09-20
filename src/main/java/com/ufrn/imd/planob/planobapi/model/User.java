package com.ufrn.imd.planob.planobapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userr")
public class User {

    @Id
    private String login;

    private String name;

    private String keyphrase;

}
