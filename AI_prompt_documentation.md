AI Interaction Log (Step-by-Step Development with Code)

This document explains how I used GitHub Copilot (VS Code) and ChatGPT while building the Todo Management System.

🔹 Step 1: Creating Todo Model (model/Todo.java)

Tool Used: GitHub Copilot

Prompt:
"Create a Java model class Todo with fields id, title, description, completed"

AI Suggestion:

public class Todo {
    private String id;
    private String title;
    private String description;
    private boolean completed;
}

Issue:
Only fields were generated. Missing constructor, getters/setters, and toString.

Improvement Prompt:
"Add constructor, getters, setters and toString method"

Final Work:
I added constructor, getters/setters, and toString method and verified correct usage of fields.

🔹 Step 2: Creating DAO Interface (dao/TodoDao.java)

Tool Used: GitHub Copilot

Prompt:
"Create a DAO interface for Todo with CRUD operations"

AI Suggestion:

public interface TodoDao {
    void save(Todo todo);
    Todo retrieve(String id);
    void update(Todo todo);
    void delete(String id);
}

Issue:
Missing method to retrieve all todos.

Improvement Prompt:
"Add method to retrieve all todos"

Final Work:
Added:

List<Todo> retrieveAll();

Ensured all return types and method names are correct.

🔹 Step 3: MySQL Repository (repository/mysql/MysqlTodoRepository.java)

Tool Used: GitHub Copilot + ChatGPT

Prompt:
"Create a MySQL repository using JDBC for Todo"

AI Suggestion:

Connection con = DriverManager.getConnection(url, user, pass);
Statement stmt = con.createStatement();
stmt.executeUpdate("INSERT INTO todos VALUES(...)");

Issue:

Used Statement (risk of SQL injection)

No proper exception handling

Improvement Prompt:
"Use PreparedStatement and improve safety"

Final Work:
Replaced with:

PreparedStatement ps = con.prepareStatement(
    "INSERT INTO todos (id, title, description, completed) VALUES (?, ?, ?, ?)"
);

Additional Issue Faced:
JDBC connection was failing due to incorrect database URL.

ChatGPT Prompt:
"Why is my JDBC connection failing in Java?"

Fix:
Corrected database URL and verified driver and credentials.

🔹 Step 4: MongoDB Repository (repository/mongo/MongoTodoRepository.java)

Tool Used: GitHub Copilot

Prompt:
"Create MongoDB repository for Todo CRUD operations"

Issue:
Generated methods did not fully match DAO interface.

Final Work:

Modified methods to match DAO interface

Ensured consistency with other repositories

Understood MongoDB document handling

🔹 Step 5: PostgreSQL Repository (repository/postgres/PostgresTodoRepository.java)

Tool Used: GitHub Copilot

Prompt:
"Create PostgreSQL repository using JDBC similar to MySQL"

Issue:
Needed database-specific adjustments.

Final Work:

Updated JDBC URL and driver

Verified queries execution

🔹 Step 6: Factory Pattern (factory/RepositoryFactory.java)

Tool Used: GitHub Copilot

Prompt:
"Create a factory class to return repository based on database choice"

AI Suggestion:

if(choice.equals("mysql")) {
    return new MysqlTodoRepository();
}

Issue:
Not scalable and no validation.

Improvement Prompt:
"Use switch case and handle invalid input"

Final Work:
Implemented switch-case with validation:

switch(choice.toLowerCase()) {
    case "mysql":
        return new MysqlTodoRepository();
    case "mongo":
        return new MongoTodoRepository();
    default:
        throw new IllegalArgumentException("Invalid database type");
}

🔹 Step 7: Service Layer (service/TodoService.java)

Tool Used: GitHub Copilot

Prompt:
"Create a service class for Todo operations"

Issue:
No validation in AI-generated code.

Improvement Prompt:
"Add validation before saving Todo"

Final Work:
Added validation checks:

if(todo.getId() == null || todo.getId().isEmpty()) {
    throw new IllegalArgumentException("Todo ID cannot be null");
}

🔹 Step 8: CLI Application (Main.java)

Tool Used: GitHub Copilot + ChatGPT

Prompt:
"Create menu driven Java program using Scanner"

Issue Faced:
Scanner was skipping input.

ChatGPT Prompt:
"Why Scanner skips input after nextInt in Java?"

Fix:
Handled newline properly:

scanner.nextLine();
🔹 Step 9: Enhancement – Retrieve Incomplete Todos

Tool Used: GitHub Copilot

Prompt:
"Write method to return todos where completed is false"

Final Work:
Implemented filtering logic and integrated into CLI.

🔹 Step 10: Unit Testing

Tool Used: GitHub Copilot

Prompt:
"Write JUnit test for TodoService"

Final Work:
Enhanced test cases and added assertions like:

assertNotNull(todoService.retrieve("1"));

🔹 Step 11: Gitleaks Scan

Tool Used: GitHub Copilot (guidance)

Prompt:
"How to run gitleaks on project"

Command:

gitleaks detect --source .

Result:
No secrets found.


### Final Reflection

During this project, I used AI tools mainly for generating initial code, debugging issues, and understanding concepts.

However, I did not rely completely on AI. :

Identified and fixed issues (e.g., replacing Statement with PreparedStatement)

Added validations and improved logic

Debugged errors (especially in database and CLI handling)

This process helped me understand how to effectively use AI tools while still applying my own problem-solving skills.