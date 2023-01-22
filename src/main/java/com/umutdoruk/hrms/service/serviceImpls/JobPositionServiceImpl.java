package com.umutdoruk.hrms.service.serviceImpls;

import com.umutdoruk.hrms.entities.JobPosition;
import com.umutdoruk.hrms.exception.NotFoundException;
import com.umutdoruk.hrms.repository.JobPositionRepository;
import com.umutdoruk.hrms.service.services.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionServiceImpl implements JobPositionService {
    private final JobPositionRepository jobPositionRepository;

    @Autowired
    public JobPositionServiceImpl(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionRepository.findAll();
    }

    @Override
    public void add(JobPosition jobPosition) {
        if (jobPosition == null) {
            throw new NotFoundException("No Job Position record found to add");
        }
        jobPositionRepository.save(jobPosition);
    }

    @Override
    public List<JobPosition> findByName(String jobPositionName) {

        List<JobPosition> jobPositionList = jobPositionRepository.findByName(jobPositionName);
        if (jobPositionList.isEmpty()) {
            throw new NotFoundException("No Job Position record found with name: " + jobPositionName);
        }

        return jobPositionList;
    }

    @Override
    public void update(JobPosition jobPosition) {
        JobPosition jobPositionToUpdate = jobPositionRepository.findById(jobPosition.getJobPositionId())
                .orElseThrow(()-> new NotFoundException("Job Position is not found"));

        jobPositionToUpdate.setName(jobPosition.getName());
        jobPositionRepository.save(jobPositionToUpdate);
    }

    @Override
    public void delete(Long id) {
        if (!(jobPositionRepository.existsById(id)))
            throw new NotFoundException("Job Position is not found");
        jobPositionRepository.deleteById(id);
    }

}