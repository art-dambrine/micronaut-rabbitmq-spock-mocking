package com.company.microproject.amqp.config

import groovy.transform.CompileStatic

@CompileStatic
class TestAmqpConfig {
    public static final String Q_CLEARANCE_RESULT = 'simple.result.tmp'
    public static final String RK_CLEARANCE_RESULT = AmqpConfig.RK_CLEARANCE_RESULT
}
