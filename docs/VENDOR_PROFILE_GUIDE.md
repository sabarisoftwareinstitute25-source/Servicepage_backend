# Vendor Profile System - Implementation Guide

## ✅ Vendor Profile Data Storage Implemented!

A complete aVendor profile management system has been added to store aVendor data in the database.

## 📁 Files Created

### Entity
- `src/main/java/com/matrimony/servicepage/entity/Vendor.java`
  - Stores aVendor profile information
  - Fields: business info, contact details, address, registration numbers, status, ratings

### Repository
- `src/main/java/com/matrimony/servicepage/repository/Vendor.java`
  - JPA repository with custom query methods
  - Find by userId, email, status, city

### Service
- `src/main/java/com/matrimony/servicepage/service/VendorService.java`
  - Business logic for aVendor operations
  - CRUD operations, status management

### Controller
- `src/main/java/com/matrimony/servicepage/controller/VendorController.java`
  - REST API endpoints for aVendor management

### DTOs
- `src/main/java/com/matrimony/servicepage/dto/VendorRequest.java`
- `src/main/java/com/matrimony/servicepage/dto/VendorResponse.java`

## 🗄️ Database Schema

The `vendors` table will be created automatically with the following structure:

```sql
CREATE TABLE vendors (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    business_name VARCHAR(200) NOT NULL,
    business_description TEXT,
    contact_person_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(255) NOT NULL UNIQUE,
    contact_phone VARCHAR(20) NOT NULL,
    business_address TEXT,
    city VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(10),
    country VARCHAR(100) DEFAULT 'India',
    portfolio_url TEXT,
    website_url TEXT,
    about_us TEXT,
    social_media_links TEXT,
    gst_number VARCHAR(15),
    pan_number VARCHAR(10),
    business_registration_number VARCHAR(50),
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    average_rating DOUBLE PRECISION,
    total_reviews INTEGER,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);
```

## 🔌 API Endpoints

### Create Vendor Profile
```
POST /api/vendors
Body: VendorRequest JSON
```

### Get Vendor by ID
```
GET /api/vendors/{id}
```

### Get Vendor by User ID
```
GET /api/vendors/user/{userId}
```

### Get All Vendors
```
GET /api/vendors
Query params: ?status=ACTIVE&city=Mumbai
```

### Update Vendor Profile
```
PUT /api/vendors/{id}
Body: VendorRequest JSON
```

### Update Vendor Status
```
PATCH /api/vendors/{id}/status?status=ACTIVE
```

### Delete Vendor (Soft Delete)
```
DELETE /api/vendors/{id}
```

## 📝 Vendor Status Values

- `ACTIVE` - Vendor is active and can provide services
- `INACTIVE` - Vendor is temporarily inactive
- `SUSPENDED` - Vendor is suspended by admin
- `DELETED` - Vendor profile is deleted (soft delete)

## 🎯 Usage Example

### Create Vendor Profile
```json
POST /api/vendors
{
  "userId": 1,
  "businessName": "Wedding Photography Studio",
  "businessDescription": "Professional wedding photography services",
  "contactPersonName": "John Doe",
  "contactEmail": "john@example.com",
  "contactPhone": "9876543210",
  "businessAddress": "123 Main Street",
  "city": "Mumbai",
  "state": "Maharashtra",
  "pincode": "400001",
  "portfolioUrl": "https://portfolio.example.com",
  "websiteUrl": "https://www.example.com",
  "gstNumber": "27ABCDE1234F1Z5",
  "panNumber": "ABCDE1234F"
}
```

### Get Vendor Profile
```json
GET /api/vendors/user/1
Response:
{
  "success": true,
  "aVendor": {
    "sno": 1,
    "userId": 1,
    "businessName": "Wedding Photography Studio",
    ...
  }
}
```

## 🔄 Next Steps

1. **Update VendorApplication** - Link VendorApplication to Vendor entity
2. **Add Frontend Integration** - Create React components for aVendor profile management
3. **Add Validation** - Enhance business rules and validations
4. **Add Reviews/Ratings** - Implement review system to update averageRating

## ✅ Features Implemented

✅ Vendor profile CRUD operations  
✅ Status management  
✅ Search by user ID, email, city, status  
✅ Email uniqueness validation  
✅ Soft delete functionality  
✅ Timestamps (createdAt, updatedAt)  
✅ Business registration fields (GST, PAN)  
✅ Rating fields (for future review system)  

The aVendor profile system is ready to use! 🎉

