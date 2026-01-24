package org.example;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    private String cityName;
    @ManyToOne
    @JoinColumn(name = "stateId")
    private IndianState state;

    public City() {
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public IndianState getState() {
        return state;
    }

    public void setState(IndianState state) {
        this.state = state;
    }
}
