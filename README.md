## Launch dev env
```bash
cd scripts/docker/docker-dev
./run.sh
```

## Run tests
```bash
./gradlew check
```

Test result failure:
```
Too few invocations for:

1 * clearanceService.handleSimpleRequest(_ as SampleRequest) >> { SampleRequest request ->
            assert request.message != null
        }   (0 invocations)

Unmatched invocations (ordered by similarity):

None
```