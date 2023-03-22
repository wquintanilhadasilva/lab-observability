#!/bin/bash

filebeat modules enable nginx
filebeat setup
service filebeat start
nginx -g 'daemon off;'

#echo "Iniciando o Filebeat e a Aplicação..."
#exec filebeat -e -v -c /etc/filebeat/filebeat.yml
#exec filebeat -e -v -c ./filebeat.yml & exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "app.jar" "$@"