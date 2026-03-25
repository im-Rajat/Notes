# Singleton Design Pattern

### Understanding the Singleton Pattern

* **The Core Concept:** A Singleton is a class designed so that we only ever create **one single instance** of it during our entire program. It also provides us with a global way to access that specific instance.
* **The Best Approach:** In modern C++ (C++11 and newer), we use the **Meyers' Singleton**. 
* **Why We Use It:** It is incredibly safe and clean. It automatically handles thread-safety and takes care of memory cleanup for us, which means we don't have to worry about manual deletions or memory leaks.

### How We Build It (The Three Rules)

* **1. The Magic Access Point (`static`):** We create a `getInstance()` method that holds a `static` local variable. C++ guarantees this variable is created only the very first time we call the method. When our program ends, it is automatically destroyed for us.
* **2. Preventing Copies (`= delete`):** We explicitly delete the copy constructor and the assignment operator. This protects our code by ensuring we cannot accidentally clone our single instance. If we try, the compiler will catch it and throw an error.
* **3. The Private Constructor:** We make the constructor and destructor private. This prevents us from creating a new instance the normal way (like typing `Singleton s;`). Instead, we are forced to use our safe `getInstance()` method. 

Let's look at two of the most common, real-world scenarios where our Singleton pattern shines. We will keep the examples simple and focus on *why* we need just one instance.

---

### Scenario 1: The Game Manager

When we are building a game, we usually need a central system to keep track of the main game state, like the player's score or the current level. 

* **The Problem:** If our "Player" creates a score tracker, and our "Enemy" creates a different score tracker, the game won't know which score is the real one! 
* **The Singleton Solution:** By making our `GameManager` a Singleton, we guarantee that every character, item, and level in our game is talking to the exact same scorekeeper.

Here is how we might use it in our code:

```cpp
#include <iostream>

// Our Singleton Game Manager
class GameManager {
public:
    static GameManager& getInstance() {
        static GameManager instance;
        return instance;
    }

    // Delete copy and assignment
    GameManager(const GameManager&) = delete;
    GameManager& operator=(const GameManager&) = delete;

    void addScore(int points) {
        score += points;
        std::cout << "Score updated! Total score is now: " << score << std::endl;
    }

private:
    GameManager() { score = 0; } // Start score at 0
    ~GameManager() {}
    int score;
};

// --- How we use it in our game ---
int main() {
    // A player collects a coin
    std::cout << "Player collects a coin..." << std::endl;
    GameManager::getInstance().addScore(10);

    // An enemy is defeated
    std::cout << "Enemy defeated..." << std::endl;
    GameManager::getInstance().addScore(50);

    // Both actions updated the exact same score!
    return 0;
}
```

---

### Scenario 2: The Central Logger

Imagine our program is very large, and we want it to write warning messages or errors to a text file (a "log") so we can fix bugs later. 

* **The Problem:** If the network system and the graphics system both try to open and write to our log file at the exact same millisecond, the program might crash, or the messages will get scrambled.
* **The Singleton Solution:** We create a single `Logger` Singleton. It acts as a strict gatekeeper. Every part of our program must hand its message to the Singleton, ensuring messages are written to our file safely, one at a time.

Here is what that looks like:

```cpp
#include <iostream>
#include <string>

// Our Singleton Logger
class Logger {
public:
    static Logger& getInstance() {
        static Logger instance;
        return instance;
    }

    Logger(const Logger&) = delete;
    Logger& operator=(const Logger&) = delete;

    void logMessage(const std::string& message) {
        // In a real app, this would write to a file safely.
        // For now, we just print it to the screen.
        std::cout << "[LOG]: " << message << std::endl;
    }

private:
    Logger() { std::cout << "Logger started." << std::endl; }
    ~Logger() { std::cout << "Logger shut down." << std::endl; }
};

// --- How we use it in our program ---
int main() {
    // The database system encounters an issue
    Logger::getInstance().logMessage("Database connection failed!");

    // The user interface loads successfully
    Logger::getInstance().logMessage("User interface loaded successfully.");

    return 0;
}
```
