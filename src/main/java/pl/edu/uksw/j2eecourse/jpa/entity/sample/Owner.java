/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.uksw.j2eecourse.jpa.entity.sample;

import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Aleksander Nowinski <a.nowinski@icm.edu.pl>
 */
@Entity
public class Owner {
    @Id
    @GeneratedValue
    int id;
    String name;
    @OneToMany(cascade = ALL, fetch = LAZY, mappedBy = "owner")
    List<Pet> pets;
}
