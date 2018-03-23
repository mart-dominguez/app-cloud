sudo docker kill cont-test-cloud
sudo docker rm cont-test-cloud
sudo docker rmi ams/test-cloud
sudo docker build --no-cache -t ams/test-cloud .
sudo docker run -d --net aepad --ip 172.18.0.10 -p 9010:8080 -p 9011:4848 --name cont-test-cloud ams/test-cloud
#sudo docker logs cont-test-cloud

