package com.example.aferyad_haitam_exam.Model;

import java.util.HashMap;
import java.util.Map;

public class Weight {

    private Integer value;
    private String unity;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
