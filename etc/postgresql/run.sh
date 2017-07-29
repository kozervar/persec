#!/usr/bin/env bash
docker build --tag persec-db .
docker stop persec-db
mkdir -p ~/.persec/persec-db/data
#docker run -d --name persec-db -p 5432:5432 -v ~/.persec/persec-db/data:/var/lib/postgresql/data --user $(id -u) persec-db
docker run -d --name persec-db -p 5432:5432 persec-db