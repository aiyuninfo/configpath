# config-path
配置虚拟路径的工具

必须是spring 项目并且集成 spring mvc
必须配置三个属性：


`upload.path`   本地文件夹路径或者resource文件夹路径比如 D:/abc/ (注：D:/abc/最后一个/必须存在)，或者static,此处的static文件夹必须在resource文件夹下<br/>
`vm.resource.path`  映射的路径比如 web，此时本地文件夹可以使用这个映射来直接访问文件<br/>
`vm.resource.type`  映射类型，如果是本地文件夹绝对路径，type为 file ,resource文件夹内的，type 为classpath<br/>

配置示例：

`yml:`<br/>
```Java
upload:
    path: D:/imgUploader/
vm:
    resource:
        path: web
        type: file
```
`properties:`<br/>

```Java
upload.path=D:/imgUploader/
vm.resource.path=web
vm.resource.type=file
```

访问： http://localhost:8080/web/123.jpg
```Java
upload:
    path: /myResource/
vm:
    resource:
        path: myres
        type: classpath
```
访问： http://localhost:8080/myres/123.jpg<br>

#maven
```xml
<dependency>
  <groupId>com.aiyun</groupId>
  <artifactId>config-path</artifactId>
  <version>0.0.1</version>
</dependency>
```
