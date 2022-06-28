package com.techreturners.movieapi.service;

import com.techreturners.movieapi.model.Certification;

public interface CertificationCategoryLookupService {
    Certification getCertification(int age);
}
