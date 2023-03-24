#!/bin/sh

echo "Iniciando a aplicação..."
#exec service filebeat start & exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "app.jar" "$@"
#exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "app.jar" "$@"
exec filebeat -e -v -c /etc/filebeat/filebeat.yml & exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "app.jar" "$@"