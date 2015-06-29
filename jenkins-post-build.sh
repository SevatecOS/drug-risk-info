#/bin/bash

echo "move the war file into working directory"
mv source/target/DrugRiskInfo.war .

echo "build the new docker file version"
docker build -t mmckinneyatsevatec/drugriskinfo:${BUILD_NUMBER} .

echo "pushing new image to docker hub"
docker push mmckinneyatsevatec/drugriskinfo:${BUILD_NUMBER}

echo "replace BUILD_NUMBER in task definition"
sed -e "s;%BUILD_NUMBER%;g" dri-task-definition.json > dri-task-definition-v_${BUILD_NUMBER}.json

echo "register new task definition with aws"
aws ecs register-task-definition --family dri-task --cli-input-json file://dri-task-definition-v_${BUILD_NUMBER}.json

echo "getting current task def version number"
REV=`aws ecs describe-task-definition --task-definition dri-task | egrep "revision" | tr "/" " " | awk '{print $2}' | sed 's/"$//'`

echo "... ${REV} ..."

echo "updating service"
aws ecs update-service --cluster default --service dri-service --task-definition dri-task:${REV}
