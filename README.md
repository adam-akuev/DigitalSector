# Employee Management System

Система управления сотрудниками на Java с функционалом работы с файлами и unit-тестами.

## 📋 Описание

Проект демонстрирует:
- Принципы ООП (инкапсуляция, наследование, полиморфизм)
- Работу с файлами (чтение/запись)
- Обработку исключений
- Unit-тестирование с JUnit 5
- Сборку с помощью Maven

## 🏗️ Структура проекта
DigitalSector/
├── pom.xml
├── README.md
└── src/
├── main/
│ └── java/
│ └── com/
│ └── dsacademy/
│ ├── Main.java
│ ├── model/
│ │ └── Employee.java
│ ├── service/
│ │ ├── EmployeeService.java
│ │ └── FileService.java
│ └── util/
│ ├── EmployeeNotFoundException.java
│ ├── FileLoadException.java
│ └── InvalidFormatException.java
└── test/
└── java/
└── com/
└── dsacademy/
└── service/
└── EmployeeServiceTest.java

text

## ⚙️ Требования

- **Java**: 17 или выше
- **Maven**: 3.6 или выше
- **JUnit**: 5.10.0 (автоматически устанавливается через Maven)

## 🚀 Быстрый старт

### 1. Клонирование и навигация
```bash
git clone <ваш-репозиторий>
cd DigitalSector
2. Сборка проекта
bash
mvn clean compile
3. Запуск приложения
bash
# Способ 1: Через Maven
mvn exec:java -Dexec.mainClass="com.dsacademy.Main"

# Способ 2: Через скомпилированные классы
java -cp target/classes com.dsacademy.Main
4. Запуск тестов
bash
mvn test
📦 Сборка JAR файла
Создание исполняемого JAR:
bash
mvn clean package
Запуск из JAR:
bash
java -cp target/DigitalSector-1.0-SNAPSHOT.jar com.dsacademy.Main
🧪 Тестирование
Проект включает unit-тесты для основных методов:

bash
# Запуск всех тестов
mvn test

# Запуск с детальным выводом
mvn test -DdisplayName=verbose
Покрытые тестами сценарии:

Поиск существующего сотрудника

Обработка несуществующего ID

Фильтрация по зарплате

Валидация входных параметров
