package com.capstone.mini.petini.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.mini.petini.dto.request.PetiniAfterCareRequestDto;
import com.capstone.mini.petini.dto.response.PetiniAfterCareResponseDto;
import com.capstone.mini.petini.model.PetiniAfterCare;
import com.capstone.mini.petini.service.IPetiniAfterCareService;

import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/after-care")
public class AfterCareController {
    @Autowired
    private IPetiniAfterCareService afterCareService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/new-service")
    @Authorization("hasRole('ROLE_SHOPOWNER')")
    public ResponseEntity<?> createService(@RequestBody PetiniAfterCareRequestDto petiniAfterCareRequestDto) {
        PetiniAfterCare petiniAfterCare = modelMapper.map(petiniAfterCareRequestDto, PetiniAfterCare.class);
        PetiniAfterCare savedService = afterCareService.createService(petiniAfterCare);
        PetiniAfterCareResponseDto responseService = modelMapper.map(savedService, PetiniAfterCareResponseDto.class);

        return new ResponseEntity<PetiniAfterCareResponseDto>(responseService, HttpStatus.OK);
    }

    @GetMapping("/allow-all/info")
    public ResponseEntity<?> getServiceDetail(String name) {
        PetiniAfterCare petiniAfterCare = afterCareService.getPetiniAfterCareByName(name);
        PetiniAfterCareResponseDto responseService = modelMapper.map(petiniAfterCare, PetiniAfterCareResponseDto.class);

        return new ResponseEntity<PetiniAfterCareResponseDto>(responseService, HttpStatus.OK);
    }

    @GetMapping("/allow-all/service-list")
    public ResponseEntity<?> getServiceList() {
        List<PetiniAfterCare> petiniAfterCares = afterCareService.getPetiniAfterCareList();
        List<PetiniAfterCareResponseDto> responseServices = petiniAfterCares.stream()
                .map(s -> modelMapper.map(s, PetiniAfterCareResponseDto.class)).collect(Collectors.toList());

        return new ResponseEntity<List<PetiniAfterCareResponseDto>>(responseServices, HttpStatus.OK);
    }

    @PutMapping("/update-service")
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    public ResponseEntity<?> updateService(String serviceName,
            @RequestBody PetiniAfterCareRequestDto newServiceRequest) {
        PetiniAfterCare petiniAfterCare = modelMapper.map(newServiceRequest, PetiniAfterCare.class);
        PetiniAfterCare updatedAfterCare = afterCareService.updatePetiniAfterCare(serviceName, petiniAfterCare);
        PetiniAfterCareResponseDto responseAfterCare = modelMapper.map(updatedAfterCare,
                PetiniAfterCareResponseDto.class);

        return new ResponseEntity<PetiniAfterCareResponseDto>(responseAfterCare, HttpStatus.OK);
    }

    @DeleteMapping("/delete-service")
    @PreAuthorize("hasRole('ROLE_SHOPOWNER')")
    public ResponseEntity<?> deleteService(String serviceName) {
        PetiniAfterCare petiniAfterCare = afterCareService.deletePetiniAfterCare(serviceName);
        PetiniAfterCareResponseDto responseService = modelMapper.map(petiniAfterCare, PetiniAfterCareResponseDto.class);
        
        return new ResponseEntity<PetiniAfterCareResponseDto>(responseService, HttpStatus.OK);
    }
}
