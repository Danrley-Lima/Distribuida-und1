from http.server import HTTPServer, BaseHTTPRequestHandler
import json
from chatterbot import ChatBot
from chatterbot.trainers import ChatterBotCorpusTrainer
import spacy

nlp = spacy.load("en_core_web_sm")
bot = ChatBot("MeuBot")
trainer = ChatterBotCorpusTrainer(bot)
trainer.train("chatterbot.corpus.portuguese")

class MyHTTPRequestHandler(BaseHTTPRequestHandler):
    def do_POST(self):    
        content_length = int(self.headers['Content-Length'])
        post_data = self.rfile.read(content_length)
        data = json.loads(post_data.decode('utf-8'))

        mensagem = data["mensagem"]
        print(f"Mensagem recebida do cliente: {mensagem}")
        resposta = bot.get_response(mensagem).text

        self.send_response(200)
        self.send_header('Content-type', 'application/json')
        self.end_headers()
        self.wfile.write(json.dumps({"resposta": resposta}).encode('utf-8'))

def start_server(host: str, port: int):
    server_address = (host, port)
    httpd = HTTPServer(server_address, MyHTTPRequestHandler)
    print(f"Servidor ouvindo em: {host}:{port}")
    httpd.serve_forever()


start_server("localhost", 8888)
