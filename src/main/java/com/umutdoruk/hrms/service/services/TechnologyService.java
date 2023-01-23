package com.umutdoruk.hrms.service.services;

import com.umutdoruk.hrms.entities.Technology;

import java.util.List;

public interface TechnologyService {

    void add(Technology technology);
    List<Technology> getAll();
    Technology findById(Long id);
    void delete(Long id);
    void update(Technology technology);


}
