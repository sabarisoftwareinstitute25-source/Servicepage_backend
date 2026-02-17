# Photography & Media Sub-Services Setup

## Overview
This document ensures that "Photography & Media" service type has all the required sub-services properly configured.

---

## Required Sub-Services for Photography & Media

When users select **"Photography & Media"** service type, they should see these 10 sub-services:

1. **Wedding Photography**
2. **Wedding Videography**
3. **Cinematography**
4. **Drone Shoot**
5. **Pre-Wedding Shoot**
6. **Post-Wedding Shoot**
7. **Album Designing**
8. **Photo Editing / Retouching**
9. **Live Wedding Streaming**
10. **360° Video Capture**

---

## Database Setup

### Option 1: Run SQL Migration (Recommended)

Run the SQL script: `servicepage/migrations/002_seed_photography_sub_services.sql`

```bash
psql -U postgres -d servicepage -f servicepage/migrations/002_seed_photography_sub_services.sql
```

### Option 2: Manual SQL

```sql
-- Ensure PHOTOGRAPHY service exists
INSERT INTO services (name, status)
VALUES ('PHOTOGRAPHY', true)
ON CONFLICT (name) DO UPDATE SET status = true;

-- Insert all Photography sub-services
-- (See migration file for complete SQL)
```

### Option 3: Automatic Initialization (Java)

The `DataInitializer.java` component will automatically create/update these sub-services when the application starts.

---

## Database Schema

### Service Type
- **Table:** `services`
- **Name:** `PHOTOGRAPHY`
- **Status:** `true`

### Sub-Services
- **Table:** `sub_services`
- **service_id:** Links to PHOTOGRAPHY service
- **name:** Enum format (e.g., `WEDDING_PHOTOGRAPHY`)
- **description:** Human-readable description
- **status:** `true`

---

## Sub-Service Name Mapping

| Display Name | Database Name | Description |
|--------------|---------------|-------------|
| Wedding Photography | `WEDDING_PHOTOGRAPHY` | Professional wedding photography services |
| Wedding Videography | `WEDDING_VIDEOGRAPHY` | Capture wedding moments in motion |
| Cinematography | `CINEMATOGRAPHY` | Cinematic wedding films |
| Drone Shoot | `DRONE_SHOOT` | Aerial photography and videography |
| Pre-Wedding Shoot | `PRE_WEDDING_SHOOT` | Pre-wedding photo sessions |
| Post-Wedding Shoot | `POST_WEDDING_SHOOT` | Post-wedding photo sessions |
| Album Designing | `ALBUM_DESIGNING` | Wedding album design services |
| Photo Editing / Retouching | `PHOTO_EDITING_RETOUCHING` | Photo editing and retouching |
| Live Wedding Streaming | `LIVE_WEDDING_STREAMING` | Live streaming for remote guests |
| 360° Video Capture | `360_VIDEO_CAPTURE` | 360-degree immersive video |

---

## Frontend Display

The frontend component `SubServicesList.jsx` includes a `formatSubServiceName()` function that:
- Maps database names to display names
- Handles special cases like "Photo Editing / Retouching"
- Formats names with proper capitalization
- Handles special characters like "360°"

---

## Verification

### Check Database
```sql
SELECT 
    s.name as service_type,
    ss.name as sub_service_name,
    ss.description,
    ss.status
FROM sub_services ss
JOIN services s ON ss.service_id = s.id
WHERE s.name = 'PHOTOGRAPHY'
ORDER BY ss.name;
```

Expected: 10 sub-services with status = true

### Check Frontend
1. Navigate to `/service-types`
2. Click "Photography & Media"
3. Select role (Customer/Vendor)
4. Verify all 10 sub-services are displayed correctly

---

## Status: ✅ Complete

- ✅ SQL migration script created
- ✅ DataInitializer component created
- ✅ Frontend name formatting updated
- ✅ All 10 sub-services configured

