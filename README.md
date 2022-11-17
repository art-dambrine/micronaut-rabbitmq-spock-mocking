## Launch dev env
```bash
cd scripts/docker/docker-dev
./run.sh
```

## Run tests
```bash
export DEPLOYMENT=DEV
export RABBITMQ_HOST=localhost
export RABBITMQ_PORT=5672
export RABBITMQ_VIRTUALHOST=/
./gradlew check
```

Test result failure: (now solved see: https://stackoverflow.com/questions/74463717/how-to-mock-a-service-with-spock-in-micronaut-when-testing-a-rabbit-consumer)
```
Too few invocations for:

1 * simpleService.handleSimpleRequest(_ as SampleRequest) >> { SampleRequest request ->
            assert request.message != null
        }   (0 invocations)

Unmatched invocations (ordered by similarity):

None
```
