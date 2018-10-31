### oauth2.0 客户端模式

> 请求token

http://localhost:8080/oauth/token?grant_type=client_credentials&scope=select&client_id=curl_client&client_secret=user

    
    {
        "access_token": "49dd33f2-9036-4727-9216-18e57d08c55f",
        "token_type": "bearer",
        "expires_in": 4331,
        "scope": "select"
    }

> 访问不受保护的api

http://localhost:8080/hello

    hello oauth2.0 client_credentitals


> 不带token访问受保护的api

http://localhost:8080/index

    {
        "error": "unauthorized",
        "error_description": "Full authentication is required to access this resource"
    }

> 带token访问受保护的api

http://localhost:8080/index?access_token=49dd33f2-9036-4727-9216-18e57d08c55f

    this method is protected by oauth2.0.


