[![Build Status](https://travis-ci.org/claudioaltamura/springboot-cache.svg?branch=master)](https://travis-ci.org/claudioaltamura/springboot-cache)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# springboot-cache
springboot example with caching

# examples

Get messages

```
$ curl http://127.0.0.1:8080/messages

[{"id":1,"message":"Hallo"},{"id":2,"message":"Hello"},{"id":3,"message":"ciao"}]
```

Add messages

```
$ curl -X POST -H "Content-Type:application/json" http://localhost:8080/messages -d '{"message":"ciao"}' {"id":3,"message":"ciao"}
```

Delete messages

```
$ curl -X DELETE http://127.0.0.1:8080/messages/3

$ curl http://127.0.0.1:8080/messages
[{"id":1,"message":"Hallo"},{"id":2,"message":"Hello"}]
```