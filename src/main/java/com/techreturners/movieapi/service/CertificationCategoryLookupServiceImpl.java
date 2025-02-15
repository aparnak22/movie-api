package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.Certification;
import org.springframework.stereotype.Service;

@Service
public class CertificationCategoryLookupServiceImpl implements CertificationCategoryLookupService {

    @Override
    public Certification getCertification(int age){
        for (Certification category : Certification.values()) {
            if (age >= category.getMinAge())
                return category;
        }
        return Certification.universal;
    }

}
