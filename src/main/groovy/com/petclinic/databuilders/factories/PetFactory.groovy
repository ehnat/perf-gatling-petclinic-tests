package com.petclinic.databuilders.factories

import com.petclinic.dto.Pet

import static com.petclinic.databuilders.creators.PetCreator.samplePetRequest

class PetFactory {

    static Pet petRequest(String petName) {
        samplePetRequest([name: petName])
    }
}
