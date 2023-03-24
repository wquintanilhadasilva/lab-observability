FROM openjdk:11.0-jre as filebeat

# Instala o filebeat
RUN curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-7.13.0-amd64.deb && \
    dpkg -i filebeat-7.13.0-amd64.deb

ADD filebeat.yml /etc/filebeat/filebeat.yml
RUN chmod go-w /etc/filebeat/filebeat.yml

#CMD service filebeat start

# Instala o metricbeat
FROM filebeat as base
RUN curl -L -O https://artifacts.elastic.co/downloads/beats/metricbeat/metricbeat-oss-7.13.0-amd64.deb && \
    dpkg -i metricbeat-oss-7.13.0-amd64.deb

ADD metricbeat.yml /etc/metricbeat/metricbeat.yml
RUN chmod go-w /etc/metricbeat/metricbeat.yml

# Habilita a coleta de métricas para o linux
RUN metricbeat modules enable linux

FROM base
# Define um usuário diferente de root para rodar a aplicação. Medida de segurança indispensável!
# RUN useradd -ms /bin/bash appuser
# WORKDIR /home/appuser

# RUN chmod 755 /etc/filebeat/filebeat.yml && chown appuser:appuser /etc/filebeat/filebeat.yml

# Copia para a imagem o script de startup da aplicação e concede permissão para o usuário criado
ADD entrypoint.sh entrypoint.sh
# RUN chmod 755 entrypoint.sh && chown appuser:appuser entrypoint.sh

# Copia a versão compilada da aplicação para a imagem
COPY /target/name-generator-service-*.jar app.jar 
#/home/appuser/app.jar
# RUN chown appuser:appuser app.jar

# Define o usuário em execução
# USER appuser

EXPOSE 8080

ENTRYPOINT ["./entrypoint.sh"]