#! /bin/bash

PROJECT_FILE=${1:-Project File not defined}
ARTIFACT_NAME=${2:-Project File not defined}


mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/configuration
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/converter
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/entity
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/messaging/consumer
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/messaging/producer
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/model/inbound
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/model/outbound
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/repository
mkdir -p $PROJECT_FILE/src/main/java/br/com/dias/${ARTIFACT_NAME}/service