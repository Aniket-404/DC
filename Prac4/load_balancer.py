import random
import threading
import time

class Server:
    def __init__(self, id):
        self.id = id
        self.active = 0

    def handle(self, req_id):
        self.active += 1
        print(f"Server {self.id} handling {req_id} | Active: {self.active}")
        time.sleep(random.uniform(1, 3))
        self.active -= 1
        print(f"Server {self.id} finished {req_id} | Active: {self.active}")

class LoadBalancer:
    def __init__(self, servers, algo="round_robin"):
        self.servers = servers
        self.algo = algo
        self.idx = 0

    def distribute(self, req_id):
        s = self.servers[self.idx]
        self.idx = (self.idx + 1) % len(self.servers)
        threading.Thread(target=s.handle, args=(req_id,)).start()

if __name__ == "__main__":
    servers = [Server(i) for i in range(3)]
    lb = LoadBalancer(servers, "round_robin")

    for i in range(1, 11):
        time.sleep(random.uniform(0.5, 1.5))
        lb.distribute(i)
