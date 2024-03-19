# Distribuída-und1

## Java RMI:

Compilar o java rmi:
```
  javac -d RMI-Java/bin RMI-Java/src/chatbot/*.java RMI-Java/src/*.java
```
Rodar o servidor java rmi:
```
  java -cp RMI-Java/bin MessageServiceImpl
```
Rodar o cliente java rmi:
```
  java -cp RMI-Java/bin Client
```

***

## Python Socket:

Criar ambiente:
```
  python -m venv Socket-Python
```
Instale as dependências:
```
  pip install --upgrade --no-deps --force-reinstall -r requirements.txt
```
Rodar o servidor socket:
```
  python .\Socket-Python\server.py
```
Rodar o cliente socket:
```
  python .\Socket-Python\client.py
```