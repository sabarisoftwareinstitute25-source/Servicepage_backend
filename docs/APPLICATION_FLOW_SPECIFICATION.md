# Application Flow Specification

## Complete Technical Documentation

---

## 📋 Table of Contents

1. [Page Flow Diagram](#page-flow-diagram)
2. [API Endpoints](#api-endpoints)
3. [Database Schema](#database-schema)
4. [UI Structure](#ui-structure)
5. [Implementation Details](#implementation-details)

---

## 🔄 Page Flow Diagram

```
┌─────────────────────────────────────────────────────────────┐
│                    START - Landing Page                      │
│                      (Home Page)                             │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│              STEP 1: Service Type Selection                 │
│                  Route: /service-types                      │
│                                                              │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐     │
│  │ 📸          │  │ 🍽️          │  │ 💐          │     │
│  │ Photography │  │ Catering &  │  │ Decoration   │     │
│  │ & Media     │  │ Food        │  │ & Design     │     │
│  └──────────────┘  └──────────────┘  └──────────────┘     │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│              STEP 2: User Role Selection                    │
│              Route: /select-role?serviceType={type}          │
│                                                              │
│  ┌──────────────────┐    ┌──────────────────┐            │
│  │   👤 Customer    │    │   🏢 Vendor      │            │
│  │                  │    │                  │            │
│  │ I'm looking for │    │ I provide       │            │
│  │ services         │    │ services         │            │
│  └──────────────────┘    └──────────────────┘            │
└────────────┬───────────────────────┬──────────────────────┘
             │                       │
             ▼                       ▼
┌─────────────────────────┐  ┌─────────────────────────┐
│   STEP 3A: Service List │  │   STEP 3B: Service List  │
│   (Customer View)       │  │   (Vendor View)          │
│   Route: /sub-services  │  │   Route: /sub-services   │
│   ?serviceType={type}   │  │   ?serviceType={type}    │
│   &role=customer        │  │   &role=aVendor           │
│                         │  │                         │
│  • Wedding Photography  │  │  • Wedding Photography │
│  • Wedding Videography  │  │  • Wedding Videography  │
│  • Cinematography       │  │  • Cinematography       │
│  • Drone Shoot          │  │  • Drone Shoot          │
│  • Pre-Wedding Shoot    │  │  • Pre-Wedding Shoot    │
│  • Post-Wedding Shoot   │  │  • Post-Wedding Shoot   │
│  • Album Designing      │  │  • Album Designing      │
│  • Photo Editing        │  │  • Photo Editing        │
│  • Live Streaming       │  │  • Live Streaming       │
│  • 360° Video Capture   │  │  • 360° Video Capture   │
└────────────┬─────────────┘  └────────────┬─────────────┘
             │                             │
             ▼                             ▼
┌─────────────────────────┐  ┌─────────────────────────┐
│   STEP 4A: Customer     │  │   STEP 4B: Vendor       │
│   Enquiry Form          │  │   Registration Form     │
│   Route: /customer-     │  │   Route: /aVendor-       │
│   request?subServiceId=  │  │   application?          │
│   {id}&subServiceName=   │  │   subServiceId={id}     │
│   {name}                │  │   &subServiceName={name}│
│                         │  │                         │
│  Fields:                │  │  Fields:                │
│  • Event Date           │  │  • Business Name        │
│  • Location             │  │  • Services Offered    │
│  • Budget               │  │  • Price Range          │
│  • Requirements         │  │  • Experience           │
│  • Contact Info         │  │  • Portfolio            │
│                         │  │  • Contact Info         │
└────────────┬─────────────┘  └────────────┬─────────────┘
             │                             │
             └─────────────┬───────────────┘
                           ▼
┌─────────────────────────────────────────────────────────────┐
│              STEP 5: Database Storage                        │
│                                                              │
│  ┌──────────────────────┐  ┌──────────────────────┐      │
│  │ customer_service_    │  │ vendor_applications  │      │
│  │ requests             │  │                      │      │
│  │                      │  │                      │      │
│  │ • sub_service_id     │  │ • sub_service_id     │      │
│  │ • customer_id       │  │ • vendor_id          │      │
│  │ • event_date         │  │ • business_name      │      │
│  │ • location           │  │ • price_range        │      │
│  │ • budget             │  │ • experience         │      │
│  │ • requirements       │  │ • portfolio          │      │
│  │ • status             │  │ • status             │      │
│  └──────────────────────┘  └──────────────────────┘      │
└────────────────────────┬────────────────────────────────────┘
                         │
                         ▼
┌─────────────────────────────────────────────────────────────┐
│              STEP 6: Vendor Profile Viewing                  │
│                  Route: /vendors                             │
│                                                              │
│  ┌────────────────────────────────────────────────────┐    │
│  │  Vendor List                                      │    │
│  │  • Filter by service type                        │    │
│  │  • Filter by location                            │    │
│  │  • Sort by rating/price                          │    │
│  └────────────────────────────────────────────────────┘    │
│                         │                                    │
│                         ▼                                    │
│  ┌────────────────────────────────────────────────────┐    │
│  │  Vendor Profile                                   │    │
│  │  Route: /vendors/:id                             │    │
│  │                                                   │    │
│  │  • Business Information                          │    │
│  │  • Services Offered                             │    │
│  │  • Price Range                                  │    │
│  │  • Portfolio/Gallery                            │    │
│  │  • Reviews & Ratings                           │    │
│  │  • Contact Information                          │    │
│  │                                                   │    │
│  │  [✅ Select Vendor]  [📧 Contact]  [💬 Inquiry] │    │
│  └────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

---

## 🔌 API Endpoints

### Service Types

#### Get All Service Types
```
GET /api/services/types
Response: {
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

### Sub-Services

#### Get Sub-Services by Service Type
```
GET /api/services/{serviceType}
Example: GET /api/services/PHOTOGRAPHY
Response: {
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

### Customer Service Requests

#### Create Customer Enquiry
```
POST /api/customer/requests
Request Body: {
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
Response: {
  "success": true,
  "message": "Service request submitted successfully",
  "request": {
    "id": 1,
    "subServiceId": 1,
    "subServiceName": "WEDDING_PHOTOGRAPHY",
    "customerId": 1,
    "eventDate": "2024-06-15",
    "eventLocation": "Mumbai, Maharashtra",
    "budget": 50000,
    "status": "PENDING",
    "createdAt": "2024-01-06T12:00:00"
  }
}
```

#### Get Customer Requests
```
GET /api/customer/requests/customer/{customerId}
Response: {
  "success": true,
  "requests": [...],
  "total": 5
}
```

#### Get Requests by Sub-Service
```
GET /api/customer/requests/subservice/{subServiceId}
Response: {
  "success": true,
  "requests": [...],
  "total": 10
}
```

### Vendor Applications

#### Create Vendor Registration
```
POST /api/vendors/{vendorId}/applications
Request Body: {
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
Response: {
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

#### Get Vendor Applications
```
GET /api/vendors/applications?status={status}
Response: {
  "success": true,
  "applications": [...],
  "total": 20
}
```

### Vendor Profiles (Public)

#### Get All Vendors
```
GET /api/vendors/public?city={city}&serviceType={serviceType}
Response: {
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

#### Get Vendor Profile by ID
```
GET /api/vendors/public/{id}
Response: {
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
    "yearsOfExperience": 5,
    "servicesOffered": ["Wedding Photography", "Pre-Wedding Shoot"]
  }
}
```

### Customer Inquiries

#### Create Customer Inquiry (Select/Contact Vendor)
```
POST /api/customer/inquiries
Request Body: {
  "vendorId": 1,
  "customerId": 1,
  "customerName": "John Doe",
  "customerEmail": "john@example.com",
  "customerPhone": "9876543210",
  "status": "ACCEPTED",
  "message": "Interested in your wedding photography services"
}
Response: {
  "success": true,
  "message": "Inquiry submitted successfully",
  "inquiry": {
    "id": 1,
    "vendorId": 1,
    "customerId": 1,
    "status": "ACCEPTED",
    "createdAt": "2024-01-06T12:00:00"
  }
}
```

#### Get Vendor Inquiries
```
GET /api/customer/inquiries/aVendor/{vendorId}
Response: {
  "success": true,
  "inquiries": [...],
  "total": 15
}
```

---

## 🗄️ Database Schema

### PostgreSQL Schema

```sql
-- Service Types Table
CREATE TABLE services (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    display_name VARCHAR(200),
    description TEXT,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Sub-Services Table
CREATE TABLE sub_services (
    id BIGSERIAL PRIMARY KEY,
    service_id BIGINT NOT NULL REFERENCES services(id),
    name VARCHAR(100) NOT NULL,
    display_name VARCHAR(200),
    description TEXT,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(service_id, name)
);

-- Customer Service Requests Table
CREATE TABLE customer_service_requests (
    id BIGSERIAL PRIMARY KEY,
    sub_service_id BIGINT NOT NULL REFERENCES sub_services(id),
    customer_id BIGINT NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(20) NOT NULL,
    event_date DATE,
    event_location VARCHAR(500),
    budget DECIMAL(10, 2),
    requirements TEXT,
    status VARCHAR(20) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_status CHECK (status IN ('PENDING', 'ACCEPTED', 'REJECTED', 'COMPLETED'))
);

-- Vendor Applications Table
CREATE TABLE vendor_applications (
    id BIGSERIAL PRIMARY KEY,
    vendor_id BIGINT NOT NULL,
    sub_service_id BIGINT NOT NULL REFERENCES sub_services(id),
    business_name VARCHAR(200) NOT NULL,
    business_description TEXT,
    contact_person_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(255) NOT NULL,
    contact_phone VARCHAR(20) NOT NULL,
    business_address TEXT,
    city VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(10),
    price_range VARCHAR(50),
    years_of_experience INTEGER,
    portfolio_url TEXT,
    website_url TEXT,
    services_offered TEXT,
    certifications TEXT,
    documents TEXT,
    status VARCHAR(20) DEFAULT 'PENDING',
    rejection_reason TEXT,
    reviewed_at TIMESTAMP,
    reviewed_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_app_status CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED'))
);

-- Vendors Table (Approved Vendor Profiles)
CREATE TABLE vendors (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    business_name VARCHAR(200) NOT NULL,
    business_description TEXT,
    contact_person_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(255) NOT NULL,
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
    price_range VARCHAR(50),
    years_of_experience INTEGER,
    average_rating DECIMAL(3, 2) DEFAULT 0,
    total_reviews INTEGER DEFAULT 0,
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_vendor_status CHECK (status IN ('ACTIVE', 'INACTIVE', 'SUSPENDED'))
);

-- Vendor Sub-Services (Many-to-Many: Vendors can offer multiple sub-services)
CREATE TABLE vendor_sub_services (
    id BIGSERIAL PRIMARY KEY,
    vendor_id BIGINT NOT NULL REFERENCES vendors(id),
    sub_service_id BIGINT NOT NULL REFERENCES sub_services(id),
    price_range VARCHAR(50),
    starting_price DECIMAL(10, 2),
    pricing_model VARCHAR(50),
    status VARCHAR(20) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE(vendor_id, sub_service_id)
);

-- Customer Inquiries Table
CREATE TABLE customer_inquiries (
    id BIGSERIAL PRIMARY KEY,
    vendor_id BIGINT NOT NULL REFERENCES vendors(id),
    customer_id BIGINT NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    customer_email VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(20) NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDING',
    message TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    responded_at TIMESTAMP,
    CONSTRAINT chk_inquiry_status CHECK (status IN ('PENDING', 'ACCEPTED', 'REJECTED', 'CONTACTED'))
);

-- Indexes for Performance
CREATE INDEX idx_sub_services_service_id ON sub_services(service_id);
CREATE INDEX idx_customer_requests_sub_service ON customer_service_requests(sub_service_id);
CREATE INDEX idx_customer_requests_customer ON customer_service_requests(customer_id);
CREATE INDEX idx_customer_requests_status ON customer_service_requests(status);
CREATE INDEX idx_vendor_applications_vendor ON vendor_applications(vendor_id);
CREATE INDEX idx_vendor_applications_sub_service ON vendor_applications(sub_service_id);
CREATE INDEX idx_vendor_applications_status ON vendor_applications(status);
CREATE INDEX idx_vendors_city ON vendors(city);
CREATE INDEX idx_vendors_status ON vendors(status);
CREATE INDEX idx_customer_inquiries_vendor ON customer_inquiries(vendor_id);
CREATE INDEX idx_customer_inquiries_customer ON customer_inquiries(customer_id);
```

---

## 🎨 UI Structure

### Step 1: Service Type Selection Page

```jsx
// ServiceTypeSelection.jsx
<div className="service-type-container">
  <h1>Select Service Type</h1>
  <p>Choose the type of service you're looking for</p>
  
  <div className="service-types-grid">
    <div className="service-type-card" onClick={handleClick}>
      <div className="icon">📸</div>
      <h3>Photography & Media</h3>
      <p>Professional photography and media services</p>
    </div>
    
    <div className="service-type-card" onClick={handleClick}>
      <div className="icon">🍽️</div>
      <h3>Catering & Food</h3>
      <p>Delicious catering and food services</p>
    </div>
    
    {/* More service types... */}
  </div>
</div>
```

### Step 2: Role Selection Page

```jsx
// RoleSelection.jsx
<div className="role-selection-container">
  <h1>Are you a Customer or Vendor?</h1>
  <p>Select your role to continue</p>
  
  <div className="role-cards">
    <div className="role-card customer-card" onClick={handleCustomerClick}>
      <div className="icon">👤</div>
      <h2>Customer</h2>
      <p>I'm looking for services</p>
      <p className="description">
        Browse vendors and request services for your special day
      </p>
      <button>Continue as Customer</button>
    </div>
    
    <div className="role-card aVendor-card" onClick={handleVendorClick}>
      <div className="icon">🏢</div>
      <h2>Vendor</h2>
      <p>I provide services</p>
      <p className="description">
        Apply to offer your services and reach more customers
      </p>
      <button>Continue as Vendor</button>
    </div>
  </div>
</div>
```

### Step 3: Sub-Services List Page

```jsx
// SubServicesList.jsx
<div className="sub-services-container">
  <h1>Select a Service</h1>
  <p>Choose the specific service you need</p>
  
  <div className="sub-services-grid">
    {subServices.map(subService => (
      <div 
        key={subService.id} 
        className="sub-service-card"
        onClick={() => handleSubServiceClick(subService)}
      >
        <div className="icon">✨</div>
        <h3>{formatName(subService.name)}</h3>
        <p>{subService.description}</p>
        <button>
          {role === 'customer' ? 'Request Service' : 'Apply Now'}
        </button>
      </div>
    ))}
  </div>
</div>
```

### Step 4A: Customer Enquiry Form

```jsx
// CustomerServiceRequest.jsx
<form onSubmit={handleSubmit}>
  <h2>Request Service: {subServiceName}</h2>
  
  <div className="form-group">
    <label>Your Name *</label>
    <input 
      type="text" 
      name="customerName" 
      required 
    />
  </div>
  
  <div className="form-group">
    <label>Your Email *</label>
    <input 
      type="email" 
      name="customerEmail" 
      required 
    />
  </div>
  
  <div className="form-group">
    <label>Your Phone *</label>
    <input 
      type="tel" 
      name="customerPhone" 
      required 
    />
  </div>
  
  <div className="form-group">
    <label>Event Date</label>
    <input 
      type="date" 
      name="eventDate" 
    />
  </div>
  
  <div className="form-group">
    <label>Event Location</label>
    <input 
      type="text" 
      name="eventLocation" 
      placeholder="City, State" 
    />
  </div>
  
  <div className="form-group">
    <label>Budget (₹)</label>
    <input 
      type="number" 
      name="budget" 
      placeholder="50000" 
    />
  </div>
  
  <div className="form-group">
    <label>Requirements</label>
    <textarea 
      name="requirements" 
      rows="5"
      placeholder="Describe your requirements..."
    />
  </div>
  
  <button type="submit">Submit Request</button>
</form>
```

### Step 4B: Vendor Registration Form

```jsx
// VendorApplication.jsx
<form onSubmit={handleSubmit}>
  <div className="sub-service-info">
    Applying for: {subServiceName}
  </div>
  
  <h2>Vendor Registration Form</h2>
  
  <div className="form-group">
    <label>Vendor ID *</label>
    <input 
      type="number" 
      name="vendorId" 
      required 
    />
  </div>
  
  <div className="form-group">
    <label>Sub-Service ID *</label>
    <input 
      type="number" 
      name="subServiceId" 
      value={subServiceId}
      readOnly 
    />
  </div>
  
  <h3>Business Information</h3>
  <div className="form-group">
    <label>Business Name *</label>
    <input 
      type="text" 
      name="businessName" 
      required 
    />
  </div>
  
  <div className="form-group">
    <label>Business Description</label>
    <textarea 
      name="businessDescription" 
      rows="4"
    />
  </div>
  
  <h3>Contact Information</h3>
  <div className="form-group">
    <label>Contact Person Name *</label>
    <input 
      type="text" 
      name="contactPersonName" 
      required 
    />
  </div>
  
  <div className="form-group">
    <label>Contact Email *</label>
    <input 
      type="email" 
      name="contactEmail" 
      required 
    />
  </div>
  
  <div className="form-group">
    <label>Contact Phone *</label>
    <input 
      type="tel" 
      name="contactPhone" 
      required 
    />
  </div>
  
  <h3>Business Details</h3>
  <div className="form-group">
    <label>Price Range</label>
    <input 
      type="text" 
      name="priceRange" 
      placeholder="30000-100000" 
    />
  </div>
  
  <div className="form-group">
    <label>Years of Experience</label>
    <input 
      type="number" 
      name="yearsOfExperience" 
      min="0" 
    />
  </div>
  
  <div className="form-group">
    <label>Portfolio URL</label>
    <input 
      type="url" 
      name="portfolioUrl" 
    />
  </div>
  
  <div className="form-group">
    <label>Services Offered</label>
    <textarea 
      name="servicesOffered" 
      rows="3"
      placeholder="Wedding Photography, Pre-Wedding Shoot..."
    />
  </div>
  
  <button type="submit">Submit Application</button>
</form>
```

### Step 6: Vendor Profile Viewing

```jsx
// VendorList.jsx
<div className="aVendor-list-container">
  <h1>Browse Vendors</h1>
  
  <div className="filters">
    <select onChange={handleCityFilter}>
      <option value="">All Cities</option>
      <option value="Mumbai">Mumbai</option>
      <option value="Delhi">Delhi</option>
    </select>
    
    <select onChange={handleServiceFilter}>
      <option value="">All Services</option>
      <option value="PHOTOGRAPHY">Photography</option>
      <option value="CATERING">Catering</option>
    </select>
  </div>
  
  <div className="aVendor-grid">
    {vendors.map(aVendor => (
      <div 
        key={aVendor.id} 
        className="aVendor-card"
        onClick={() => navigate(`/vendors/${aVendor.id}`)}
      >
        <h3>{aVendor.businessName}</h3>
        <p>📍 {aVendor.city}, {aVendor.state}</p>
        <div className="rating">
          ⭐ {aVendor.averageRating} ({aVendor.totalReviews} reviews)
        </div>
        <p className="price-range">₹{aVendor.priceRange}</p>
        <button>View Profile</button>
      </div>
    ))}
  </div>
</div>
```

```jsx
// VendorProfile.jsx
<div className="aVendor-profile-container">
  <button onClick={() => navigate('/vendors')}>← Back</button>
  
  <div className="aVendor-header">
    <h1>{aVendor.businessName}</h1>
    <p>📍 {aVendor.city}, {aVendor.state}</p>
    <div className="rating">
      ⭐ {aVendor.averageRating} ({aVendor.totalReviews} reviews)
    </div>
  </div>
  
  <div className="aVendor-content">
    <section>
      <h2>About</h2>
      <p>{aVendor.businessDescription}</p>
    </section>
    
    <section>
      <h2>Services Offered</h2>
      <ul>
        {aVendor.servicesOffered.map(service => (
          <li key={service}>{service}</li>
        ))}
      </ul>
    </section>
    
    <section>
      <h2>Price Range</h2>
      <p>₹{aVendor.priceRange}</p>
    </section>
    
    <section>
      <h2>Portfolio</h2>
      <a href={aVendor.portfolioUrl} target="_blank">View Portfolio</a>
    </section>
    
    <section>
      <h2>Contact Information</h2>
      <p>Email: {aVendor.contactEmail}</p>
      <p>Phone: {aVendor.contactPhone}</p>
    </section>
  </div>
  
  <div className="inquiry-section">
    <h2>Interested in this aVendor?</h2>
    <div className="inquiry-buttons">
      <button onClick={() => handleInquiry('ACCEPTED')}>
        ✅ Yes, I'm Interested
      </button>
      <button onClick={() => handleInquiry('REJECTED')}>
        ❌ No, Not Interested
      </button>
    </div>
    
    {showInquiryForm && (
      <form onSubmit={handleSubmitInquiry}>
        <input name="customerName" placeholder="Your Name" required />
        <input name="customerEmail" placeholder="Your Email" required />
        <input name="customerPhone" placeholder="Your Phone" required />
        <textarea name="message" placeholder="Message (optional)" />
        <button type="submit">Submit Inquiry</button>
      </form>
    )}
  </div>
</div>
```

---

## 📝 Implementation Details

### Frontend Routes

```javascript
// App.jsx
<Routes>
  <Route path="/" element={<Home />} />
  <Route path="/service-types" element={<ServiceTypeSelection />} />
  <Route path="/select-role" element={<RoleSelection />} />
  <Route path="/sub-services" element={<SubServicesList />} />
  <Route path="/customer-request" element={<CustomerServiceRequest />} />
  <Route path="/aVendor-application" element={<VendorApplication />} />
  <Route path="/vendors" element={<VendorList />} />
  <Route path="/vendors/:id" element={<VendorProfile />} />
</Routes>
```

### Backend Controllers

- `ServiceController` - Service types and sub-services
- `CustomerServiceRequestController` - Customer enquiries
- `VendorApplicationController` - Vendor registrations
- `VendorController` - Vendor profiles (public)
- `CustomerInquiryController` - Customer inquiries

### Data Flow

1. **Service Type Selection** → Fetches from `services` table
2. **Sub-Services List** → Fetches from `sub_services` table filtered by `service_id`
3. **Customer Request** → Stores in `customer_service_requests` table
4. **Vendor Application** → Stores in `vendor_applications` table
5. **Vendor List** → Fetches from `vendors` table (status = ACTIVE)
6. **Vendor Profile** → Fetches from `vendors` table by ID
7. **Customer Inquiry** → Stores in `customer_inquiries` table

---

## ✅ Complete Implementation Checklist

- [x] Step 1: Service Type Selection Page
- [x] Step 2: User Role Selection Page
- [x] Step 3: Sub-Services List Page
- [x] Step 4A: Customer Enquiry Form
- [x] Step 4B: Vendor Registration Form
- [x] Step 5: Database Storage (All Tables)
- [x] Step 6: Vendor Profile Viewing & Selection
- [x] API Endpoints (All Implemented)
- [x] Database Schema (PostgreSQL Ready)
- [x] UI Components (React Components)
- [x] Routing (React Router)
- [x] Form Validation
- [x] Error Handling
- [x] Success Messages

---

**All requirements have been implemented and are ready for use!** 🎉

