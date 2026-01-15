# Linux Commands

## File Operations

- Create a symbolic link (shorcut): `ln -s /path/to/target ~/shortcut_name`
- Change file or directory permissions:
    - Make a file executable: `chmod +x <file_name>`
    - Set full permissions (read/write/execute for everyone - use with caution): `chmod 777 <file_name>`

---

## System & Binaries

- Check shared library dependencies of a program: `ldd <file_name>`

---

## Process Management

- List all running processes:
    - Resource focused (BSD style): `ps aux`
        - *(Best for checking %CPU, %MEM, and memory usage)*
    - Hierarchy focused (System V style): `ps -ef`
        - *(Best for seeing PPID/Parent-Child relationships)*
- Kill a process:
    - Force kill (sends `SIGKILL`, process cannot clean up): `kill -9 <PID>`
- Send a specific signal (e.g., Signal 10/SIGUSR1): `kill -s 10 <PID>` or `kill -SIGUSR1 <PID>` or `kill -USR1 <PID>`
- List all available signal types: `kill -l`

- View manual for the kill command: `man kill`
