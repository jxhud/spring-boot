http://localhost:8080/oauth/token?grant_type=client_credentials&scope=select&client_id=curl_client&client_secret=user

    
    {
        "access_token": "49dd33f2-9036-4727-9216-18e57d08c55f",
        "token_type": "bearer",
        "expires_in": 4331,
        "scope": "select"
    }

http://localhost:8080/hello

    hello oauth2.0 client_credentitals


http://localhost:8080/index

    {
        "error": "unauthorized",
        "error_description": "Full authentication is required to access this resource"
    }


http://localhost:8080/index?access_token=49dd33f2-9036-4727-9216-18e57d08c55f

    this method is protected by oauth2.0.


