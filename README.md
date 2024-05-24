# Сервис бронирования отелей
Данный проект представляет собой серверную часть сервиса бронирования отелей.  

Для запуска запустить statefulSet-ы из директории kuber-config/statefulset командой:
```Shell
kubectl apply .
```

Далее запустить kafka и zookeeper, лежащие в директории kuber-config/kafka с помощью такой же команды
```Shell
kubectl apply .
```

Далее запускать микросервисы по очереди:  
1. gateway
2. grade-service
3. hotel-booking-service
4. hotel-info-service
5. notification

Конфигурация kubernetes для каждого микросервиса находится в одноименной директории. Запуск командой:
```Shell
kubectl apply .
```
