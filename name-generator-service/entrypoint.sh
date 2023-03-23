#!/bin/sh

echo "Iniciando a aplicação..."
#exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.jar" "$@"
exec filebeat -e -v -c /etc/filebeat/filebeat.yml & exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "app.jar" "$@"