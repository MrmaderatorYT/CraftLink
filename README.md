# CraftLink

CraftLink is an Android client for monitoring and interacting with Minecraft servers. It allows you to connect in the background, track game chat, manage inventory, view real-time coordinates, and navigate using a minimap.

## Features

- **Chat Monitoring:** Read and send messages in real-time.
- **Inventory Management:** View inventory, armor, and offhand slots. Select hotbar slots or drop items.
- **Movement & Minimap:** Track your coordinates and relative position. Move via on-screen controls (W/A/S/D, Shift, Jump/Fly).
- **Auto-Eat:** Automatically consume food when hunger drops below a configurable threshold.
- **Power Saving:** Selectively ignore heavy packets (chunks, entities) to reduce network and CPU usage.
- **App Widgets:** 2x2, 4x1, and 4x2 widgets for one-click connection and real-time status updates.
- **Compatability:** Netty-based Minecraft protocol implementation.

## Tech Stack

- **Language:** Java
- **UI:** XML Layouts (OneUI / Material Design 3 styling)
- **Networking:** Netty (`netty-all`)
- **Reactive Programming:** RxJava 3 and RxRelay
- **Background Support:** Android Foreground Services
- **Widgets:** AppWidgetProvider

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/MrmaderatorYT/CraftLink.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle and run the app on a device or emulator (minSdk 27).

## License

This project is licensed under the GPL-3.0 License. See the [LICENSE](LICENSE) file for details.
