FROM mmckinneyatsevatec/tomcat:v1

ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
WORKDIR $CATALINA_HOME

RUN set -x \
	&& curl -fSL "https://s3-us-west-2.amazonaws.com/drugriskinfo/source/target/DrugRiskInfo.war" -o ROOT.war \
	&& mv $CATALINA_HOME/webapps/ROOT /tmp/. \
	&& mv ROOT.war $CATALINA_HOME/webapps/. 

EXPOSE 8080
CMD ["catalina.sh", "run"]
