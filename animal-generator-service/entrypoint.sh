#!/bin/sh

#echo "Iniciando o Filebeat e a Aplicação..."
#exec filebeat -e -v -c /etc/filebeat/filebeat.yml
#exec filebeat -e -v -c ./filebeat.yml & exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "app.jar" "$@"

echo "Iniciando a aplicação..."
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.jar" "$@"