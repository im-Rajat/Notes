# Singleton Design Pattern

### Understanding the Singleton Pattern

* **The Core Concept:** A Singleton is a class designed so that we only ever create **one single instance** of it during our entire program. It also provides us with a global way to access that specific instance.
* **The Best Approach:** In modern C++ (C++11 and newer), we use the **Meyers' Singleton**. 
* **Why We Use It:** It is incredibly safe and clean. It automatically handles thread-safety and takes care of memory cleanup for us, which means we don't have to worry about manual deletions or memory leaks.

### The Modern Reference Way (`&`) vs. The Classic Pointer Way (`*`)

You might occasionally see older code using a pointer to return the instance (often called the classic "Gang of Four" approach). However, modern C++ developers strongly prefer returning a reference (`static Singleton& getInstance()`). 

Here is a straightforward breakdown of why the modern Reference method wins over the older Pointer method:

| Feature | The Pointer Way (`Singleton*`) | The Modern Reference Way (`Singleton&`) |
| :--- | :--- | :--- |
| **Memory Cleanup** | **Manual:** We must use `new` and remember to call `delete`, which easily causes memory leaks. | **Automatic:** C++ handles it entirely. Zero memory leaks! |
| **Thread-Safe?** | **No:** If two threads ask for it at the exact same microsecond, they might both create an instance, breaking the rule. | **Yes:** Built into modern C++ (C++11 and newer). It is guaranteed to only create one. |
| **Code Setup** | **Messier:** Requires extra boilerplate code to initialize the pointer outside the class. | **Cleaner:** Everything is completely self-contained inside the function. |
| **Usage safety** | **Risky:** Pointers can technically be null, requiring extra checks. | **Safe:** A reference cannot be null, so we can trust it is always there. |

Let's look at two real-world scenarios to see exactly how these two approaches look in practice. 

---

### Scenario 1: The Game Manager (Using the Older Pointer Way)

When we are building a game, we usually need a central system to keep track of the main game state, like the player's score. By making our `GameManager` a Singleton, we guarantee that every character and level in our game is talking to the exact same scorekeeper.

Here is how we build it using the **older, pointer-based approach**. Notice how we have to initialize the pointer outside the class, and use the arrow (`->`) operator to access methods.

```cpp
#include <iostream>

// Our Singleton Game Manager (The Older Pointer Way)
class GameManager {
private:
    // 1. A static pointer to hold our single instance
    static GameManager* instance;
    int score;

    // 2. Private constructor
    GameManager() { score = 0; }
    ~GameManager() {}

    // 3. Prevent copying
    GameManager(const GameManager&) = delete;
    GameManager& operator=(const GameManager&) = delete;

public:
    // 4. The access point that creates the instance manually using 'new'
    static GameManager* getInstance() {
        if (instance == nullptr) {
            instance = new GameManager();
        }
        return instance;
    }

    void addScore(int points) {
        score += points;
        std::cout << "Score updated! Total score is now: " << score << std::endl;
    }
};

// 5. We MUST initialize the static pointer outside the class!
GameManager* GameManager::instance = nullptr;

// --- How we use it in our game ---
int main() {
    // A player collects a coin
    std::cout << "Player collects a coin..." << std::endl;
    GameManager::getInstance()->addScore(10); // Notice the arrow (->) operator!

    // An enemy is defeated
    std::cout << "Enemy defeated..." << std::endl;
    GameManager::getInstance()->addScore(50);

    return 0;
}
```

---

### Scenario 2: The Central Logger (Using the Modern Reference Way)

Imagine our program is very large, and we want it to write warning messages to a log file. We create a single `Logger` Singleton to act as a strict gatekeeper, ensuring messages are safely written one at a time.

Here is how we build it using the **modern Meyers' Singleton approach**. Notice how much cleaner it is! There is no manual `new`, no outside initialization, and it is completely thread-safe.

```cpp
#include <iostream>
#include <string>

// Our Singleton Logger (The Modern Reference Way)
class Logger {
public:
    // 1. The safe, automatic access point
    static Logger& getInstance() {
        static Logger instance;
        return instance;
    }

    // 2. Prevent copying
    Logger(const Logger&) = delete;
    Logger& operator=(const Logger&) = delete;

    void logMessage(const std::string& message) {
        std::cout << "[LOG]: " << message << std::endl;
    }

private:
    // 3. Private constructor and destructor
    Logger() { std::cout << "Logger started." << std::endl; }
    ~Logger() { std::cout << "Logger shut down." << std::endl; }
};

// --- How we use it in our program ---
int main() {
    // The database system encounters an issue
    // Notice we use the standard dot (.) operator!
    Logger::getInstance().logMessage("Database connection failed!");

    // The user interface loads successfully
    Logger::getInstance().logMessage("User interface loaded successfully.");

    return 0;
}
```

### References:

- https://www.geeksforgeeks.org/system-design/singleton-pattern-c-design-patterns/