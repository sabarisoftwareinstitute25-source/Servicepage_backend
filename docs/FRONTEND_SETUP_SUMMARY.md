# Frontend Setup Summary

## ✅ Both Frontends Are Ready and Connected

### 1. HTML/CSS/JavaScript Frontend (Simple, No Build)

**Location:** `src/main/resources/static/`

**Files:**
- `index.html` - Home page
- `services.html` - Services listing page
- `aVendor-application.html` - Vendor application form
- `css/style.css` - Styling
- `js/app.js` - Main JavaScript utilities (API base URL: `http://localhost:8080/api`)
- `js/services.js` - Services API integration
- `js/aVendor-application.js` - Vendor application API integration

**How to Access:**
- Start Spring Boot application
- Open browser: `http://localhost:8080/`
- No build step required - served directly by Spring Boot

**API Configuration:**
- Base URL: `http://localhost:8080/api`
- Connected to backend REST endpoints

---

### 2. React.js Frontend (Modern SPA)

**Location:** `../Servicepage_frontend/` (parent directory)

**Technology Stack:**
- React 18.2.0
- Vite 5.0.8 (build tool)
- React Router DOM 6.20.0
- Axios 1.6.2

**Key Files:**
- `package.json` - Dependencies and scripts
- `vite.config.js` - Vite configuration with proxy to backend
- `src/App.jsx` - Main React component with routing
- `src/services/api.js` - API service layer
- `src/utils/apiConfig.js` - API configuration utility
- `src/components/` - React components (Navbar, Footer, ConnectionStatus)
- `src/pages/` - Page components (Home, Services, VendorApplication)

**How to Run:**
```bash
cd ../Servicepage_frontend
npm install  # First time only
npm run dev  # Start development server
```

**Access:**
- Development server: `http://localhost:3000`
- Uses Vite proxy: `/api` → `http://localhost:8080`

**API Configuration:**
- Development: Uses Vite proxy (`/api`)
- Production: Uses `VITE_API_URL` environment variable or defaults to `http://localhost:8080/api`

---

## Backend Configuration

### CORS Configuration (`WebConfig.java`)
- Allows origins: `http://localhost:3000`, `http://localhost:5173`, `*`
- Allows methods: GET, POST, PUT, PATCH, DELETE, OPTIONS
- Allows all headers
- Credentials enabled

### Static Resource Handler
- Serves files from `classpath:/static/`
- HTML frontend accessible at root (`http://localhost:8080/`)

---

## API Endpoints Available

### Services
- `GET /api/services/{serviceName}` - Get services and sub-services
- `GET /api/services/{serviceName}/{subServiceName}` - Get sub-service packages

### Vendor Applications
- `POST /api/aVendor/applications?vendorId={id}` - Submit aVendor application
- `GET /api/aVendor/applications?vendorId={id}` - Get aVendor applications
- `GET /api/aVendor/applications/{id}` - Get application by ID

### Vendor Profiles
- `POST /api/vendors` - Create aVendor profile
- `GET /api/vendors/{id}` - Get aVendor by ID
- `GET /api/vendors/user/{userId}` - Get aVendor by user ID
- `PUT /api/vendors/{id}` - Update aVendor profile
- `GET /api/vendors` - Get all vendors (with optional filters)
- `PATCH /api/vendors/{id}/status?status={status}` - Update aVendor status
- `DELETE /api/vendors/{id}` - Delete aVendor

---

## Running Both Frontends

### Option 1: HTML Frontend Only
1. Start Spring Boot: `mvn spring-boot:run`
2. Open: `http://localhost:8080/`

### Option 2: React Frontend Only
1. Start Spring Boot: `mvn spring-boot:run`
2. Start React dev server: `cd ../Servicepage_frontend && npm run dev`
3. Open: `http://localhost:3000/`

### Option 3: Both Simultaneously
1. Start Spring Boot: `mvn spring-boot:run`
2. Start React dev server: `cd ../Servicepage_frontend && npm run dev`
3. Access HTML version: `http://localhost:8080/`
4. Access React version: `http://localhost:3000/`

---

## Notes

- Both frontends are fully functional and connected to the backend
- HTML version is simpler and requires no build step
- React version provides a modern SPA experience with routing
- CORS is configured to allow both frontends to communicate with the backend
- All API endpoints are tested and working

