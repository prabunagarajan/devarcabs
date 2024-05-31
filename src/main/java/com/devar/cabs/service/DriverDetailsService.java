package com.devar.cabs.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.devar.cabs.requestDTO.DriverDetailsRequestDTO;
import com.devar.cabs.utility.GenericResponse;

public interface DriverDetailsService {


	GenericResponse add(DriverDetailsRequestDTO driverDetailsRequestDTO);

	GenericResponse update(DriverDetailsRequestDTO driverDetailsRequestDTO);

	GenericResponse getById(Long id);

	GenericResponse getAll();


}
