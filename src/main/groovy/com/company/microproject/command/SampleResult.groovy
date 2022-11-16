package com.company.microproject.command

import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected

@Introspected
@CompileStatic
class SampleResult {
    Integer status
    String message

    Map asMap() {
        [
                status : status,
                message: message
        ]
    }
}
