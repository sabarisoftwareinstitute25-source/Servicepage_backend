# How to Start the Backend

## Quick Start

### Option 1: Using Maven (Recommended)
```bash
# In the project root directory (servicepage)
mvn spring-boot:run
```

### Option 2: Using the Helper Script
```powershell
# Windows PowerShell
.\start-html-frontend.ps1

# Or Windows Command Prompt
start-html-frontend.bat
```

---

## Verify Backend is Running

### Check Port 8080
```powershell
# Check if port 8080 is in use
netstat -ano | findstr :8080
```

### Test Backend Health Endpoint
Open your browser or use curl:
```
http://localhost:8080/api/health
```

Expected response:
```json
{
  "status": "UP",
  "message": "Backend is running",
  "timestamp": 1234567890
}
```

### Test Services Endpoint
```
http://localhost:8080/api/services/PHOTOGRAPHY
```

---

## Troubleshooting

### Port 8080 Already in Use

**Find the process:**
```powershell
netstat -ano | findstr :8080
```

**Kill the process (replace PID with actual process ID):**
```powershell
taskkill /PID <PID> /F
```

**Or change the port in `application.properties`:**
```properties
server.port=8081
```

Then update frontend `vite.config.js`:
```javascript
proxy: {
  '/api': {
    target: 'http://localhost:8081',  // Changed from 8080
    changeOrigin: true,
  }
}
```

### Database Connection Issues

**Check PostgreSQL is running:**
```powershell
# Check if PostgreSQL is running
Get-Service -Name postgresql*
```

**Verify database exists:**
```sql
-- Connect to PostgreSQL and run:
SELECT datname FROM pg_database WHERE datname = 'servicepage';
```

**Create database if needed:**
```sql
CREATE DATABASE servicepage;
```

**Update database credentials in `application.properties` if needed:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/servicepage
spring.datasource.username=postgres
spring.datasource.password=postgres
```

### Backend Won't Start

1. **Check Java version:**
   ```bash
   java -version
   ```
   Should be Java 17 or higher.

2. **Check Maven:**
   ```bash
   mvn -version
   ```

3. **Clean and rebuild:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Check logs** for specific errors

---

## Expected Output When Starting

When backend starts successfully, you should see:
```
Started ServicepageApplication in X.XXX seconds
```

And the application will be available at:
- Backend API: `http://localhost:8080/api`
- HTML Frontend: `http://localhost:8080/`
- Health Check: `http://localhost:8080/api/health`

---

## Common Issues

### Issue: "Port 8080 already in use"
**Solution:** Kill the process using port 8080 or change the port

### Issue: "Database connection failed"
**Solution:** 
- Ensure PostgreSQL is running
- Verify database credentials
- Check if database exists

### Issue: "Application failed to start"
**Solution:**
- Check application logs for specific errors
- Verify all dependencies are installed (`mvn clean install`)
- Check Java version compatibility

---

## Next Steps

Once backend is running:
1. ✅ Verify health endpoint: `http://localhost:8080/api/health`
2. ✅ Start React frontend: `cd Servicepage_frontend && npm run dev`
3. ✅ Check connection status in React app
4. ✅ Test API endpoints

