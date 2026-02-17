# CORS 403 Forbidden Error Fix

## Problem
Frontend running on `http://localhost:3001` was getting 403 Forbidden errors when making POST requests to `/api/aVendor/applications`.

## Root Cause
1. **CORS Configuration Missing Port 3001**: The `WebConfig` CORS settings only allowed ports 3000, 5173, and 8080
2. **Spring Security CORS Not Configured**: Spring Security needs explicit CORS configuration to work with WebMvc CORS settings

## Solution

### 1. Updated WebConfig.java
Added `http://localhost:3001` to allowed origins:
```java
.allowedOrigins("http://localhost:3000", "http://localhost:3001", "http://localhost:5173", "http://localhost:8080")
```

### 2. Updated SecurityConfig.java
Added explicit CORS configuration in Spring Security:
- Created `CorsConfigurationSource` bean
- Configured allowed origins, methods, headers
- Registered CORS configuration for `/api/**` paths
- Enabled CORS in SecurityFilterChain

## Changes Made

### SecurityConfig.java
- Added `CorsConfigurationSource` bean
- Configured CORS with all allowed origins including port 3001
- Enabled CORS in security filter chain

### WebConfig.java
- Added `http://localhost:3001` to allowed origins list

## Testing
After these changes:
1. Restart the Spring Boot backend
2. The frontend on port 3001 should now be able to make requests without 403 errors
3. All API endpoints should be accessible from port 3001

## Allowed Origins
- `http://localhost:3000` (Vite default)
- `http://localhost:3001` (Custom port)
- `http://localhost:5173` (Vite alternative)
- `http://localhost:8080` (Backend port)

## Allowed Methods
- GET
- POST
- PUT
- PATCH
- DELETE
- OPTIONS (for preflight requests)

## Allowed Headers
- All headers (`*`)

## Credentials
- Enabled (`allowCredentials: true`)

