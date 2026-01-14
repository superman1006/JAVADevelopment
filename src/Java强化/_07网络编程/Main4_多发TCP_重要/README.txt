要实现一个 TCP服务器能够接受多个 Client 的连接：
Server：
    Server 中要使用多线程来处理每个 Client 的请求。
    也就是每一个 client 进来之后，server 都给他开一个线程来处理，用 while
    这个线程我定义为 ServerThread，内容要不断的读取当前 client 发送的 msg，当输入 exit 是跳出 while

Client：
    不变

结构：
                        Server
                          ｜
                    ServerSocket(ss)
                          ｜
                  ┌─────────────────┐────────────┐
               socket1           socket2        ....
                  │                 │
            ServerThread1    ServerThread2      ....
                  │                 │
               Client1           Client2        ....
                  │                 │
                while             while         ....


