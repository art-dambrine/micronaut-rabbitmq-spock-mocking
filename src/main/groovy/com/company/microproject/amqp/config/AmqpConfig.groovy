package com.company.microproject.amqp.config

import groovy.transform.CompileStatic

@CompileStatic
class AmqpConfig {
    //Exchanges
    public static final String XCH_MWC = "simple.workflow"

    //ROUTING KEYS
    public static final String RK_CLEARANCE  = 'simple.request'
    public static final String RK_CLEARANCE_RESULT = 'simple.result'

    //Queues
    public static final String Q_CLEARANCE = 'simple.request'
}
