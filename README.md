# Getting Started


Avviare MySQL creando un DB sse_demo
```bash
docker run -d \
  --name mysql-sse-demo \
  -e MYSQL_ROOT_PASSWORD=password \
  -e MYSQL_DATABASE=sse_demo \
  -p 3306:3306 \
  mysql:8.0 \
  --default-authentication-plugin=mysql_native_password
```

```powershell
docker run -d `
  --name mysql-sse-demo `
  -e MYSQL_ROOT_PASSWORD=password `
  -e MYSQL_DATABASE=sse_demo `
  -p 3306:3306 `
  mysql:8.0 `
  --default-authentication-plugin=mysql_native_password
```