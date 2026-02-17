# Backend Setup Guide

## Overview
This is a Spring Boot backend application for the Eliteinova Matrimonial Services platform. It provides REST APIs for aVendor registration and management.

## Prerequisites
- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Database Setup

1. **Create PostgreSQL Database:**
```sql
CREATE DATABASE servicepage;
```

2. **Update Database Credentials:**
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/servicepage
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Running the Application

### Option 1: Using Maven
```bash
cd servicepage
mvn spring-boot:run
```

### Option 2: Using IDE
1. Open the project in your IDE
2. Run `ServicepageApplication.java`
3. The application will start on `http://localhost:8080`

## API Endpoints

### Base URL
```
http://localhost:8080/api
```

### Vendor Registration

#### Photography Vendor Registration
```
POST /api/vendors/photography/register
Content-Type: application/json

Request Body:
{
  "vendorName": "ABC Photography",
  "ownerName": "John Doe",
  "email": "john@example.com",
  "mobile": "9876543210",
  ...
}
```

#### Catering Vendor Registration
```
POST /api/vendors/catering/register
Content-Type: application/json

Request Body:
{
  "companyName": "XYZ Catering",
  "contactPerson": "Jane Smith",
  "email": "jane@example.com",
  "mobile": "9876543210",
  ...
}
```

### Get All Vendors
```
GET /api/vendors
GET /api/vendors?serviceType=PHOTOGRAPHY
GET /api/vendors?city=Chennai
```

### Get Vendor by ID
```
GET /api/vendors/{id}
```

## Response Format

All API responses follow this format:
```json
{
  "success": true,
  "message": "Success message",
  "data": { ... }
}
```

Error responses:
```json
{
  "success": false,
  "message": "Error message",
  "data": null
}
```

## File Upload

The application supports file uploads for aVendor photos. Files are stored in the `uploads/` directory.

## CORS Configuration

CORS is configured to allow requests from the frontend. The frontend should be running on:
- Development: `http://localhost:5173` (Vite default)
- Or configure in `CorsConfig.java`

## Frontend Connection

Update the frontend API base URL in your components:
```javascript
const API_BASE_URL = 'http://localhost:8080/api';
```

## Troubleshooting

### Database Connection Issues
- Ensure PostgreSQL is running
- Check database credentials in `application.properties`
- Verify database exists

### Port Already in Use
- Change port in `application.properties`: `server.port=8081`

### CORS Errors
- Check `CorsConfig.java` for allowed origins
- Ensure frontend URL matches allowed origins

## Next Steps

1. Add authentication (JWT tokens)
2. Add email notifications
3. Add file upload for photos
4. Add aVendor approval workflow
5. Add customer inquiry system

