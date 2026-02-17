# Step-by-Step Flow - Line by Line

## Complete User Journey

---

## **STEP 1: First Page - Service Type Selection**

**Page:** `/service-types`  
**What User Sees:**
```
┌─────────────────────────────────────┐
│   Select Service Type                │
│   Choose the type of service         │
│   you're looking for                │
├─────────────────────────────────────┤
│                                     │
│  ┌──────────────┐  ┌──────────────┐│
│  │ 📸           │  │ 🍽️           ││
│  │ Photography  │  │ Catering &    ││
│  │ & Media      │  │ Food          ││
│  └──────────────┘  └──────────────┘│
│                                     │
│  ┌──────────────┐  ┌──────────────┐│
│  │ 💐           │  │ 🎥           ││
│  │ Decoration   │  │ Videography  ││
│  │ & Design     │  │ & Cinema     ││
│  └──────────────┘  └──────────────┘│
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Click on "Photography & Media"  
**Result:** Navigate to `/select-role?serviceType=PHOTOGRAPHY`

**Backend:** `GET /api/services/types` → Returns list from `services` table

---

## **STEP 2: Select Customer or Vendor**

**Page:** `/select-role?serviceType=PHOTOGRAPHY`  
**What User Sees:**
```
┌─────────────────────────────────────┐
│   Are you a Customer or Vendor?      │
│   Select your role to continue      │
├─────────────────────────────────────┤
│                                     │
│  ┌──────────────────────────────┐  │
│  │         👤                   │  │
│  │      Customer                │  │
│  │  I'm looking for services    │  │
│  │                              │  │
│  │  Browse vendors and request  │  │
│  │  services for your special   │  │
│  │  day                         │  │
│  │                              │  │
│  │  [Continue as Customer]      │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │         🏢                   │  │
│  │      Vendor                  │  │
│  │  I provide services          │  │
│  │                              │  │
│  │  Apply to offer your         │  │
│  │  services and reach more     │  │
│  │  customers                   │  │
│  │                              │  │
│  │  [Continue as Vendor]        │  │
│  └──────────────────────────────┘  │
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Click "Continue as Customer"  
**Result:** Navigate to `/sub-services?serviceType=PHOTOGRAPHY&role=customer`

---

## **STEP 3: View Sub-Services List**

**Page:** `/sub-services?serviceType=PHOTOGRAPHY&role=customer`  
**What User Sees:**
```
┌─────────────────────────────────────┐
│   ← Back                            │
│                                     │
│   Select a Service                  │
│   Choose the specific service       │
│   you need                          │
├─────────────────────────────────────┤
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Wedding Photography           │  │
│  │ Professional wedding photos    │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Wedding Videography           │  │
│  │ Capture your special moments  │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Cinematography                │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Drone Shoot                   │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Pre-Wedding Shoot             │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Post-Wedding Shoot            │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Album Designing               │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Photo Editing / Retouching    │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ Live Wedding Streaming        │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ✨                            │  │
│  │ 360° Video Capture           │  │
│  │ [Request Service]              │  │
│  └──────────────────────────────┘  │
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Click "Request Service" on "Wedding Photography"  
**Result:** Navigate to `/customer-request?subServiceId=1&subServiceName=WEDDING_PHOTOGRAPHY`

**Backend:** `GET /api/services/PHOTOGRAPHY` → Returns sub-services from `sub_services` table

---

## **STEP 4A: Customer Fills Form**

**Page:** `/customer-request?subServiceId=1&subServiceName=WEDDING_PHOTOGRAPHY`  
**What User Sees:**
```
┌─────────────────────────────────────┐
│   ← Back                            │
│                                     │
│   Request Service                   │
│   Fill out the form to request:    │
│   Wedding Photography               │
├─────────────────────────────────────┤
│                                     │
│  Your Name *                        │
│  [_____________________________]    │
│                                     │
│  Your Email *                       │
│  [_____________________________]    │
│                                     │
│  Your Phone *                       │
│  [_____________________________]    │
│                                     │
│  Event Date                         │
│  [_____________________________]    │
│                                     │
│  Event Location                     │
│  [_____________________________]    │
│                                     │
│  Additional Requirements            │
│  [_____________________________]    │
│  [_____________________________]    │
│                                     │
│  [Submit Request]  [Cancel]         │
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Fill form and click "Submit Request"  
**Backend:** `POST /api/customer/requests`  
**Database:** Stores in `customer_service_requests` table:
```sql
INSERT INTO customer_service_requests (
  sub_service_id,
  customer_id,
  customer_name,
  customer_email,
  customer_phone,
  event_date,
  event_location,
  message,
  status
) VALUES (
  1,                    -- sub_service_id
  1,                    -- customer_id
  'John Doe',           -- customer_name
  'john@example.com',   -- customer_email
  '9876543210',         -- customer_phone
  '2024-06-15',         -- event_date
  'Mumbai',             -- event_location
  'Need professional...', -- message
  'PENDING'             -- status
);
```

**Result:** Success message → Redirect to `/vendors`

---

## **STEP 4B: Vendor Fills Form**

**Page:** `/aVendor-application?subServiceId=1&subServiceName=WEDDING_PHOTOGRAPHY`  
**What User Sees:**
```
┌─────────────────────────────────────┐
│   Applying for: Wedding Photography │
│                                     │
│   Vendor Application Form           │
│   Fill out the form below to apply │
├─────────────────────────────────────┤
│                                     │
│  Vendor ID *                        │
│  [_____________________________]    │
│                                     │
│  Sub-Service ID *                   │
│  [1] (read-only, pre-filled)       │
│                                     │
│  Business Name *                    │
│  [_____________________________]    │
│                                     │
│  Contact Person Name *              │
│  [_____________________________]    │
│                                     │
│  Contact Email *                    │
│  [_____________________________]    │
│                                     │
│  Contact Phone *                    │
│  [_____________________________]    │
│                                     │
│  ... (more fields) ...             │
│                                     │
│  [Submit Application]  [Reset]     │
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Fill form and click "Submit Application"  
**Backend:** `POST /api/vendors/{vendorId}/applications`  
**Database:** Stores in `vendor_applications` table:
```sql
INSERT INTO vendor_applications (
  vendor_id,
  sub_service_id,
  business_name,
  contact_person_name,
  contact_email,
  contact_phone,
  ...
  status
) VALUES (
  1,                    -- vendor_id
  1,                    -- sub_service_id
  'ABC Photography',    -- business_name
  'John Smith',         -- contact_person_name
  'abc@photo.com',      -- contact_email
  '9876543210',         -- contact_phone
  ...
  'PENDING'            -- status
);
```

**Result:** Success message → Form resets

---

## **STEP 5: Store in Database**

### Customer Service Request
**Table:** `customer_service_requests`
```sql
CREATE TABLE customer_service_requests (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  sub_service_id BIGINT NOT NULL,
  customer_id BIGINT NOT NULL,
  customer_name VARCHAR(100) NOT NULL,
  customer_email VARCHAR(255) NOT NULL,
  customer_phone VARCHAR(20) NOT NULL,
  event_date TEXT,
  event_location TEXT,
  message TEXT,
  status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP,
  FOREIGN KEY (sub_service_id) REFERENCES sub_services(id)
);
```

### Vendor Application
**Table:** `vendor_applications`
```sql
CREATE TABLE vendor_applications (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  vendor_id BIGINT NOT NULL,
  sub_service_id BIGINT NOT NULL,
  business_name VARCHAR(200) NOT NULL,
  contact_person_name VARCHAR(100) NOT NULL,
  contact_email VARCHAR(255) NOT NULL,
  contact_phone VARCHAR(20) NOT NULL,
  ...
  status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP,
  FOREIGN KEY (sub_service_id) REFERENCES sub_services(id)
);
```

---

## **STEP 6: Customer Views Vendor Profile & Selects Option**

### 6A. Vendor List Page
**Page:** `/vendors`  
**What User Sees:**
```
┌─────────────────────────────────────┐
│   Browse Vendors                    │
│                                     │
│  Filter by City: [Select City ▼]   │
├─────────────────────────────────────┤
│                                     │
│  ┌──────────────────────────────┐  │
│  │ ABC Photography              │  │
│  │ 📍 Mumbai, Maharashtra       │  │
│  │ ⭐⭐⭐⭐⭐ (4.5)              │  │
│  │ 120 reviews                  │  │
│  │ [View Profile]               │  │
│  └──────────────────────────────┘  │
│                                     │
│  ┌──────────────────────────────┐  │
│  │ XYZ Studios                  │  │
│  │ 📍 Delhi, Delhi              │  │
│  │ ⭐⭐⭐⭐☆ (4.0)              │  │
│  │ 85 reviews                   │  │
│  │ [View Profile]               │  │
│  └──────────────────────────────┘  │
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Click "View Profile" on "ABC Photography"  
**Result:** Navigate to `/vendors/123`

**Backend:** `GET /api/vendors/public` → Returns vendors from `vendors` table

---

### 6B. Vendor Profile Page
**Page:** `/vendors/123`  
**What User Sees:**
```
┌─────────────────────────────────────┐
│   ← Back to Vendors                 │
│                                     │
│   ABC Photography                   │
│   📍 Mumbai, Maharashtra            │
│   ⭐⭐⭐⭐⭐ (4.5) - 120 reviews │
├─────────────────────────────────────┤
│                                     │
│   About                             │
│   Professional wedding photography  │
│   services...                       │
│                                     │
│   Contact Information               │
│   Contact Person: John Smith        │
│   Email: abc@photo.com              │
│   Phone: 9876543210                │
│                                     │
│   Address                           │
│   123 Main Street                   │
│   Mumbai, Maharashtra 400001      │
│                                     │
│   ──────────────────────────────── │
│                                     │
│   Interested in this aVendor?         │
│                                     │
│   Would you like to proceed with    │
│   this aVendor?                      │
│                                     │
│   [✅ Yes, I'm Interested]         │
│   [❌ No, Not Interested]            │
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Click "Yes, I'm Interested"  
**Result:** Inquiry form appears

---

### 6C. Inquiry Form
**What User Sees:**
```
┌─────────────────────────────────────┐
│   Status: ✅ Interested              │
│                                     │
│   Your Name *                       │
│   [_____________________________]    │
│                                     │
│   Your Email *                      │
│   [_____________________________]    │
│                                     │
│   Your Phone *                      │
│   [_____________________________]    │
│                                     │
│   Message (Optional)                │
│   [_____________________________]    │
│   [_____________________________]    │
│                                     │
│   [Submit Inquiry]  [Cancel]       │
│                                     │
└─────────────────────────────────────┘
```

**User Action:** Fill form and click "Submit Inquiry"  
**Backend:** `POST /api/customer/inquiries`  
**Database:** Stores in `customer_inquiries` table:
```sql
INSERT INTO customer_inquiries (
  vendor_id,
  customer_id,
  customer_name,
  customer_email,
  customer_phone,
  status,
  message
) VALUES (
  123,                  -- vendor_id
  1,                    -- customer_id
  'John Doe',           -- customer_name
  'john@example.com',   -- customer_email
  '9876543210',         -- customer_phone
  'ACCEPTED',           -- status (Yes)
  'Interested in...'    -- message
);
```

**Result:** Success message → "✅ Your inquiry has been submitted successfully!"

---

## Complete Flow Summary

```
1. /service-types
   ↓ Click "Photography & Media"
2. /select-role?serviceType=PHOTOGRAPHY
   ↓ Click "Customer"
3. /sub-services?serviceType=PHOTOGRAPHY&role=customer
   ↓ Click "Wedding Photography"
4. /customer-request?subServiceId=1&subServiceName=WEDDING_PHOTOGRAPHY
   ↓ Fill form & Submit
5. Database: customer_service_requests table
   ↓ Redirect
6. /vendors
   ↓ Click aVendor
7. /vendors/123
   ↓ Click "Yes, I'm Interested"
8. Fill inquiry form & Submit
9. Database: customer_inquiries table
   ✅ Complete!
```

---

## All Steps Verified ✅

Every step is implemented and connected correctly!

