# Frontend and Backend Separation Guide

## ✅ Separation Complete!

The frontend has been successfully separated from the backend into a standalone folder.

## 📁 Project Structure

```
servicepage/
├── servicepage/                    # Backend (Spring Boot)
│   ├── src/
│   │   └── main/
│   │       ├── java/              # Java source code
│   │       └── resources/
│   │           ├── application.properties
│   │           └── static/        # (Can be removed - frontend moved)
│   └── pom.xml
│
└── Servicepage_frontend/          # Frontend (Standalone)
    ├── index.html
    ├── services.html
    ├── aVendor-application.html
    ├── css/
    │   └── style.css
    ├── js/
    │   ├── app.js
    │   ├── services.js
    │   └── aVendor-application.js
    ├── README.md
    └── package.json
```

## 🚀 How to Run

### Backend (Spring Boot)

1. **Navigate to backend folder:**
   ```bash
   cd servicepage
   ```

2. **Start the Spring Boot application:**
   ```bash
   mvn spring-boot:run
   ```

3. **Backend will run on:** `http://localhost:8080`
   - API endpoints: `http://localhost:8080/api/*`

### Frontend (Standalone)

1. **Navigate to frontend folder:**
   ```bash
   cd Servicepage_frontend
   ```

2. **Start a simple HTTP server:**

   **Option A - Python:**
   ```bash
   python -m http.server 3000
   ```

   **Option B - Node.js (if you have npm):**
   ```bash
   npm install
   npm start
   ```

   **Option C - VS Code Live Server:**
   - Install "Live Server" extension
   - Right-click `index.html` → "Open with Live Server"

3. **Frontend will run on:** `http://localhost:3000`
   - Home: `http://localhost:3000/index.html`
   - Services: `http://localhost:3000/services.html`
   - Vendor Application: `http://localhost:3000/aVendor-application.html`

## 🔌 Configuration

### Frontend API Configuration

The frontend is configured to connect to the backend at `http://localhost:8080/api`.

To change the backend URL, edit `Servicepage_frontend/js/app.js`:
```javascript
const API_BASE_URL = 'http://localhost:8080/api';
```

### Backend CORS Configuration

The backend is already configured to allow CORS requests from any origin (configured in `WebConfig.java`).

## 📝 Important Notes

1. **Both servers must run simultaneously:**
   - Backend on port 8080
   - Frontend on port 3000 (or any other port)

2. **API Communication:**
   - Frontend makes API calls to `http://localhost:8080/api/*`
   - Backend handles all API requests
   - CORS is enabled to allow cross-origin requests

3. **Development Workflow:**
   - Edit frontend files in `Servicepage_frontend/`
   - Edit backend files in `servicepage/src/main/java/`
   - Both can be developed independently

## 🗑️ Optional: Clean Up Backend

If you want to remove the frontend files from the backend (since they're now separate):

```bash
# Navigate to backend
cd servicepage

# Remove static frontend files (optional)
rm -rf src/main/resources/static/*
```

**Note:** The backend can still serve static files if needed, but it's not required since the frontend is now separate.

## ✅ Benefits of Separation

- ✅ Independent development and deployment
- ✅ Frontend can be deployed to CDN or static hosting
- ✅ Backend focuses only on API
- ✅ Easier to scale frontend and backend separately
- ✅ Better code organization

## 🎯 Next Steps

1. Start the backend: `cd servicepage && mvn spring-boot:run`
2. Start the frontend: `cd Servicepage_frontend && python -m http.server 3000`
3. Open browser: `http://localhost:3000/index.html`

Enjoy your separated frontend and backend! 🎉

