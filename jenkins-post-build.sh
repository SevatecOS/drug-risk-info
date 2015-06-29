#/bin/bash

mv source/target/DrugRiskInfo.war ROOT.war

docker build -t mmckinneyatsevatec/drugriskinfo:latest .

docker push mmckinneyatsevatec/drugriskinfo:latest
