@echo off
echo ========================================
echo Fixing Java 21 Lombok Compilation Error
echo ========================================
echo.

echo Step 1: Cleaning Maven project...
call mvn clean
echo.

echo Step 2: Removing IDE cache folders...
if exist .idea (
    echo Removing .idea folder...
    rmdir /s /q .idea
)

if exist target (
    echo Removing target folder...
    rmdir /s /q target
)
echo.

echo Step 3: Recompiling project...
call mvn compile -DskipTests
echo.

echo ========================================
echo Fix complete!
echo ========================================
echo.
echo Next steps:
echo 1. In your IDE, reload/refresh the Maven project
echo 2. In IntelliJ: File -^> Invalidate Caches -^> Invalidate and Restart
echo 3. In Eclipse: Right-click project -^> Maven -^> Update Project
echo 4. Ensure Lombok plugin is installed in your IDE
echo.
pause

