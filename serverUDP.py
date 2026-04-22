import socket

HOST = '100.122.92.96'  
PORT = 5005

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server_socket:
    
    server_socket.bind((HOST, PORT))
    
    print(f"The UDP server is running on {HOST}, port {PORT}...")
    
    while True:
        data, client_address = server_socket.recvfrom(1024)
        
        if data:
            text_message = data.decode('utf-8')
            print(f"Message received from client {client_address}: {text_message}")