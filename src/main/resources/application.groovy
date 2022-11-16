//tag::env[]
Map env = System.getenv() + new HashMap(System.properties)
//end::env[]

rabbitmq {
    host = env.RABBITMQ_HOST
    port = env.RABBITMQ_PORT
    virtualHost = env.RABBITMQ_VIRTUALHOST

    Map secrets = [username: "guest", password: "guest"]
    username = secrets.username
    password = secrets.password
    requestedHeartbeat = 30
}