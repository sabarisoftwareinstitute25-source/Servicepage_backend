# Vendor Application Updates

## Changes Made

### 1. Removed Sub-Service ID Requirement ✅
- **Entity:** `VendorApplication.java` - Made `subService` nullable (`nullable = true`)
- **DTO:** `VendorApplicationRequest.java` - Removed `@NotNull` validation from `subServiceId`
- **Service:** `VendorApplicationService.java` - Updated to handle nullable sub-service
- **Frontend:** `VendorApplication.jsx` - Removed sub-service ID field from form

### 2. Added Profile Photo Upload ✅
- **Entity:** `VendorApplication.java` - Added `profilePhotoUrl` field
- **DTO:** `VendorApplicationRequest.java` - Added `profilePhotoUrl` field
- **Controller:** `FileUploadController.java` - New controller for file uploads
- **Service:** `VendorApplicationService.java` - Updated to handle profile photo URL
- **Frontend:** `VendorApplication.jsx` - Added file upload UI
- **API:** `api.js` - Added `uploadProfilePhoto()` function

## File Upload Details

### Supported Formats
- PDF (`.pdf`)
- JPG (`.jpg`, `.jpeg`)
- PNG (`.png`)

### File Size Limit
- Maximum: 5MB

### Upload Endpoint
- **POST** `/api/upload/profile-photo`
- **Request:** `multipart/form-data` with `file` field
- **Response:** 
  ```json
  {
    "success": true,
    "message": "File uploaded successfully",
    "fileUrl": "/uploads/{unique-filename}",
    "fileName": "{unique-filename}",
    "fileSize": 12345,
    "contentType": "image/jpeg"
  }
  ```

### File Storage
- Files are stored in `uploads/` directory
- Files are renamed with UUID to prevent conflicts
- Files are accessible via `/uploads/{filename}` URL

## Frontend Form Changes

### Removed Fields
- ❌ Sub-Service ID field (no longer required)

### Added Fields
- ✅ Profile Photo upload field
  - File input with accept types: `.pdf,.jpg,.jpeg,.png`
  - Upload button (appears after file selection)
  - Success message with link to uploaded file
  - File validation (type and size)

### Form Flow
1. User selects a file (PDF or JPG)
2. File is validated (type and size)
3. User clicks "Upload Photo" button
4. File is uploaded to server
5. Server returns file URL
6. File URL is stored in form data
7. When form is submitted, `profilePhotoUrl` is included in the request

## Backend Configuration

### Application Properties
```properties
# File Upload Configuration
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
file.upload-dir=uploads
```

### Web Configuration
- Added resource handler for `/uploads/**` to serve uploaded files
- Files are served from `file:uploads/` directory

## Database Migration

The database schema will be automatically updated by Hibernate (`ddl-auto=update`):

```sql
-- Sub-service ID is now nullable
ALTER TABLE vendor_applications 
ALTER COLUMN sub_service_id DROP NOT NULL;

-- Add profile photo URL column
ALTER TABLE vendor_applications 
ADD COLUMN profile_photo_url VARCHAR(500);
```

## Testing

### Test File Upload
1. Navigate to `/aVendor-application`
2. Select a PDF or JPG file
3. Click "Upload Photo"
4. Verify success message appears
5. Verify file URL is stored

### Test Form Submission
1. Fill out aVendor application form (without sub-service ID)
2. Upload profile photo
3. Submit form
4. Verify `profilePhotoUrl` is included in the request
5. Verify application is saved with profile photo URL

## Notes

- Sub-service ID is now optional - vendors can apply without selecting a specific sub-service
- Profile photo upload is required before form submission (user must upload photo)
- Uploaded files are stored locally in `uploads/` directory
- For production, consider using cloud storage (AWS S3, Azure Blob, etc.)

