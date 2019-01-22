FROM tomcat:8.5.37-jre8
ARG PACKAGE_NAME

COPY gifts-biz/build/libs/${PACKAGE_NAME} /usr/local/tomcat/webapps/gift-1.0.war
