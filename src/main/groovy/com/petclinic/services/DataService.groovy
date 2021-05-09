package com.petclinic.services

import com.petclinic.dto.Owner
import com.petclinic.dto.Pet
import com.petclinic.dto.PetType
import groovy.transform.CompileStatic

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class DataService {

    private static final String PET = "/pets/{id}"
    private static final String PET_TYPE = '/pettypes/{petTypeId}'
    private static final String OWNER = "/owners/{ownerId}"

    static Owner getOwner(int ownerId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('ownerId', ownerId)
        .when()
                .get(OWNER)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Owner>as(Owner)
        //@formatter:on
    }

    static PetType getPetType(int petTypeId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('petTypeId', petTypeId)
        .when()
                .get(PET_TYPE)
        .then()
                .statusCode(SC_OK)
                .extract().response().<PetType>as(PetType)
        //@formatter:on
    }

    static Pet getPet(int petId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('id', petId)
        .when()
                .get(PET)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Pet>as(Pet)
        //@formatter:on
    }
}
