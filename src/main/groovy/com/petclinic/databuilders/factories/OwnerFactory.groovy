package com.petclinic.databuilders.factories

import com.petclinic.dto.Owner

import static com.petclinic.databuilders.creators.OwnerCreator.sampleOwnerRequest

class OwnerFactory {

    static Owner getOwner(String firstName) {
        sampleOwnerRequest([firstName: firstName])
    }
}
