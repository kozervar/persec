#!/usr/bin/env bash
docker run -it --rm --link persec-db:postgres persec-db psql -h postgres -U persec