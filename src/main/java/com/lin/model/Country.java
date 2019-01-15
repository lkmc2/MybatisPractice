package com.lin.model;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 国家
 */
public class Country {
    private Integer id;
    private String countryname;
    private String countrycode;

    public Country(Integer id, String countryname, String countrycode) {
        this.id = id;
        this.countryname = countryname;
        this.countrycode = countrycode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
}
