#!/usr/bin/env bash
set -xe
arch="${ARCH:-amd64}"
cd $arch
source ../init_env-dev.sh
docker-compose up --build -d $*
cd ..
