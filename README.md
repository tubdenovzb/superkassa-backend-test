## superkassa-backend-test
Тестовое задание для SUPERKASSA

## Технологии
Spring Boot, Gradle, Postgres

## Предварительные условия:
Предзаполненная таблица в базе данных postgres. 
Имя пользователя и название таблицы должно точно соответствовать указанным.

    dropdb --if-exists sk_example_db
    dropuser --if-exists sk_example_user
    createuser sk_example_user -P
    createdb -O sk_example_user sk_example_db
    psql -U sk_example_user -d sk_example_db <<EOF
    CREATE TABLE sk_example_table (id SERIAL, obj JSONB NOT NULL, PRIMARY KEY(id));
    INSERT INTO sk_example_table (obj) VALUES ('{"current":0}'::JSONB);
    EOF

## Условие задачи:
Spring приложение с обработкой POST запроса по урлу /modify

##### Запрос удовлетворяет JSON схеме:
```
{
    "id": <number>,
    "current": <number>
}
```

##### Ответ удовлетворяет JSON схеме:
```
{
    "current": <number>
}
```
