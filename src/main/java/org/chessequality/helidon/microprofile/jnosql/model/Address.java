package org.chessequality.helidon.microprofile.jnosql.model;

import org.jnosql.artemis.Column;
import org.jnosql.artemis.Entity;

import java.io.Serializable;

@Entity("Address")
public class Address implements Serializable {

    private static final long serialVersionUID = 6548974146069623583L;

    @Column
    private Integer number;

    @Column
    private String street;

    @Column
    private String city;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
