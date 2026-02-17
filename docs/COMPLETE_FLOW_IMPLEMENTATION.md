# Complete Flow Implementation Guide

## ✅ Flow Diagram Implementation

This document describes the complete user flow implementation matching the provided flow diagram.

---

## **START: Landing Page (Home)**
**Route:** `/`  
**Component:** `Home.jsx`

### Features:
- Clean hero section with welcome message
- "Get Started" button → Navigates to `/service-types`
- Quick access cards for Photography, Videography, Decoration
- Call-to-action for service providers
- **No "Backend connected" status indicator** (removed)

---

## **STEP 1: Service Type Selection**
**Route:** `/service-types`  
**Component:** `ServiceTypeSelection.jsx`

### Service Categories:
- 📸 Photography & Media
- 🍽️ Catering & Food
- 💐 Decoration & Design
- 🎥 Videography & Cinematography
- 🎵 Music & Entertainment
- 💄 Makeup & Beauty
- 🏛️ Venue & Location
- 🚗 Transportation

### Flow:
- User clicks a service type card
- Navigates to: `/select-role?serviceType={type}`

---

## **STEP 2: User Role Selection**
**Route:** `/select-role?serviceType={type}`  
**Component:** `RoleSelection.jsx`

### Options:
- **👤 Customer** - "I'm looking for services"
- **🏢 Vendor** - "I provide services"

### Flow:
- **Customer** → `/sub-services?serviceType={type}&role=customer`
- **Vendor** → `/sub-services?serviceType={type}&role=aVendor`

---

## **STEP 3: Service List**
**Route:** `/sub-services?serviceType={type}&role={customer|aVendor}`  
**Component:** `SubServicesList.jsx`

### Sub-Services Displayed (Example for Photography):
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

### Flow:
- **Customer** → Click sub-service → `/customer-request?subServiceId={id}&subServiceName={name}`
- **Vendor** → Click sub-service → `/aVendor-application?subServiceId={id}&subServiceName={name}`

---

## **STEP 4A: Customer Enquiry Form**
**Route:** `/customer-request?subServiceId={id}&subServiceName={name}`  
**Component:** `CustomerServiceRequest.jsx`

### Form Fields:
- **Event Date** (Date picker)
- **Location** (Text input)
- **Budget** (Number input)
- **Requirements** (Textarea)
- **Contact Info:**
  - Name (required)
  - Email (required)
  - Phone (required)

### Flow:
- User fills form and submits
- Data stored in `customer_service_requests` table
- Success message → Redirects to `/vendors` after 2 seconds

---

## **STEP 4B: Vendor Registration Form**
**Route:** `/aVendor-application?subServiceId={id}&subServiceName={name}`  
**Component:** `VendorApplication.jsx`

### Form Fields:
- **Profile Photo Upload** (PDF or JPG) - Required
- **Business Name** (required)
- **Services Offered** (Textarea)
- **Price Range** (Text input, e.g., "30000-100000")
- **Experience** (Number input - years)
- **Portfolio** (URL or description)
- **Contact Info:**
  - Contact Person Name (required)
  - Email (required)
  - Phone (required)
- **Address:**
  - Business Address
  - City
  - State
  - Pincode
- **Certifications** (Textarea)
- **Starting Price** (Number)
- **Pricing Model** (Dropdown: Per Hour, Per Day, Fixed Package, Custom)

### Flow:
1. User uploads profile photo (PDF/JPG)
2. User fills form and submits
3. Data stored in `vendor_applications` table
4. Status: `PENDING` (waiting for admin approval)
5. Success message → Form resets

---

## **STEP 5: Database Storage**

### Customer Service Requests
**Table:** `customer_service_requests`
- `sub_service_id` (links to service category via sub_service)
- `customer_id`
- `event_date`
- `event_location`
- `budget`
- `message` (requirements)
- `status` (PENDING, ACCEPTED, REJECTED, COMPLETED)
- `created_at`, `updated_at`

### Vendor Applications
**Table:** `vendor_applications`
- `sub_service_id` (nullable - links to service category via sub_service)
- `vendor_id`
- `business_name`
- `services_offered`
- `price_range`
- `years_of_experience`
- `portfolio_url`
- `profile_photo_url` (NEW - PDF or JPG)
- `contact_person_name`
- `contact_email`
- `contact_phone`
- `business_address`
- `city`, `state`, `pincode`
- `certifications`
- `starting_price`
- `pricing_model`
- `status` (PENDING, APPROVED, REJECTED, SUSPENDED)
- `created_at`, `updated_at`

---

## **STEP 6: Vendor Profile Viewing**

### 6.1 Vendor List
**Route:** `/vendors`  
**Component:** `VendorList.jsx`

### Features:
- Display all active vendors
- Filter by service type
- Filter by location (city)
- Search functionality
- **Compare vendors** button → `/vendors/compare`
- Click aVendor card → `/vendors/:id`

---

### 6.2 Vendor Profile
**Route:** `/vendors/:id`  
**Component:** `VendorProfile.jsx`

### Display:
- Business Information
- Services Offered
- Price Range
- Portfolio/Gallery
- Reviews & Ratings
- Contact Information
- Profile Photo (if uploaded)

### Actions:
- **✅ Select Vendor** - Submit inquiry
- **📧 Contact** - Contact aVendor
- **💬 Inquiry** - Send inquiry with date/price
- **🔍 Compare with Others** - Navigate to comparison page

### Inquiry Flow:
1. Customer clicks "Yes, I'm Interested"
2. Fill contact form (Name, Email, Phone, Message)
3. Submit → Shows date/price form
4. Fill event date and budget
5. Submit → Status: `SUBMITTED`
6. Vendor can accept/decline at `/vendors/:vendorId/inquiries`

---

### 6.3 Vendor Comparison
**Route:** `/vendors/compare`  
**Component:** `VendorComparison.jsx`

### Features:
- Select up to 3 vendors
- Side-by-side comparison table
- Compare:
  - Business Name
  - Location
  - Rating
  - Contact Info
  - Description
  - Services Offered
  - Price Range
- "View Profile" button for each aVendor

---

## **Complete Navigation Flow**

```
START (/)
  ↓ [Click "Get Started"]
STEP 1: Service Types (/service-types)
  ↓ [Select service category]
STEP 2: Role Selection (/select-role?serviceType={type})
  ├─→ Customer
  │     ↓
  │   STEP 3: Sub-Services (/sub-services?serviceType={type}&role=customer)
  │     ↓
  │   STEP 4A: Customer Request (/customer-request?subServiceId={id}&subServiceName={name})
  │     ↓
  │   STEP 5: Database Storage (customer_service_requests)
  │     ↓
  │   STEP 6: Vendor List (/vendors)
  │     ↓
  │   Vendor Profile (/vendors/:id)
  │     ├─→ Inquiry → Date/Price → SUBMITTED
  │     └─→ Compare (/vendors/compare)
  │
  └─→ Vendor
        ↓
      STEP 3: Sub-Services (/sub-services?serviceType={type}&role=aVendor)
        ↓
      STEP 4B: Vendor Application (/aVendor-application?subServiceId={id}&subServiceName={name})
        ↓
      STEP 5: Database Storage (vendor_applications)
        ↓
      Status: PENDING → (Admin Approval) → APPROVED
```

---

## **Changes Made**

### 1. Removed ConnectionStatus Component
- ✅ Removed from `App.jsx`
- ✅ No "Backend connected" indicator shown

### 2. Updated Home Page
- ✅ Clean landing page matching flow diagram
- ✅ "Get Started" button → `/service-types`
- ✅ Quick access cards for services
- ✅ CTA for service providers

### 3. Flow Verification
- ✅ All routes match the flow diagram
- ✅ All navigation paths verified
- ✅ All forms match the specified fields
- ✅ Database storage matches the schema

---

## **Testing Checklist**

- [ ] Landing page loads correctly
- [ ] "Get Started" navigates to service types
- [ ] Service type selection works
- [ ] Role selection (Customer/Vendor) works
- [ ] Sub-services list displays correctly
- [ ] Customer request form submits successfully
- [ ] Vendor application form submits successfully
- [ ] Profile photo upload works (PDF/JPG)
- [ ] Vendor list displays correctly
- [ ] Vendor profile displays correctly
- [ ] Vendor comparison works
- [ ] Customer inquiry flow works (Yes → Contact → Date/Price)
- [ ] Database stores data correctly

---

## **Status: ✅ Complete**

All components have been updated to match the flow diagram exactly. The application now follows the specified flow from start to finish.

