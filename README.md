# springboot-hystrix
First knowledge about hystrix

- [How-To-Use](https://github.com/Netflix/Hystrix/wiki/How-To-Use)
- [Hystrix/wiki](https://github.com/Netflix/Hystrix/wiki)
- [hystrix/examples](https://github.com/Netflix/Hystrix/tree/master/hystrix-examples/src/main/java/com/netflix/hystrix/examples)
- [Netflix/Hystrix](https://github.com/Netflix/Hystrix)

- [译 Hystrix 从入门到深入](https://blog.csdn.net/lemon89/article/details/80460876)
- [springcloud hystrix](https://blog.csdn.net/liaokailin/article/details/51339357)
- [Hystrix入门](http://fobject.iteye.com/blog/2337582)

## How to use

- `execute()` 返回从依赖项收到的单个响应（或者在发生错误时抛出异常）
- `queue()` 返回一个 Future，您可以使用它从依赖项中获取单个响应 
- `observe()` 订阅表示来自依赖项的响应的 Observable，并返回一个 Observable，它复制该源 Observable
- `toObservable()` 返回一个 Observable，当您订阅它时，将执行 Hystrix 命令并发出其响应

- [hystrix dashboard Unable to connect to Command Metric Stream解决办法](https://www.cnblogs.com/mark7/p/8920288.html)

- [hystrix_clients_doc官方文档](http://cloud.spring.io/spring-cloud-netflix/multi/multi__circuit_breaker_hystrix_clients.html)

## LICENSE

![](LICENSE.png)