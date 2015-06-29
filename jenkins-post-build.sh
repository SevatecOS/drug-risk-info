#/bin/bash

mv source/target/DrugRiskInfo.war .

docker build -t mmckinneyatsevatec/drugriskinfo:latest .

docker push mmckinneyatsevatec/drugriskinfo:latest
