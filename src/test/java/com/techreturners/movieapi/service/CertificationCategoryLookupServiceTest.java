package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.Certification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CertificationCategoryLookupServiceTest {


    private CertificationCategoryLookupServiceImpl ccLookupSvc;

    @Test
    public void testPGMapping(){
        int age = 5;
        ccLookupSvc = new CertificationCategoryLookupServiceImpl();
        Certification certification = ccLookupSvc.getCertification(age);
        assertEquals(Certification.parental_guidance, certification);
    }

    @Test
    public void testAbove18(){
        int age = 18;
        ccLookupSvc = new CertificationCategoryLookupServiceImpl();
        Certification certification = ccLookupSvc.getCertification(age);
        assertEquals(Certification.above18, certification);
    }

    @Test
    public void testAbove15(){
        int age = 15;
        ccLookupSvc = new CertificationCategoryLookupServiceImpl();
        Certification certification = ccLookupSvc.getCertification(age);
        assertEquals(Certification.above15, certification);
    }


    @Test
    public void testAbove12(){
        int age = 12;
        ccLookupSvc = new CertificationCategoryLookupServiceImpl();
        Certification certification = ccLookupSvc.getCertification(age);
        assertEquals(Certification.above12, certification);
    }


}
