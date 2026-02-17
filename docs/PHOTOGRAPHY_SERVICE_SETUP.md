# Photography & Media Service Setup

## Service Structure

### Service Type: **Photography & Media**
**Database Name:** `PHOTOGRAPHY`

### Sub-Services (10 Total):

1. **Wedding Photography** (`WEDDING_PHOTOGRAPHY`)
   - Description: Professional wedding photography services to capture your special day

2. **Wedding Videography** (`WEDDING_VIDEOGRAPHY`)
   - Description: Capture your wedding moments in motion with professional videography

3. **Cinematography** (`CINEMATOGRAPHY`)
   - Description: Cinematic wedding films that tell your love story

4. **Drone Shoot** (`DRONE_SHOOT`)
   - Description: Aerial photography and videography using drone technology

5. **Pre-Wedding Shoot** (`PRE_WEDDING_SHOOT`)
   - Description: Pre-wedding photo sessions before your big day

6. **Post-Wedding Shoot** (`POST_WEDDING_SHOOT`)
   - Description: Post-wedding photography sessions after the ceremony

7. **Album Designing** (`ALBUM_DESIGNING`)
   - Description: Professional album design and layout services

8. **Photo Editing / Retouching** (`PHOTO_EDITING_RETOUCHING`)
   - Description: Photo editing and retouching services for your wedding photos

9. **Live Wedding Streaming** (`LIVE_WEDDING_STREAMING`)
   - Description: Live streaming services for your wedding ceremony

10. **360° Video Capture** (`360_VIDEO_CAPTURE`)
    - Description: 360-degree video capture for immersive wedding experience

---

## Setup Methods

### Method 1: Automatic (Recommended)
The `DataInitializer` component will automatically create the service and sub-services when the application starts.

**File:** `src/main/java/com/matrimony/servicepage/config/DataInitializer.java`

**What it does:**
- Checks if `PHOTOGRAPHY` service exists
- Creates it if it doesn't exist
- Checks each sub-service
- Creates missing sub-services

**To use:**
1. Start your Spring Boot application
2. The data will be automatically initialized

---

### Method 2: Manual SQL Script
Run the SQL migration script to manually insert the data.

**File:** `migrations/002_seed_photography_service.sql`

**To run:**
```bash
psql -U postgres -d servicepage -f migrations/002_seed_photography_service.sql
```

**Or using pgAdmin:**
1. Connect to your database
2. Open SQL query window
3. Copy and paste the SQL from the migration file
4. Execute

---

### Method 3: Direct SQL (Quick Setup)
```sql
-- Insert Photography service
INSERT INTO services (name, status)
VALUES ('PHOTOGRAPHY', true)
ON CONFLICT (name) DO NOTHING;

-- Get Photography service ID
DO $$
DECLARE
    service_id BIGINT;
BEGIN
    SELECT id INTO service_id FROM services WHERE name = 'PHOTOGRAPHY';
    
    -- Insert all sub-services
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

## Verification

After setup, verify the data:

```sql
-- Check service
SELECT * FROM services WHERE name = 'PHOTOGRAPHY';

-- Check all sub-services
SELECT 
    s.name as service_name,
    ss.id,
    ss.name as sub_service_name,
    ss.description,
    ss.status
FROM services s
JOIN sub_services ss ON s.id = ss.service_id
WHERE s.name = 'PHOTOGRAPHY'
ORDER BY ss.name;
```

**Expected Result:**
- 1 service: `PHOTOGRAPHY`
- 10 sub-services: All listed above

---

## Frontend Display

The frontend will automatically:
1. Display "Photography & Media" in STEP 1 (Service Type Selection)
2. Show all 10 sub-services in STEP 3 (Sub-Services List)
3. Format names properly (e.g., `WEDDING_PHOTOGRAPHY` → "Wedding Photography")

---

## API Endpoints

### Get Service Types
```
GET /api/services/types
```
Returns: `PHOTOGRAPHY` service

### Get Sub-Services
```
GET /api/services/PHOTOGRAPHY
```
Returns: All 10 sub-services listed above

---

## Status

✅ **Data Initializer Created** - Automatically seeds data on startup
✅ **SQL Migration Script Created** - Manual setup option available
✅ **Frontend Ready** - Will display all sub-services correctly

**Next Step:** Start your Spring Boot application and the data will be automatically initialized!

