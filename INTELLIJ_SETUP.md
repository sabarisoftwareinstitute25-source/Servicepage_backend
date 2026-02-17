# IntelliJ IDEA Setup for servicepage Module

## Quick Fix for "JDK isn't specified for module 'servicepage'"

I've created configuration files that should help IntelliJ recognize Java 21. Follow these steps:

### Step 1: Reload Maven Project
1. Open **Maven** tool window (View → Tool Windows → Maven)
2. Click **Reload All Maven Projects** button (circular arrow icon)

### Step 2: Invalidate Caches
1. **File → Invalidate Caches / Restart...**
2. Select **Invalidate and Restart**
3. Wait for IntelliJ to restart

### Step 3: Verify Project SDK
1. **File → Project Structure** (Ctrl+Alt+Shift+S)
2. **Project** tab:
   - **Project SDK**: Should show **21** or **JDK 21**
   - If not, click dropdown → **Add SDK → JDK** → Select your JDK 21 installation
   - **Project language level**: Should be **21**

### Step 4: Verify Module SDK
1. Still in **Project Structure**:
2. **Modules** tab → Select **servicepage**
3. **Dependencies** tab:
   - **Module SDK**: Should be **Project SDK (21)** or **21**
   - If not, select it from dropdown

### Step 5: Configure Maven JDK
1. **File → Settings** (Ctrl+Alt+S)
2. **Build, Execution, Deployment → Build Tools → Maven**
3. **JDK for importer**: Select **21** or **JDK 21**
4. Click **OK**

### Step 6: Rebuild Project
1. **Build → Rebuild Project**

## If Error Persists

If you still see the error after these steps:

1. **Close IntelliJ**
2. Delete `.idea` folder in `servicepage` directory
3. **Reopen IntelliJ** and open the `servicepage` folder
4. IntelliJ will recreate `.idea` folder with correct settings
5. Follow Steps 1-6 above

## Verification

After setup, verify:
- No red errors in code
- `pom.xml` shows no errors
- Maven tool window shows all dependencies resolved
- Project compiles successfully

## Files Created

I've created these configuration files:
- `.idea/misc.xml` - Project root manager with JDK 21
- `.idea/compiler.xml` - Compiler configuration for Java 21
- `.idea/encodings.xml` - UTF-8 encoding settings
- `.idea/modules.xml` - Module configuration
- `servicepage.iml` - Module file with JDK 21 language level
- `.mvn/jvm.config` - Maven JVM configuration
- `.java-version` - Java version indicator

These files should help IntelliJ automatically detect Java 21.

