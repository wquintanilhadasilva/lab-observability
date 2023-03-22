FROM openjdk:11.0-jre

# Configura o filebeat para enviar os logs para o Elasticsearch
#RUN curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-7.13.0-amd64.deb && \
#    dpkg -i filebeat-7.13.0-amd64.deb
#
#COPY filebeat.yml /etc/filebeat/filebeat.yml

# RUN service filebeat start

# Define um usuário diferente de root para rodar a aplicação. Medida de segurança indispensável!
RUN useradd -ms /bin/bash appuser
WORKDIR /home/appuser

#COPY filebeat.yml filebeat.yml

# Copia para a imagem o script de startup da aplicação e concede permissão para o usuário criado
ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown appuser:appuser entrypoint.sh

# Copia a versão compilada da aplicação para a imagem
COPY /target/animal-generator-service-*.jar app.jar
RUN chown appuser:appuser app.jar

# Define o usuário em execução
USER appuser

EXPOSE 8081

ENTRYPOINT ["./entrypoint.sh"]