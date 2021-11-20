package com.nineworanop.schoolexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineworanop.schoolexample.dto.School;
import com.nineworanop.schoolexample.repo.SchoolCRUDRepository;
import com.nineworanop.schoolexample.repo.SchoolQueryRepository;
import com.nineworanop.schoolexample.repo.entity.SchoolEntity;

import io.micrometer.core.annotation.Timed;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolCRUDRepository crudRepo;

	@Autowired
	private SchoolQueryRepository queryRepo;

	@Override
	@Timed(value = "SchoolService.getSchools")
	public List<School> getSchools() {
		Iterable<SchoolEntity> list = crudRepo.findAll();
		return SchoolEntity.to(list);
	}

	@Override
	@Timed(value = "SchoolService.findSchoolsByNameContainingIgnoreCase")
	public List<School> findSchoolsByNameContainingIgnoreCase(String name) {
		Iterable<SchoolEntity> list = queryRepo.findNameContainingIgnoreCase(name);
		return SchoolEntity.to(list);
	}

}
