# Catering & Food Service Setup

## Service Structure

### Service Type: **Catering & Food**
**Database Name:** `CATERING`

### Sub-Services (10 Total):

1. **Catering Services** (`CATERING_SERVICES`)
   - Description: Complete catering services for your wedding

2. **Vegetarian Catering** (`VEGETARIAN_CATERING`)
   - Description: Vegetarian catering options for your special day

3. **Non-Vegetarian Catering** (`NON_VEGETARIAN_CATERING`)
   - Description: Non-vegetarian catering services with variety of dishes

4. **Traditional Catering (South / North Indian)** (`TRADITIONAL_CATERING`)
   - Description: Traditional South Indian and North Indian cuisine

5. **Buffet Catering** (`BUFFET_CATERING`)
   - Description: Buffet-style catering for large gatherings

6. **Banana Leaf Catering** (`BANANA_LEAF_CATERING`)
   - Description: Traditional banana leaf serving style catering

7. **Live Food Counters** (`LIVE_FOOD_COUNTERS`)
   - Description: Live food counters and interactive cooking stations

8. **Sweet & Snack Vendors** (`SWEET_SNACK_VENDORS`)
   - Description: Sweet and snack vendors for your wedding

9. **Bakery / Wedding Cakes** (`BAKERY_WEDDING_CAKES`)
   - Description: Bakery services and custom wedding cakes

10. **Beverage Services** (`BEVERAGE_SERVICES`)
    - Description: Beverage services including drinks and refreshments

---

## Setup Methods

### Method 1: Automatic (Recommended)
The `DataInitializer` component will automatically create the service and sub-services when the application starts.

**File:** `src/main/java/com/matrimony/servicepage/config/DataInitializer.java`

**What it does:**
- Checks if `CATERING` service exists
- Creates it if it doesn't exist
- Checks each sub-service
- Creates missing sub-services

**To use:**
1. Start your Spring Boot application
2. The data will be automatically initialized

---

### Method 2: Manual SQL Migration
Run the SQL migration script to manually insert the data.

**File:** `migrations/003_seed_catering_service.sql`

**To run:**
```bash
psql -U postgres -d servicepage -f migrations/003_seed_catering_service.sql
```

---

### Method 3: Direct SQL (Quick Setup)
```sql
-- Insert Catering service
INSERT INTO services (name, status)
VALUES ('CATERING', true)
ON CONFLICT (name) DO NOTHING;

-- Insert all sub-services
DO $$
DECLARE
    service_id BIGINT;
BEGIN
    SELECT id INTO service_id FROM services WHERE name = 'CATERING';
    
    INSERT INTO sub_services (service_id, name, description, status) VALUES
    (service_id, 'CATERING_SERVICES', 'Complete catering services for your wedding', true),
    (service_id, 'VEGETARIAN_CATERING', 'Vegetarian catering options for your special day', true),
    (service_id, 'NON_VEGETARIAN_CATERING', 'Non-vegetarian catering services with variety of dishes', true),
    (service_id, 'TRADITIONAL_CATERING', 'Traditional South Indian and North Indian cuisine', true),
    (service_id, 'BUFFET_CATERING', 'Buffet-style catering for large gatherings', true),
    (service_id, 'BANANA_LEAF_CATERING', 'Traditional banana leaf serving style catering', true),
    (service_id, 'LIVE_FOOD_COUNTERS', 'Live food counters and interactive cooking stations', true),
    (service_id, 'SWEET_SNACK_VENDORS', 'Sweet and snack vendors for your wedding', true),
    (service_id, 'BAKERY_WEDDING_CAKES', 'Bakery services and custom wedding cakes', true),
    (service_id, 'BEVERAGE_SERVICES', 'Beverage services including drinks and refreshments', true)
    ON CONFLICT (service_id, name) DO NOTHING;
END $$;
```

---

## Verification

After setup, verify the data:

```sql
-- Check Catering service
SELECT * FROM services WHERE name = 'CATERING';

-- Check all Catering sub-services
SELECT 
    s.name as service_name,
    ss.id,
    ss.name as sub_service_name,
    ss.description,
    ss.status
FROM services s
JOIN sub_services ss ON s.id = ss.service_id
WHERE s.name = 'CATERING'
ORDER BY ss.name;
```

**Expected Result:**
- 1 service: `CATERING`
- 10 sub-services: All listed above

---

## Frontend Display

The frontend will automatically:
1. Display "Catering & Food" in STEP 1 (Service Type Selection) with 🍽️ icon
2. Show all 10 sub-services in STEP 3 (Sub-Services List)
3. Format names properly (e.g., `VEGETARIAN_CATERING` → "Vegetarian Catering")

---

## API Endpoints

### Get Service Types
```
GET /api/services/types
```
Returns: `CATERING` service (along with `PHOTOGRAPHY`)

### Get Sub-Services
```
GET /api/services/CATERING
```
Returns: All 10 sub-services listed above

---

## Status

✅ **DataInitializer Updated** - Now includes Catering service initialization
✅ **SQL Migration Script Created** - Manual setup option available
✅ **Frontend Ready** - Will display all sub-services correctly

**Next Step:** Start your Spring Boot application and both Photography & Catering services will be automatically initialized!

