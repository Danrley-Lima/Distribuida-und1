import socket
import threading
from chatterbot import ChatBot
from chatterbot.trainers import ChatterBotCorpusTrainer
import spacy

nlp = spacy.load("en_core_web_sm")


def handle_client(client_socket, address, bot: ChatBot):
    while True:
        data = client_socket.recv(1024)
        if not data:
            break
        response = data.decode("utf-8")
        print(f"Mensagem recebida de {address[0]}:{address[1]}: {response}")

        response = bot.get_response(response).text
        client_socket.send(response.encode("utf-8"))

    client_socket.close()


def start_server(host: str, port: int):
    bot = ChatBot("MeuBot")
    trainer = ChatterBotCorpusTrainer(bot)
    trainer.train("chatterbot.corpus.portuguese")

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server.bind((host, port))
    server.listen()
    print(f"Servidor ouvindo em: {host}:{port}")

    while True:
        client_socket, address = server.accept()
        print(f"Conexão recebida de {address[0]}:{address[1]}")

        client_handler = threading.Thread(
            target=handle_client, args=(client_socket, address, bot)
        )
        client_handler.start()


start_server("localhost", 8888)
