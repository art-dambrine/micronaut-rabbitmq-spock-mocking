package com.company.microproject.service

import com.company.microproject.command.SampleRequest
import jakarta.inject.Singleton

@Singleton
class SimpleService {
    void handleSimpleRequest(SampleRequest sampleRequest) {
        println("service received request: $sampleRequest")
    }
}
