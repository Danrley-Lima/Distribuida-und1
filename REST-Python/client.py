import requests

def start_client(host: str, port: int):
    url = f"http://{host}:{port}/mensagem"
    
    end = False
    
    while not end:
        message = input("Digite sua mensagem: ")

        if message == "tt":
            end = True
        else:
            data = {"mensagem": message}
            response = requests.post(url, json=data)
            print("Resposta do servidor:", response.json()["resposta"])

start_client("localhost", 8888)