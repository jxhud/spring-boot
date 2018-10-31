## oahth2.0   密码模式

- 访问无需权限api /product
```java
    127.0.0.1:8088/product/1
```
![访问product](https://github.com/niezhiliang/spring-boot/blob/master/imgs/password-one.png)

- 访问受保护的api /order/1
```java
    127.0.0.1:8088/order/1
```
![访问order](https://github.com/niezhiliang/spring-boot/blob/master/imgs/password-two.png)


- 请求access_token
```java
http://localhost:8088/oauth/token?username=oauth_admin&password=123456789&grant_type=password&
scope=select&client_id=client_2&client_secret=123456789
```
![请求tokne](https://github.com/niezhiliang/spring-boot/blob/master/imgs/request-token.png)

- 带access_token请求受保护的api
```java
127.0.0.1:8088/order/1?access_token=a11d8368-8752-478e-a52c-0cb149e4ee8b
```
![请求tokne](https://github.com/niezhiliang/spring-boot/blob/master/imgs/two-withtoken.png)

- 请求刷新token
```java
http://localhost:8088/oauth/token?grant_type=refresh_token&refresh_token=cb544f60-a3ab-4698-af2c-03ecf3a790f9
&client_id=client_2&client_secret=123456789
```
![请求tokne](https://github.com/niezhiliang/spring-boot/blob/master/imgs/refresh-token.png)






