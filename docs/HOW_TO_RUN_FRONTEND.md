# How to Run Frontend

This project has **TWO frontends** - choose the one that suits your needs:

---

## Option 1: HTML/CSS/JavaScript Frontend (Simple, No Build)

### Prerequisites
- Java 17+ installed
- Maven installed
- Spring Boot backend running

### Steps

1. **Start the Spring Boot Backend:**
   ```bash
   # In the project root directory (servicepage)
   mvn spring-boot:run
   ```

2. **Access the Frontend:**
   - Open your browser
   - Navigate to: `http://localhost:8080/`
   - The HTML frontend is automatically served by Spring Boot

### That's it! 
No additional steps needed. The HTML frontend is embedded in the Spring Boot application.

---

## Option 2: React.js Frontend (Modern SPA)

### Prerequisites
- Node.js 16+ installed
- npm or yarn installed
- Spring Boot backend running (on port 8080)

### Steps

1. **Start the Spring Boot Backend First:**
   ```bash
   # In the project root directory (servicepage)
   mvn spring-boot:run
   ```
   Wait until you see: `Started ServicepageApplication`

2. **Open a NEW Terminal Window:**
   - Keep the backend running in the first terminal
   - Open a second terminal for the frontend

3. **Navigate to React Frontend Directory:**
   ```bash
   cd ../Servicepage_frontend
   ```
   Or if you're in the project root:
   ```bash
   cd Servicepage_frontend
   ```

4. **Install Dependencies (First Time Only):**
   ```bash
   npm install
   ```
   This only needs to be done once, or when dependencies change.

5. **Start the React Development Server:**
   ```bash
   npm run dev
   ```
   Or:
   ```bash
   npm start
   ```

6. **Access the Frontend:**
   - The terminal will show: `Local: http://localhost:3000/`
   - Open your browser and navigate to: `http://localhost:3000/`

### React Frontend URLs:
- **Home:** `http://localhost:3000/`
- **Services:** `http://localhost:3000/services`
- **Vendor Application:** `http://localhost:3000/aVendor-application`

---

## Quick Reference Commands

### HTML Frontend (Spring Boot)
```bash
# Start backend (serves HTML frontend automatically)
mvn spring-boot:run

# Access at: http://localhost:8080/
```

### React Frontend
```bash
# Terminal 1: Start backend
cd servicepage
mvn spring-boot:run

# Terminal 2: Start React frontend
cd Servicepage_frontend
npm install    # First time only
npm run dev    # Start dev server

# Access at: http://localhost:3000/
```

---

## Troubleshooting

### Backend Not Starting
- Check if port 8080 is already in use
- Verify PostgreSQL is running
- Check `application.properties` for correct database settings

### React Frontend Not Starting
- Make sure you're in the `Servicepage_frontend` directory
- Run `npm install` if you see module errors
- Check if port 3000 is already in use
- Verify Node.js is installed: `node --version`

### API Connection Issues
- Ensure backend is running on port 8080
- Check browser console for CORS errors
- Verify `vite.config.js` has correct proxy settings

### Port Already in Use
**For Backend (8080):**
```bash
# Windows PowerShell
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Or change port in application.properties:
server.port=8081
```

**For React Frontend (3000):**
```bash
# Windows PowerShell
netstat -ano | findstr :3000
taskkill /PID <PID> /F

# Or change port in vite.config.js:
server: { port: 3001 }
```

---

## Running Both Frontends Simultaneously

You can run both frontends at the same time:

1. **Terminal 1:** Start Spring Boot backend
   ```bash
   mvn spring-boot:run
   ```
   Access HTML frontend at: `http://localhost:8080/`

2. **Terminal 2:** Start React frontend
   ```bash
   cd Servicepage_frontend
   npm run dev
   ```
   Access React frontend at: `http://localhost:3000/`

Both will work independently and connect to the same backend API.

---

## Which Frontend Should I Use?

### Use HTML Frontend If:
- ✅ You want simplicity
- ✅ No build step needed
- ✅ Quick testing/prototyping
- ✅ Traditional server-rendered pages

### Use React Frontend If:
- ✅ You want modern SPA experience
- ✅ Need client-side routing
- ✅ Building a production application
- ✅ Want component-based architecture

---

## File Locations

- **HTML Frontend:** `src/main/resources/static/`
- **React Frontend:** `../Servicepage_frontend/` or `Servicepage_frontend/`

