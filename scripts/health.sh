#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh
source ${ABSDIR}/switch.sh

IDLE_PORT=$(find_idle_port)
IDLE_PROFILE=$(find_idle_profile)

echo "> Health 체크 시작"
echo "> IDLE_PORT: $IDLE_PORT"
echo "> curl -s http://localhost:$IDLE_PORT/api/profile"
sleep 10

for RETRY_COUNT in {1..10}
do
  RESPONSE=$(curl -s https://localhost:$IDLE_PORT/api/profile)
#  UP_COUNT=$(echo ${RESPONSE})

  if [ ${RESPONSE} -ge ${IDLE_PROFILE} ]
  then
    echo "> Health 체크 성공"
    switch_proxy
    break
  else
    echo "> Health 체크의 응답을 알 수 없거나 혹은 실행 상태가 아닙니다."
    echo "> Health 상태: ${RESPONSE}"
  fi

  if [ ${RETRY_COUNT} -eq 10 ]
  then
    echo "> Health 체크 실패"
    echo "> nginx에 연결하지 않고 배포를 종료합니다."
    exit 1
  fi

  echo "> Health 체크 연결 실패. 재시도..."
  sleep 10
done