# Secure Password Manager

A secure, command-line Password Manager written in Java. It allows you to safely store, generate, and manage your credentials with strong encryption and modern security features.

## Features

- **Password Generation:** Automatically generate strong passwords with customizable length and character sets.
- **Password Breach Verification:** Check passwords against breach databases (like HaveIBeenPwned) to ensure they haven't been compromised.
- **Password Security:**
  - Encryption of stored passwords using industry-standard algorithms (AES).
  - Integration with HaveIBeenPwned API to check for compromised passwords.
- **User-Friendly Interface:** Command-line interface with clear menu options for adding and retrieving credentials.
- **Two-Factor Authentication (2FA):** Support for TOTP (Time-based One-Time Password) for enhanced account security.
- **Master Password:** Protects access to all stored credentials.
- **Audit and Breach Check:** Easily check if your passwords have been exposed in known data breaches.
- **Automated Tests:** Unit tests with JUnit 5.

## Security Notes

- **Advanced Encryption:** All stored credentials are secured using AES.
- **Input Sanitization:** User-provided input is validated to prevent injection attacks or unsafe inputs.
- **Sensitive Data Cleanup:** Mechanisms are in place to clear encryption keys and sensitive data from memory when the application shuts down.
- **Master Password:** The master password is never stored; only a hash is kept (BCrypt recommended).
- **Passwords are never logged or displayed in plain text.**

## Prerequisites

- Java Development Kit (JDK) 17 or higher
- (Optional) Git for version control

## Technologies Used

- Java 17+: Core programming language
- SQLite: Local database for credential storage
- JUnit 5: For unit testing

## Installation

Clone the repository:

```sh
git clone https://github.com/Marolanda/GerenciadorSenhas.git
cd GerenciadorSenhas 
```

## Usage

1. **Compile the project:**

   ```sh
   javac -cp ".;lib/*;bin" -d bin src/*.java test/*.java
   ```

2. **Run the application:**

   ```sh
   java -cp ".;lib/*;bin" Main
   ```

3. **Run all tests:**

   ```sh
   java -jar lib/junit-platform-console-standalone-1.10.2.jar --class-path bin --scan-classpath
   ```

4. **Run a specific test:**
   ```sh
   java -jar lib/junit-platform-console-standalone-1.10.2.jar --class-path bin --select-class=GeradorSenhasTest
   ```

## File Structure

```
Passwords/
├── bin/                # Compiled .class files
├── lib/                # External libraries (.jar)
├── src/                # Java source code
├── test/               # Unit tests (JUnit)
├── .vscode/            # VS Code settings
├── .gitignore
└── README.md
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request. For major changes, open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Disclaimer

This project is for educational purposes. Use at your own risk. Always back up your credentials and never share your master password.
