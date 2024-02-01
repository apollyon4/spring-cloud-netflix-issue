For a simple verification, just run GatewayApplication.

1. normal
curl --location 'http://localhost:8081/gateway/eureka/echo'
-> use `MyLoadBalancer`

2. not registered
curl --location 'http://localhost:8081/new/eureka/echo'
-> use `RoundRobinLoadBalancer`
