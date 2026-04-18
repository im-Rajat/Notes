# Operating Systems Interview Questions

## 1. Memory Segments: Stack vs. Heap
When a program runs, the OS allocates a chunk of RAM for it. That chunk isn't just a messy pile of data; it’s organized into specific segments.

### **The Stack (Static Allocation)**
Think of the Stack like a **stack of plates**. You add one on top (push) and take one off the top (pop). It stores local variables and function calls.

- **How it works:** It is managed by the CPU automatically. When a function finishes, everything inside its "frame" is instantly wiped.
- **The Catch:** It’s small and fixed in size. If you try to store too much (like a massive array), you get a **Stack Overflow**.
- **Speed:** Extremely fast because the memory is contiguous and managed by hardware.

### **The Heap (Dynamic Allocation)**
The Heap is a **giant warehouse**. It’s where you put things when you don't know how much space you'll need until the program is actually running.

- **How it works:** You (the programmer) manually ask for space (e.g., `malloc` in C or `new` in Java) and—crucially—you are responsible for giving it back.
- **The Catch:** It's messy. Over time, you get **fragmentation** (empty holes between used blocks). If you forget to free the memory, you get a **Memory Leak**.
- **Speed:** Slower because the OS has to "look" for a free spot to fit your data.

[Memory Segments: Stack vs Heap - Explanation using Image & Diagram](https://i.imghippo.com/files/Cf7661EiM.png)

---

## 2. Virtual Memory & Virtual Address Space
This is where most of us get confused. **Our program does not talk to our RAM sticks directly.**

### **The Concept**
Every process thinks it has access to the entire memory of the computer (e.g., 0 to 4GB on a 32-bit system). This "fake" memory is the **Virtual Address Space**.

- **The Reality:** The actual RAM (Physical Memory) might be small or shared by 50 other apps. 
- **The "Lye":** The OS creates a map. Your program says, "Store this at address 0x100." The OS looks at its map and actually stores it at 0x854 in the real RAM.

**Why do we do this?**
- **Isolation:** App A cannot accidentally overwrite App B’s data because they live in different virtual worlds.
- **Size:** You can run a 10GB game on 8GB of RAM because the OS only keeps the "active" parts in the physical RAM and hides the rest on the SSD/Hard Drive.

[Virtual Memory & Virtual Address Space - Explanation using Image & Diagram](https://i.imghippo.com/files/YkMm9223CeQ.png)

---

## 3. Paging: The "Unit" of Management
If the OS tried to map every single byte of virtual memory to physical memory, the mapping table would be larger than the RAM itself. So, we use **Paging**.

- **Pages:** The Virtual Address Space is chopped into fixed-size blocks (usually **4KB**). These are called **Pages**.
- **Frames:** Physical RAM is chopped into the exact same 4KB blocks. These are called **Frames**.
- **Page Table:** This is the "Cheat Sheet" or Map. It tells the CPU: *"Virtual Page #5 is currently sitting in Physical Frame #102."*

### **The "Page Fault" (Crucial for Thrashing)**
What happens if your program asks for Page #10, but the OS hasn't put it in RAM yet (it’s still on the disk)?

- The CPU triggers a **Page Fault**.
- The OS pauses the program, goes to the Hard Drive, finds the data, and loads it into an empty Frame in RAM.
- The Page Table is updated, and the program continues.

[Paging - Explanation using Image & Diagram](https://i.imghippo.com/files/xLy2146wNc.png)  
[Thrashing - Explanation using Image & Diagram](https://i.imghippo.com/files/jcEc7120IE.png)

---

### To-Do:

- Virtual memory, paging, thrashing
- Fragmentation: internal vs external
- Producer consumer problem
- Banker’s algorithm
- Scheduling algorithms: FCFS, SJF, SRTF, RR
- RAID and its types
- Direct mapping vs associative mapping
- socket, kernel and monolithic kernel

> https://htmlpreview.github.io/
