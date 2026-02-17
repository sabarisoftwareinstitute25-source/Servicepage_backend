# Frontend-Backend Connection Guide

## ✅ Frontend Successfully Connected to Backend!

The React frontend is now fully integrated with the Spring Boot backend.

## 🔌 Connection Configuration

### Backend Configuration

**CORS Configuration** (`WebConfig.java`):
- Allows requests from `http://localhost:3000` (React dev server)
- Supports all HTTP methods: GET, POST, PUT, PATCH, DELETE, OPTIONS
- Allows all headers
- Credentials enabled

**Security Configuration** (`SecurityConfig.java`):
- CSRF disabled (for API access)
- All requests permitted (development mode)

### Frontend Configuration

**API Service** (`src/services/api.js`):
- Uses Vite proxy in development (`/api` → `http://localhost:8080/api`)
- Uses direct URL in production
- Includes request/response interceptors for debugging
- Error handling configured

**Vite Proxy** (`vite.config.js`):
- Proxies `/api` requests to `http://localhost:8080`
- Port: 3000 (frontend)
- Change origin: true

## 🚀 How to Run

### Step 1: Start Backend

```bash
cd servicepage
mvn spring-boot:run
```

Backend will run on: `http://localhost:8080`

### Step 2: Start Frontend

```bash
cd Servicepage_frontend
npm install  # First time only
npm run dev
```

Frontend will run on: `http://localhost:3000`

### Step 3: Access Application

Open browser: `http://localhost:3000`

## 🔍 Connection Status

The frontend includes a `ConnectionStatus` component that:
- Checks backend connectivity on page load
- Shows connection status (✅ Connected / ⚠️ Not Connected)
- Provides retry button if disconnected

## 📡 API Endpoints Available

### Services
- `GET /api/services/{serviceName}` - Get sub-services
- `GET /api/services/{serviceName}/{subServiceName}` - Get packages

### Vendor Applications
- `POST /api/aVendor/applications` - Submit application
- `GET /api/aVendor/applications` - Get applications by aVendor
- `GET /api/aVendor/applications/{id}` - Get application by ID
- `PUT /api/aVendor/applications/{id}` - Update application

### Vendor Profiles
- `POST /api/vendors` - Create aVendor profile
- `GET /api/vendors/{id}` - Get aVendor by ID
- `GET /api/vendors/user/{userId}` - Get aVendor by user ID
- `GET /api/vendors` - Get all vendors (with filters)
- `PUT /api/vendors/{id}` - Update aVendor profile
- `PATCH /api/vendors/{id}/status` - Update aVendor status
- `DELETE /api/vendors/{id}` - Delete aVendor

## 🛠️ API Functions in Frontend

All API functions are available in `src/services/api.js`:

```javascript
// Services
getServices(serviceName)
getSubServicePackages(serviceName, subServiceName)

// Vendor Applications
submitVendorApplication(vendorId, applicationData)
getVendorApplications(vendorId)
getVendorApplicationById(id)

// Vendor Profiles
createVendorProfile(vendorData)
getVendorProfile(id)
getVendorProfileByUserId(userId)
updateVendorProfile(id, vendorData)
getAllVendors(filters)
updateVendorStatus(id, status)
deleteVendor(id)
```

## 🐛 Troubleshooting

### Backend Not Connecting

1. **Check if backend is running:**
   ```bash
   curl http://localhost:8080/api/services/PHOTOGRAPHY
   ```

2. **Check backend logs** for errors

3. **Verify CORS configuration** in `WebConfig.java`

4. **Check port conflicts** - Ensure port 8080 is available

### Frontend Not Loading

1. **Check if frontend is running:**
   ```bash
   curl http://localhost:3000
   ```

2. **Check browser console** for errors (F12)

3. **Verify Vite proxy** configuration

4. **Clear browser cache** and reload

### CORS Errors

If you see CORS errors in browser console:
1. Verify `WebConfig.java` allows your frontend origin
2. Check `SecurityConfig.java` allows all requests
3. Ensure backend is running before frontend

## 📝 Environment Variables

For production, create `.env` file in frontend:

```env
VITE_API_URL=http://your-backend-url:8080/api
```

## ✅ Connection Checklist

- [x] Backend CORS configured
- [x] Frontend API service configured
- [x] Vite proxy configured
- [x] Connection status component added
- [x] Error handling implemented
- [x] Request/response interceptors added

## 🎯 Next Steps

1. Test all API endpoints from frontend
2. Add loading states to components
3. Add error boundaries
4. Implement authentication (if needed)
5. Add request caching (optional)

The frontend and backend are now fully connected! 🎉

