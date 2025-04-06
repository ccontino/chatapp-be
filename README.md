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

Creare la tabella nello schema sse_demo
```sql
DROP TABLE IF EXISTS `chat_message`;
CREATE TABLE `chat_message` (
                                `id` integer(11) NOT NULL AUTO_INCREMENT,
                                `nickname` varchar(255) DEFAULT NULL,
                                `message` TEXT DEFAULT NULL,
                                `created_at` datetime DEFAULT NOW(),
                                PRIMARY KEY (`id`)
);
```