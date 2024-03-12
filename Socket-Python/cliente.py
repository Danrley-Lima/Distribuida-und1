import socket


def start_client(host: str, port: int):
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect((host, port))

    end = False

    while not end:
        message = input("Digite sua mensagem: ")
        client.send(message.encode("utf-8"))

        if message == "tt":
            end = True
        else:
            response = client.recv(1024).decode("utf-8")
            print("Resposta do servidor:", response)


start_client("localhost", 8888)
