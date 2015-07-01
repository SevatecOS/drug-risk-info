FROM tomcat:8.0
MAINTAINER sevatec.com

WORKDIR $CATALINA_HOME

RUN rm -rf $CATALINA_HOME/webapps/*

ADD drugriskinfo.war $CATALINA_HOME/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
