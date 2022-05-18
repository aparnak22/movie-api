package com.techreturners.movieapi.model;

public enum Certification {

    above18(18,"18"),
    above15(15,"15"),
    above12(12,"12"),
    below12 (12,"12A"),
    parental_guidance(0,"PG"),
    universal(0,"u");


    private final int minAge;
    private final String certificationCode;

    Certification(int minAge, String certificationCode) {
        this.minAge = minAge;
        this.certificationCode = certificationCode;
    }

    public int getMinAge(){
        return minAge;
    }

    public String getCertificationCode(){
        return certificationCode;
    }
}
