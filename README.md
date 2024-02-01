For a simple verification, just run GatewayApplication.
<p>
1. normal<br>
curl --location 'http://localhost:8081/gateway/eureka/echo'<br>
-> use `MyLoadBalancer`
</p>
<p>
2. not registered<br>
curl --location 'http://localhost:8081/new/eureka/echo'<br>
-> use `RoundRobinLoadBalancer`
</p>
