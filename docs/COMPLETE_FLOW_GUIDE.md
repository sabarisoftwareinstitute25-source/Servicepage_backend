# Complete Service Flow Guide - Step by Step

## Overview
This document describes the complete user flow from service type selection to aVendor profile viewing.

---

## **STEP 1: Service Type Selection Page**

### Route: `/service-types`
### Component: `ServiceTypeSelection.jsx`
### Backend Endpoint: `GET /api/services/types`

**What happens:**
1. User lands on the service type selection page
2. Page displays service types like:
   - 📸 Photography & Media
   - 🍽️ Catering & Food
   - 💐 Decoration & Design
   - 🎥 Videography & Cinematography
   - etc.

3. Each service type is displayed as a clickable card with icon and color
4. When user clicks a service type card:
   - Navigates to: `/select-role?serviceType={serviceName}`
   - Example: `/select-role?serviceType=PHOTOGRAPHY`

**Database:**
- Fetches from `services` table
- Filters by `status = true`

---

## **STEP 2: Customer/Vendor Selection Page**

### Route: `/select-role`
### Component: `RoleSelection.jsx`

**What happens:**
1. User sees two options:
   - 👤 **Customer** - "I'm looking for services"
   - 🏢 **Vendor** - "I provide services"

2. When user clicks Customer:
   - Navigates to: `/sub-services?serviceType={serviceType}&role=customer`
   - Example: `/sub-services?serviceType=PHOTOGRAPHY&role=customer`

3. When user clicks Vendor:
   - Navigates to: `/sub-services?serviceType={serviceType}&role=aVendor`
   - Example: `/sub-services?serviceType=PHOTOGRAPHY&role=aVendor`

**URL Parameters:**
- `serviceType` - The selected service type (e.g., PHOTOGRAPHY)
- `role` - Either "customer" or "aVendor"

---

## **STEP 3: Sub-Services List Page**

### Route: `/sub-services`
### Component: `SubServicesList.jsx`
### Backend Endpoint: `GET /api/services/{serviceType}`

**What happens:**
1. Page displays list of sub-services for the selected service type
2. For Photography & Media, examples include:
   - Wedding Photography
   - Wedding Videography
   - Cinematography
   - Drone Shoot
   - Pre-Wedding Shoot
   - Post-Wedding Shoot
   - Album Designing
   - Photo Editing / Retouching
   - Live Wedding Streaming
   - 360° Video Capture

3. Each sub-service is displayed as a card with:
   - Name (formatted from database)
   - Description (if available)
   - Action button ("Request Service" for customers, "Apply Now" for vendors)

4. **If role = customer:**
   - Clicking a sub-service navigates to:
     `/customer-request?subServiceId={id}&subServiceName={name}`
   - Example: `/customer-request?subServiceId=1&subServiceName=WEDDING_PHOTOGRAPHY`

5. **If role = aVendor:**
   - Clicking a sub-service navigates to:
     `/aVendor-application?subServiceId={id}&subServiceName={name}`
   - Example: `/aVendor-application?subServiceId=1&subServiceName=WEDDING_PHOTOGRAPHY`

**Database:**
- Fetches from `sub_services` table
- Filters by `service.name = {serviceType}` and `status = true`

---

## **STEP 4: Form Filling**

### **4A. Customer Service Request Form**

### Route: `/customer-request`
### Component: `CustomerServiceRequest.jsx`
### Backend Endpoint: `POST /api/customer/requests`

**Form Fields:**
- Customer Name * (required)
- Customer Email * (required)
- Customer Phone * (required)
- Event Date (optional)
- Event Location (optional)
- Additional Requirements/Message (optional)

**What happens:**
1. Form is pre-filled with sub-service information from URL
2. User fills in their details
3. On submit:
   - Creates `CustomerServiceRequest` record in database
   - Status: `PENDING`
   - Stores in `customer_service_requests` table
4. After successful submission:
   - Shows success message
   - Redirects to `/vendors` page after 2 seconds

**Database Table: `customer_service_requests`**
- `id` (auto-generated)
- `sub_service_id` (FK to sub_services)
- `customer_id`
- `customer_name`
- `customer_email`
- `customer_phone`
- `event_date`
- `event_location`
- `message`
- `status` (PENDING, ACCEPTED, REJECTED, COMPLETED)
- `created_at`
- `updated_at`

---

### **4B. Vendor Application Form**

### Route: `/aVendor-application`
### Component: `VendorApplication.jsx`
### Backend Endpoint: `POST /api/vendors/{vendorId}/applications`

**Form Fields:**
- Vendor ID * (required)
- Sub-Service ID * (pre-filled from URL, read-only)
- Business Name * (required)
- Business Description
- Contact Person Name * (required)
- Contact Email * (required)
- Contact Phone * (required)
- Business Address
- City, State, Pincode
- Years of Experience
- Portfolio URL
- Previous Work Description
- Certifications
- Document URLs
- Starting Price
- Pricing Model

**What happens:**
1. Form shows selected sub-service name at the top
2. Sub-Service ID field is pre-filled and read-only
3. User fills in aVendor application details
4. On submit:
   - Creates `VendorApplication` record in database
   - Status: `PENDING`
   - Stores in `vendor_applications` table
5. After successful submission:
   - Shows success message
   - Form resets

**Database Table: `vendor_applications`**
- `id` (auto-generated)
- `vendor_id` (User ID with OFFICE role)
- `sub_service_id` (FK to sub_services)
- Business information fields
- Contact information fields
- Experience & portfolio fields
- Pricing information fields
- `status` (PENDING, APPROVED, REJECTED)
- `created_at`
- `updated_at`

---

## **STEP 5: Database Storage**

### Customer Service Requests
- **Table:** `customer_service_requests`
- **Entity:** `CustomerServiceRequest.java`
- **Repository:** `CustomerServiceRequestRepository.java`
- **Service:** `CustomerServiceRequestService.java`
- **Controller:** `CustomerServiceRequestController.java`

**Storage Process:**
1. Customer fills form → Submits
2. Backend validates data
3. Creates new `CustomerServiceRequest` entity
4. Sets status to `PENDING`
5. Saves to database via JPA
6. Returns success response

### Vendor Applications
- **Table:** `vendor_applications`
- **Entity:** `VendorApplication.java`
- **Repository:** `VendorApplicationRepository.java`
- **Service:** `VendorApplicationService.java`
- **Controller:** `VendorApplicationController.java`

**Storage Process:**
1. Vendor fills form → Submits
2. Backend validates data
3. Creates new `VendorApplication` entity
4. Sets status to `PENDING`
5. Saves to database via JPA
6. Returns success response

---

## **STEP 6: Customer Views Vendor Profile & Selects Option**

### Route: `/vendors` → `/vendors/:id`
### Components: `VendorList.jsx` → `VendorProfile.jsx`
### Backend Endpoints: 
- `GET /api/vendors/public` (list)
- `GET /api/vendors/public/{id}` (profile)
- `POST /api/customer/inquiries` (inquiry)

**What happens:**

### 6A. Vendor List Page (`/vendors`)
1. Displays list of all active vendors
2. Shows aVendor cards with:
   - Business name
   - City, State
   - Average rating
   - Total reviews
3. User can filter by city
4. Clicking a aVendor card navigates to: `/vendors/{vendorId}`

### 6B. Vendor Profile Page (`/vendors/:id`)
1. Displays full aVendor profile:
   - Business name
   - Description
   - Contact information
   - Address
   - Portfolio/Website links
   - Social media links
   - Ratings and reviews

2. **Inquiry Section:**
   - Shows "Interested in this aVendor?" section
   - Two buttons:
     - ✅ **Yes, I'm Interested** (status: ACCEPTED)
     - ❌ **No, Not Interested** (status: REJECTED)

3. **When user clicks Yes/No:**
   - Inquiry form appears
   - Fields:
     - Customer Name * (required)
     - Customer Email * (required)
     - Customer Phone * (required)
     - Message (optional)
   - Status indicator shows selected choice

4. **On form submit:**
   - Creates `CustomerInquiry` record
   - Status: `ACCEPTED` (Yes) or `REJECTED` (No)
   - Stores in `customer_inquiries` table
   - Shows success message

**Database Table: `customer_inquiries`**
- `id` (auto-generated)
- `vendor_id` (FK to vendors)
- `customer_id`
- `customer_name`
- `customer_email`
- `customer_phone`
- `status` (PENDING, ACCEPTED, REJECTED, CONTACTED)
- `message`
- `created_at`
- `responded_at`

---

## Complete Flow Diagram

```
START
  ↓
[STEP 1] Service Type Selection (/service-types)
  ↓ Click service type
[STEP 2] Role Selection (/select-role)
  ↓ Click Customer or Vendor
[STEP 3] Sub-Services List (/sub-services)
  ↓ Click sub-service
  
  ├─→ [STEP 4A] Customer Request Form (/customer-request)
  │     ↓ Submit form
  │   [STEP 5] Store in DB (customer_service_requests)
  │     ↓ Redirect
  │   [STEP 6] View Vendors (/vendors)
  │     ↓ Click aVendor
  │   [STEP 6B] Vendor Profile (/vendors/:id)
  │     ↓ Select Yes/No
  │   [STEP 6C] Submit Inquiry
  │     ↓ Store in DB (customer_inquiries)
  │   END
  │
  └─→ [STEP 4B] Vendor Application Form (/aVendor-application)
        ↓ Submit form
      [STEP 5] Store in DB (vendor_applications)
        END
```

---

## Database Tables Summary

1. **services** - Service types (Photography, Catering, etc.)
2. **sub_services** - Sub-services (Wedding Photography, etc.)
3. **customer_service_requests** - Customer service requests
4. **vendor_applications** - Vendor applications for sub-services
5. **vendors** - Vendor profiles
6. **customer_inquiries** - Customer inquiries (Yes/No) for vendors

---

## API Endpoints Summary

### Service Types
- `GET /api/services/types` - Get all service types

### Sub-Services
- `GET /api/services/{serviceType}` - Get sub-services by service type

### Customer Requests
- `POST /api/customer/requests` - Create customer service request
- `GET /api/customer/requests/{id}` - Get request by ID
- `GET /api/customer/requests/customer/{customerId}` - Get requests by customer
- `GET /api/customer/requests/subservice/{subServiceId}` - Get requests by sub-service
- `PATCH /api/customer/requests/{id}/status` - Update request status

### Vendor Applications
- `POST /api/vendors/{vendorId}/applications` - Create aVendor application
- `GET /api/vendors/applications` - Get all applications
- `PATCH /api/vendors/applications/{id}/approve` - Approve application
- `PATCH /api/vendors/applications/{id}/reject` - Reject application

### Vendor Profiles (Public)
- `GET /api/vendors/public` - Get all public vendors
- `GET /api/vendors/public/{id}` - Get aVendor profile by ID

### Customer Inquiries
- `POST /api/customer/inquiries` - Create customer inquiry (Yes/No)
- `GET /api/customer/inquiries/{id}` - Get inquiry by ID
- `GET /api/customer/inquiries/aVendor/{vendorId}` - Get inquiries by aVendor
- `GET /api/customer/inquiries/customer/{customerId}` - Get inquiries by customer
- `PATCH /api/customer/inquiries/{id}/status` - Update inquiry status

---

## Navigation Flow

1. **Home** → Click "Explore Services" → `/service-types`
2. **Service Types** → Click service type → `/select-role?serviceType=...`
3. **Role Selection** → Click Customer/Vendor → `/sub-services?serviceType=...&role=...`
4. **Sub-Services** → Click sub-service → `/customer-request` or `/aVendor-application`
5. **Forms** → Submit → Store in DB → Redirect
6. **Vendors** → Click aVendor → `/vendors/:id`
7. **Vendor Profile** → Select Yes/No → Submit inquiry → Store in DB

---

## Testing Checklist

- [ ] Step 1: Service types load correctly
- [ ] Step 2: Role selection navigates correctly
- [ ] Step 3: Sub-services list displays correctly
- [ ] Step 4A: Customer request form submits and stores in DB
- [ ] Step 4B: Vendor application form submits and stores in DB
- [ ] Step 5: Data is stored correctly in database
- [ ] Step 6: Vendor list displays correctly
- [ ] Step 6: Vendor profile displays correctly
- [ ] Step 6: Customer inquiry (Yes/No) submits and stores in DB

---

## Notes

- All forms have validation
- All database operations use transactions
- Error handling is implemented at each step
- Success messages are shown after submissions
- Navigation is smooth with back buttons
- URL parameters are used to pass data between pages

