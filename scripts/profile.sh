#!/usr/bin/env bash

function find_idle_profile() {
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/api/profile)

    if [ ${RESPONSE_CODE} -ge 400 ]
    then
      CURRENT_PROFILE=green
    else
      CURRENT_PROFILE=$(curl -s http://localhost/api/profile)
    fi

    if [ ${CURRENT_PROFILE} == blue ]
    then
      IDLE_PROFILE=green
    else
      IDLE_PROFILE=blue
    fi

    echo "${IDLE_PROFILE}"
}

function find_idle_port() {
    IDLE_PROFILE=$(find_idle_profile)

    if [ ${IDLE_PROFILE} == blue ]
    then
      echo "8081"
    else
      echo "8082"
    fi
}