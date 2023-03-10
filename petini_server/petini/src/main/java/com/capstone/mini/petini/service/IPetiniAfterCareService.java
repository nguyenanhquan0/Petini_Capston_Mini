package com.capstone.mini.petini.service;

import java.util.List;

import com.capstone.mini.petini.model.PetiniAfterCare;

public interface IPetiniAfterCareService {
    PetiniAfterCare createService(PetiniAfterCare petiniAftCare);

    PetiniAfterCare getPetiniAfterCareByName(String name);

    List<PetiniAfterCare> getPetiniAfterCareList();

    PetiniAfterCare updatePetiniAfterCare(String serviceName, PetiniAfterCare newService);

    PetiniAfterCare deletePetiniAfterCare(String serviceName);

}
