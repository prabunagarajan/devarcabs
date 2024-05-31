package com.devar.cabs.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devar.cabs.common.ErrorCode;
import com.devar.cabs.common.ErrorMessages;
import com.devar.cabs.common.ResponseMessageConstant;
import com.devar.cabs.entity.DriverDetailsEntity;
import com.devar.cabs.repository.DriverDetailsRepository;
import com.devar.cabs.requestDTO.DriverDetailsRequestDTO;
import com.devar.cabs.service.DriverDetailsService;
import com.devar.cabs.utility.GenericResponse;
import com.devar.cabs.utility.Library;
import org.springframework.util.CollectionUtils;

@Service
public class DriverDetailsServiceImpl implements DriverDetailsService {
	
	@Autowired
	DriverDetailsRepository driverDetailsRepository;
	
	// Insert New G6 Type Master Data to Database
	public GenericResponse add(DriverDetailsRequestDTO driverDetailsRequestDTO) {
		Optional<DriverDetailsEntity> driveraadhar = driverDetailsRepository
				.findByAadharNumber(driverDetailsRequestDTO.getAadharNumber());
			if (driveraadhar.isPresent()) {
				return Library.getFailResponseCode(ErrorCode.INVALID_DATA.getErrorCode(),
						ResponseMessageConstant.ALREADY_EXISTS.getMessage(new Object[] { "AADHAR" }));
			} else {
				DriverDetailsEntity driverDetailsEntity = new DriverDetailsEntity();
				driverDetailsEntity.setAadharNumber(driverDetailsRequestDTO.getAadharNumber());
				driverDetailsEntity.setCounty(driverDetailsRequestDTO.getCounty());
				driverDetailsEntity.setDistrict(driverDetailsRequestDTO.getDistrict());
				driverDetailsEntity.setDoorNumber(driverDetailsRequestDTO.getDoorNumber());
				driverDetailsEntity.setDrivingLicenseNumber(driverDetailsRequestDTO.getDrivingLicenseNumber());
				driverDetailsEntity.setIsPermanentDriver(driverDetailsRequestDTO.getIsPermanentDriver());
				driverDetailsEntity.setMobileNumber(driverDetailsRequestDTO.getMobileNumber());
				driverDetailsEntity.setName(driverDetailsRequestDTO.getName());
				driverDetailsEntity.setState(driverDetailsRequestDTO.getState());
				driverDetailsEntity.setStatus(driverDetailsRequestDTO.getStatus());
				driverDetailsEntity.setStreet(driverDetailsRequestDTO.getStreet());
				driverDetailsEntity.setVillageOrCity(driverDetailsRequestDTO.getVillageOrCity());
					return Library.getSuccessfulResponse(driverDetailsRepository.save(driverDetailsEntity), ErrorCode.CREATED.getErrorCode(),
							ErrorMessages.RECORED_CREATED);
				}						
	}
	
	@Override
	public GenericResponse update(DriverDetailsRequestDTO driverDetailsRequestDTO) {
		if (Objects.isNull(driverDetailsRequestDTO.getId())) {
			return Library.getFailResponseCode(ErrorCode.BAD_REQUEST.getErrorCode(),
					ResponseMessageConstant.MANDTORY_REQUEST_PARM.getMessage(new Object[] { "ID" }));
		}
		Optional<DriverDetailsEntity> entityOptional = driverDetailsRepository
				.findByAadharNotInId(driverDetailsRequestDTO.getAadharNumber(), driverDetailsRequestDTO.getId());
		if (entityOptional.isPresent()) {
			return Library.getFailResponseCode(ErrorCode.INVALID_DATA.getErrorCode(),
					ResponseMessageConstant.ALREADY_EXISTS.getMessage(new Object[] { "NAME" }));
		}
		entityOptional = driverDetailsRepository.findById(driverDetailsRequestDTO.getId());
		if (!entityOptional.isPresent()) {
			return Library.getFailResponseCode(ErrorCode.INVALID_DATA.getErrorCode(),
					ResponseMessageConstant.INVALID_REQUEST_PARM.getMessage(new Object[] { "ID" }));
		}
		DriverDetailsEntity entity = entityOptional.get();
		entity.setAadharNumber(driverDetailsRequestDTO.getAadharNumber());
		entity.setCounty(driverDetailsRequestDTO.getCounty());
		entity.setDistrict(driverDetailsRequestDTO.getDistrict());
		entity.setDoorNumber(driverDetailsRequestDTO.getDoorNumber());
		entity.setDrivingLicenseNumber(driverDetailsRequestDTO.getDrivingLicenseNumber());
		entity.setIsPermanentDriver(driverDetailsRequestDTO.getIsPermanentDriver());
		entity.setMobileNumber(driverDetailsRequestDTO.getMobileNumber());
		entity.setName(driverDetailsRequestDTO.getName());
		entity.setState(driverDetailsRequestDTO.getState());
		entity.setStatus(driverDetailsRequestDTO.getStatus());
		entity.setStreet(driverDetailsRequestDTO.getStreet());
		entity.setVillageOrCity(driverDetailsRequestDTO.getVillageOrCity());
		driverDetailsRepository.save(entity);
		return Library.getSuccessfulResponse(entity, ErrorCode.CREATED.getErrorCode(), ErrorMessages.RECORED_UPDATED);
	}

	@Override
	public GenericResponse getById(Long id) {
		Optional<DriverDetailsEntity> driverDetails = driverDetailsRepository.findById(id);
		if (!driverDetails.isPresent()) {
//			return Library.getFailResponseCode(ErrorCode.NO_RECORD_FOUND.getErrorCode(),
//					ErrorMessages.NO_RECORD_FOUND);
			
			return Library.getFailResponseCode(ErrorCode.NO_RECORD_FOUND.getErrorCode(),
					ResponseMessageConstant.NO_RECORD_FOUND.getMessage());
		}
		return Library.getSuccessfulResponse(driverDetails, ErrorCode.SUCCESS_RESPONSE.getErrorCode(),
				ErrorMessages.RECORED_FOUND);
	}
	
	@Override
	public GenericResponse getAll() {
		List<DriverDetailsEntity> DepList = driverDetailsRepository.findAllByOrderByIdDesc();
		if (CollectionUtils.isEmpty(DepList)) {
			return Library.getFailResponseCode(ErrorCode.NO_RECORD_FOUND.getErrorCode(),
					ErrorMessages.NO_RECORD_FOUND);
		}
//		List<SiteVisitResponseDTO> depResponseList = DepList.stream().map(sitevisitmapper::entityToResponseDTO)
//				.collect(Collectors.toList());
		return Library.getSuccessfulResponse(DepList, ErrorCode.SUCCESS_RESPONSE.getErrorCode(),
				ErrorMessages.RECORED_FOUND);
	}
	

}