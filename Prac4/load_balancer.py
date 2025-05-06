import random
import threading
import time

servers = [{"id": i, "active": 0} for i in range(3)]
idx = 0

def handle(server, req_id):
    server["active"] += 1
    print(f"Server {server['id']} handling {req_id} | Active: {server['active']}")
    time.sleep(random.uniform(1, 3))
    server["active"] -= 1
    print(f"Server {server['id']} finished {req_id} | Active: {server['active']}")

def distribute(req_id):
    global idx
    server = servers[idx]
    idx = (idx + 1) % len(servers)
    threading.Thread(target=handle, args=(server, req_id)).start()

if __name__ == "__main__":
    for i in range(1, 11):
        time.sleep(random.uniform(0.5, 1.5))
        distribute(i)
