package com.petclinic.databuilders.utils

import groovy.transform.CompileStatic

@CompileStatic
class PropertiesValidator {

    static void validatePropertyNames(Map allowedProperties, Map candidateProperties){
        Set allowedPropertyNames = allowedProperties.keySet()
        Set candidatePropertyNames = candidateProperties.keySet()

        Set illegalPropertyNames = candidatePropertyNames - allowedPropertyNames

        if(!illegalPropertyNames.empty){
            throw  new IllegalArgumentException("Validation failed. Unknown properties: ${illegalPropertyNames}")
        }
    }
}
