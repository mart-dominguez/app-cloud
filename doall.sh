#mysql
#sudo docker pull mysql
#sudo docker run -d --net aepad --ip 172.18.0.2 -p 3336:3306 -e MYSQL_ROOT_PASSWORD=root --name tp-mysql mysql
#sudo docker run -d --net aepad --ip 172.18.0.6 --name tp-myadmin --link tp-mysql:db -p 9001:80 phpmyadmin/phpmyadmin
sudo docker kill cont-test-cloud
sudo docker rm cont-test-cloud
sudo docker rmi ams/test-cloud
sudo docker build --no-cache -t ams/test-cloud .
sudo docker run -d --net aepad --ip 172.18.0.3 -p 9010:8080 --link tp-mysql:database --name cont-test-cloud ams/test-cloud
#sudo docker logs cont-test-cloud

