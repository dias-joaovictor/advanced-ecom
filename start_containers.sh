#! /bin/bash

export LOCAL_IP=$(ifconfig en0 | grep -o 'inet [0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}' | cut -d ' ' -f 2 | tr -d '\n')

docker compose up -d