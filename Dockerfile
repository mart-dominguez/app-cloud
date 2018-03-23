# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
#ADD mysql-connector-java-5.1.44.jar jdbc/mysql-connector-java-5.1.44.jar
FROM payara/micro:4.181
RUN echo $PAYARA_PATH
#WORKDIR /opt
# EXPOSE 8080
#ADD domain.xml $PAYARA_PATH
ADD mysql-connector-java-5.1.46.jar $PAYARA_PATH/database-connector.jar
ADD target/app-api-rest-1.1.1.war  $PAYARA_PATH/myapplication.war
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addJars", "/opt/payara/database-connector.jar", "--deploy", "/opt/payara/myapplication.war"]

#ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addJars", "/opt/payara/database-connector.jar", "--deploy", "/opt/payara/myapplication.war","--domainConfig","/opt/payara/domain.xml"]
#ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addJars", "/opt/payara/database-connector.jar", "--deploy", "/opt/payara/arq-app-productos-1.0-SNAPSHOT.war","--domainConfig","/opt/payara/domain.xml"]
#ENTRYPOINT java -jar -cp "/opt/jdbc/mysql-connector-java-5.1.44.jar:/opt/payara/micro.jar" /opt/payara/payara-micro.jar --deploy /opt/app/arq-app-productos-1.0-SNAPSHOT.war --domainConfig domain.xml 