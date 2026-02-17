# API Endpoints Reference

## Base URL
```
Development: http://localhost:8080/api
Production: https://your-domain.com/api
```

---

## Service Types

### Get All Service Types
```
GET /api/services/types
```

**Response:**
```json
{
  "success": true,
  "services": [
    {
      "id": 1,
      "name": "PHOTOGRAPHY",
      "status": true
    },
    {
      "id": 2,
      "name": "CATERING",
      "status": true
    }
  ],
  "total": 2
}
```

---

## Sub-Services

### Get Sub-Services by Service Type
```
GET /api/services/{serviceType}
```

**Example:**
```
GET /api/services/PHOTOGRAPHY
```

**Response:**
```json
{
  "success": true,
  "service": "PHOTOGRAPHY",
  "subServices": [
    {
      "id": 1,
      "name": "WEDDING_PHOTOGRAPHY",
      "description": "Professional wedding photography services",
      "status": true
    },
    {
      "id": 2,
      "name": "WEDDING_VIDEOGRAPHY",
      "description": "Capture your special moments in motion",
      "status": true
    }
  ],
  "totalSubServices": 10
}
```

---

## Customer Service Requests

### Create Customer Enquiry
```
POST /api/customer/requests
```

**Request Body:**
```json
{
  "subServiceId": 1,
  "customerId": 1,
  "customerName": "John Doe",
  "customerEmail": "john@example.com",
  "customerPhone": "9876543210",
  "eventDate": "2024-06-15",
  "eventLocation": "Mumbai, Maharashtra",
  "budget": 50000,
  "requirements": "Need professional photographer for wedding ceremony"
}
```

**Response:**
```json
{
  "success": true,
  "message": "Service request submitted successfully",
  "request": {
    "id": 1,
    "subServiceId": 1,
    "subServiceName": "WEDDING_PHOTOGRAPHY",
    "customerId": 1,
    "customerName": "John Doe",
    "customerEmail": "john@example.com",
    "customerPhone": "9876543210",
    "eventDate": "2024-06-15",
    "eventLocation": "Mumbai, Maharashtra",
    "budget": 50000,
    "requirements": "Need professional photographer...",
    "status": "PENDING",
    "createdAt": "2024-01-06T12:00:00"
  }
}
```

### Get Customer Requests
```
GET /api/customer/requests/customer/{customerId}
```

**Response:**
```json
{
  "success": true,
  "requests": [...],
  "total": 5
}
```

### Get Requests by Sub-Service
```
GET /api/customer/requests/subservice/{subServiceId}
```

**Response:**
```json
{
  "success": true,
  "requests": [...],
  "total": 10
}
```

### Update Request Status
```
PATCH /api/customer/requests/{id}/status?status={status}
```

**Status values:** `PENDING`, `ACCEPTED`, `REJECTED`, `COMPLETED`

---

## Vendor Applications

### Create Vendor Registration
```
POST /api/vendors/{vendorId}/applications
```

**Request Body:**
```json
{
  "subServiceId": 1,
  "businessName": "ABC Photography",
  "businessDescription": "Professional wedding photography services",
  "contactPersonName": "John Smith",
  "contactEmail": "abc@photo.com",
  "contactPhone": "9876543210",
  "businessAddress": "123 Main Street",
  "city": "Mumbai",
  "state": "Maharashtra",
  "pincode": "400001",
  "priceRange": "30000-100000",
  "yearsOfExperience": 5,
  "portfolioUrl": "https://portfolio.example.com",
  "servicesOffered": "Wedding Photography, Pre-Wedding Shoot",
  "certifications": "Certified Professional Photographer"
}
```

**Response:**
```json
{
  "success": true,
  "message": "Application submitted successfully",
  "application": {
    "id": 1,
    "vendorId": 1,
    "subServiceId": 1,
    "businessName": "ABC Photography",
    "status": "PENDING",
    "createdAt": "2024-01-06T12:00:00"
  }
}
```

### Get All Applications
```
GET /api/vendors/applications?status={status}
```

**Query Parameters:**
- `status` (optional): `PENDING`, `APPROVED`, `REJECTED`

**Response:**
```json
{
  "success": true,
  "applications": [...],
  "total": 20
}
```

### Approve Application
```
PATCH /api/vendors/applications/{id}/approve?adminId={adminId}
```

### Reject Application
```
PATCH /api/vendors/applications/{id}/reject?adminId={adminId}
```

---

## Vendor Profiles (Public)

### Get All Vendors
```
GET /api/vendors/public?city={city}
```

**Query Parameters:**
- `city` (optional): Filter by city

**Response:**
```json
{
  "success": true,
  "vendors": [
    {
      "id": 1,
      "businessName": "ABC Photography",
      "businessDescription": "Professional wedding photography",
      "city": "Mumbai",
      "state": "Maharashtra",
      "contactEmail": "abc@photo.com",
      "contactPhone": "9876543210",
      "averageRating": 4.5,
      "totalReviews": 120,
      "priceRange": "30000-100000",
      "status": "ACTIVE"
    }
  ],
  "total": 50
}
```

### Get Vendor Profile by ID
```
GET /api/vendors/public/{id}
```

**Response:**
```json
{
  "success": true,
  "aVendor": {
    "id": 1,
    "businessName": "ABC Photography",
    "businessDescription": "Professional wedding photography services",
    "contactPersonName": "John Smith",
    "contactEmail": "abc@photo.com",
    "contactPhone": "9876543210",
    "businessAddress": "123 Main Street",
    "city": "Mumbai",
    "state": "Maharashtra",
    "portfolioUrl": "https://portfolio.example.com",
    "websiteUrl": "https://abcphoto.com",
    "averageRating": 4.5,
    "totalReviews": 120,
    "priceRange": "30000-100000",
    "yearsOfExperience": 5
  }
}
```

---

## Customer Inquiries

### Create Customer Inquiry
```
POST /api/customer/inquiries
```

**Request Body:**
```json
{
  "vendorId": 1,
  "customerId": 1,
  "customerName": "John Doe",
  "customerEmail": "john@example.com",
  "customerPhone": "9876543210",
  "status": "ACCEPTED",
  "message": "Interested in your wedding photography services"
}
```

**Status values:** `ACCEPTED` (Yes), `REJECTED` (No)

**Response:**
```json
{
  "success": true,
  "message": "Inquiry submitted successfully",
  "inquiry": {
    "id": 1,
    "vendorId": 1,
    "customerId": 1,
    "customerName": "John Doe",
    "status": "ACCEPTED",
    "createdAt": "2024-01-06T12:00:00"
  }
}
```

### Get Inquiry by ID
```
GET /api/customer/inquiries/{id}
```

### Get Inquiries by Vendor
```
GET /api/customer/inquiries/aVendor/{vendorId}
```

### Get Inquiries by Customer
```
GET /api/customer/inquiries/customer/{customerId}
```

### Update Inquiry Status
```
PATCH /api/customer/inquiries/{id}/status?status={status}
```

**Status values:** `PENDING`, `ACCEPTED`, `REJECTED`, `CONTACTED`

---

## Error Responses

All endpoints return errors in the following format:

```json
{
  "success": false,
  "error": "Error message here"
}
```

**HTTP Status Codes:**
- `200` - Success
- `400` - Bad Request (validation errors)
- `404` - Not Found
- `500` - Internal Server Error

---

## Authentication

Currently, endpoints are public. For production, add:
- JWT tokens for authentication
- Role-based access control (Customer, Vendor, Admin)
- API rate limiting

---

## CORS Configuration

Frontend is configured to work with backend at:
- Development: `http://localhost:8080`
- Production: Configure in `application.properties`

