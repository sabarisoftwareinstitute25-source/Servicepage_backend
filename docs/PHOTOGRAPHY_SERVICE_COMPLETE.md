# Photography & Media Service - Complete Setup Guide

## ✅ Service Structure Configured

### Service Type
**Name:** Photography & Media  
**Database Name:** `PHOTOGRAPHY`  
**Display Name:** Photography & Media

### Sub-Services (10 Total)

1. **Wedding Photography** (`WEDDING_PHOTOGRAPHY`)
2. **Wedding Videography** (`WEDDING_VIDEOGRAPHY`)
3. **Cinematography** (`CINEMATOGRAPHY`)
4. **Drone Shoot** (`DRONE_SHOOT`)
5. **Pre-Wedding Shoot** (`PRE_WEDDING_SHOOT`)
6. **Post-Wedding Shoot** (`POST_WEDDING_SHOOT`)
7. **Album Designing** (`ALBUM_DESIGNING`)
8. **Photo Editing / Retouching** (`PHOTO_EDITING_RETOUCHING`)
9. **Live Wedding Streaming** (`LIVE_WEDDING_STREAMING`)
10. **360° Video Capture** (`360_VIDEO_CAPTURE`)

---

## 🚀 Setup Instructions

### Option 1: Automatic Setup (Recommended)

The `DataInitializer` component will automatically create the service and all sub-services when you start the Spring Boot application.

**Steps:**
1. Start your Spring Boot backend:
   ```bash
   cd servicepage
   mvn spring-boot:run
   ```

2. The data will be automatically initialized on startup
3. No manual intervention needed!

**File:** `src/main/java/com/matrimony/servicepage/config/DataInitializer.java`

---

### Option 2: Manual SQL Setup

If you prefer to set up the data manually, run the SQL migration script:

**File:** `migrations/002_seed_photography_service.sql`

**Command:**
```bash
psql -U postgres -d servicepage -f migrations/002_seed_photography_service.sql
```

---

### Option 3: Quick SQL Insert

```sql
-- Insert Photography service
INSERT INTO services (name, status)
VALUES ('PHOTOGRAPHY', true)
ON CONFLICT (name) DO NOTHING;

-- Insert all sub-services
DO $$
DECLARE
    service_id BIGINT;
BEGIN
    SELECT id INTO service_id FROM services WHERE name = 'PHOTOGRAPHY';
    
    INSERT INTO sub_services (service_id, name, description, status) VALUES
    (service_id, 'WEDDING_PHOTOGRAPHY', 'Professional wedding photography services to capture your special day', true),
    (service_id, 'WEDDING_VIDEOGRAPHY', 'Capture your wedding moments in motion with professional videography', true),
    (service_id, 'CINEMATOGRAPHY', 'Cinematic wedding films that tell your love story', true),
    (service_id, 'DRONE_SHOOT', 'Aerial photography and videography using drone technology', true),
    (service_id, 'PRE_WEDDING_SHOOT', 'Pre-wedding photo sessions before your big day', true),
    (service_id, 'POST_WEDDING_SHOOT', 'Post-wedding photography sessions after the ceremony', true),
    (service_id, 'ALBUM_DESIGNING', 'Professional album design and layout services', true),
    (service_id, 'PHOTO_EDITING_RETOUCHING', 'Photo editing and retouching services for your wedding photos', true),
    (service_id, 'LIVE_WEDDING_STREAMING', 'Live streaming services for your wedding ceremony', true),
    (service_id, '360_VIDEO_CAPTURE', '360-degree video capture for immersive wedding experience', true)
    ON CONFLICT (service_id, name) DO NOTHING;
END $$;
```

---

## ✅ Verification

After setup, verify the data:

```sql
-- Check Photography service
SELECT * FROM services WHERE name = 'PHOTOGRAPHY';

-- Check all Photography sub-services
SELECT 
    ss.id,
    ss.name,
    ss.description,
    ss.status
FROM services s
JOIN sub_services ss ON s.id = ss.service_id
WHERE s.name = 'PHOTOGRAPHY'
ORDER BY ss.name;
```

**Expected:**
- 1 service: `PHOTOGRAPHY`
- 10 sub-services: All listed above

---

## 🎨 Frontend Display

The frontend will automatically display:

### STEP 1: Service Type Selection
- Shows "Photography & Media" card with 📸 icon
- Clicking navigates to role selection

### STEP 3: Sub-Services List
When user selects "Photography & Media" → Customer/Vendor → Sub-Services:

All 10 sub-services will be displayed as cards:
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

**Name Formatting:**
- Database: `WEDDING_PHOTOGRAPHY`
- Display: "Wedding Photography"
- Database: `360_VIDEO_CAPTURE`
- Display: "360° Video Capture"

The frontend automatically formats the names for display.

---

## 🔌 API Testing

### Test Service Types Endpoint
```bash
GET http://localhost:8080/api/services/types
```

**Expected Response:**
```json
{
  "success": true,
  "services": [
    {
      "id": 1,
      "name": "PHOTOGRAPHY",
      "status": true
    }
  ],
  "total": 1
}
```

### Test Sub-Services Endpoint
```bash
GET http://localhost:8080/api/services/PHOTOGRAPHY
```

**Expected Response:**
```json
{
  "success": true,
  "subServices": [
    {
      "id": 1,
      "name": "WEDDING_PHOTOGRAPHY",
      "description": "Professional wedding photography services...",
      "status": true
    },
    {
      "id": 2,
      "name": "WEDDING_VIDEOGRAPHY",
      "description": "Capture your wedding moments...",
      "status": true
    },
    ... (8 more)
  ],
  "total": 10
}
```

---

## 📋 Complete Flow Test

1. **Start Backend:** `mvn spring-boot:run`
2. **Start Frontend:** `npm run dev`
3. **Navigate to:** `http://localhost:3000/service-types`
4. **Click:** "Photography & Media" card
5. **Select:** Customer or Vendor
6. **Verify:** All 10 sub-services are displayed
7. **Click:** Any sub-service
8. **Fill:** Form (Customer Request or Vendor Application)
9. **Submit:** Verify data is saved correctly

---

## ✅ Status

- ✅ **DataInitializer Created** - Auto-seeds on startup
- ✅ **SQL Migration Script Created** - Manual setup option
- ✅ **Frontend Ready** - Displays all sub-services correctly
- ✅ **API Endpoints Ready** - Returns correct data
- ✅ **Name Formatting** - Frontend formats names properly

**The Photography & Media service with all 10 sub-services is now fully configured!**

