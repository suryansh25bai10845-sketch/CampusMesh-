# CampusMesh-
CampusMesh is a Java-based internet-independent peer-to-peer campus communication network designed for offline communication. It supports peer discovery, messaging, file sharing, multi-hop routing, store-and-forward communication, synchronization, and SOS alerts without relying on the Internet or cellular networks.
# CampusMesh

### Internet-Independent Peer-to-Peer Campus Communication Network

## About the Project

CampusMesh is a Java-based project made to explore how communication can work when the Internet or mobile network is not available.

The basic idea is simple: nearby devices can act as nodes and communicate with each other. If two devices cannot communicate directly, a message can travel through other connected devices.

This project is a prototype that demonstrates offline messaging, routing, file sharing, synchronization, and emergency communication using a local network.

## What CampusMesh Can Do

- Discover and manage network nodes
- Send messages between nodes
- Find routes between devices using BFS
- Store messages when the destination is offline
- Deliver stored messages when the device reconnects
- Share files between nodes
- Check file integrity using SHA-256
- Send SOS emergency alerts
- Synchronize information between nodes
- Maintain network activity logs
- Handle multiple connections using multithreading

**Note:** This version is a prototype and uses local TCP/IP communication. Real Bluetooth or Wi-Fi Direct device discovery has not been implemented yet.

## Technologies Used

- Java
- Maven
- TCP/IP
- ServerSocket
- Multithreading
- BFS (Breadth-First Search)
- SHA-256
- Command Line Interface (CLI)

## Project Structure

```text
CampusMesh/
├── src/
│   └── app/
│       └── NetworkApp.java
├── model/
├── network/
├── routing/
├── service/
├── security/
├── storage/
├── data/
├── tests/
├── screenshots/
├── pom.xml
└── README.md
