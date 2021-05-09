package com.petclinic.databuilders.factories

import com.petclinic.dto.Visit

import static com.petclinic.databuilders.creators.VisitCreator.sampleVisitRequest

class VisitFactory {

    static Visit visitRequest(String description) {
        sampleVisitRequest([ description: description])
    }
}
