package com.petclinic.databuilders.creators

import com.github.javafaker.Faker
import com.petclinic.databuilders.utils.Utils
import com.petclinic.dto.Owner
import com.petclinic.dto.Pet
import com.petclinic.dto.PetType
import com.petclinic.dto.VisitResponse
import groovy.transform.CompileStatic

import static com.petclinic.databuilders.utils.PropertiesValidator.validatePropertyNames
import static com.petclinic.services.DataService.getOwner
import static com.petclinic.services.DataService.getPetType

@CompileStatic
class PetCreator {

    private static final Faker FAKER = new Faker()

    private static final Map DEFAULT_PET_PROPERTIES = [
            birthDate: Utils.todayDate,
            id       : 0,
            name     : FAKER.name().firstName(),
            owner    : getOwner(1),
            type     : getPetType(2),
            visits   : []
    ]

    static Pet samplePetRequest(Map properties = [:]) {
        validatePropertyNames(DEFAULT_PET_PROPERTIES, properties)

        properties = DEFAULT_PET_PROPERTIES + properties

        return new Pet(
                birthDate: properties.birthDate as String,
                id: properties.id as int,
                name: properties.name as String,
                owner: properties.owner as Owner,
                type: properties.type as PetType,
                visits: properties.visits as List<VisitResponse>
        )
    }
}
