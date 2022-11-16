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