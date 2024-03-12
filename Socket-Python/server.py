import socket
import threading


def handle_client(client_socket, address):
    while True:
        data = client_socket.recv(1024)
        if not data:
            break
        print(f"Mensagem recebida de {address[0]}:{address[1]}: {data.decode('utf-8')}")

        response = "Mensagem recebida pelo servidor"
        client_socket.send(response.encode("utf-8"))

    client_socket.close()


def start_server(host: str, port: int):
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((host, port))
    server.listen()
    print(f"Servidor ouvindo em: {host}:{port}")

    while True:
        client_socket, address = server.accept()
        print(f"Conexão recebida de {address[0]}:{address[1]}")

        client_handler = threading.Thread(
            target=handle_client, args=(client_socket, address)
        )
        client_handler.start()


start_server("localhost", 8888)
