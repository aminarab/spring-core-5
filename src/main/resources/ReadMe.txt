for more bean scope samples : https://www.baeldung.com/spring-bean-scopes

http://localhost:8080/scopes/requestBeans
https://github.com/mogronalol/spring-data-overview-pluralsight


REST Versioning
http://localhost:8080/noversioning/hello
http://localhost:8080/v2/urlversioning/hello
http://localhost:8080/v3/urlversioning/hello

Right REST Design
http://localhost:8080/car/1
{"id":1,"name":null}

Wrong REST Design
http://localhost:8080/ship/read?id=2
{"id":null,"dto":{"id":2,"name":"benz"},"errorCode":null,"message":null}

