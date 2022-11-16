package com.company.microproject.command

class SampleRequest {
    String message

    Map asMap() {
        [
                message: message
        ]
    }

    static SampleRequest fromMap(Map clearanceRequest) {
        new SampleRequest(
                message: clearanceRequest.message
        )
    }
}
