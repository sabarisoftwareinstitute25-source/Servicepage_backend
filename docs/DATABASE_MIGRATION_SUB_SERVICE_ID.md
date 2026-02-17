# Database Migration: Make sub_service_id Nullable

## Problem
The database still has a NOT NULL constraint on `sub_service_id` column, but the application now allows NULL values. This causes errors when submitting aVendor applications without a sub-service ID.

## Error Message
```
null value in column "sub_service_id" of relation "vendor_applications" violates not-null constraint
```

## Solution

### Option 1: Manual SQL Migration (Recommended for Production)

Run this SQL command in your PostgreSQL database:

```sql
-- Make sub_service_id nullable
ALTER TABLE vendor_applications 
ALTER COLUMN sub_service_id DROP NOT NULL;
```

### Option 2: Let Hibernate Update (Development)

If you're using `ddl-auto=update` (which is already configured), Hibernate should automatically update the schema when you restart the application. However, if the constraint still exists, you may need to:

1. **Restart the Spring Boot application** - Hibernate will detect the change and update the schema
2. **Or manually run the SQL** if Hibernate doesn't update it automatically

### Option 3: Drop and Recreate (Development Only - Data Loss Warning)

⚠️ **WARNING: This will delete all data in the vendor_applications table!**

```sql
-- Drop the table (WARNING: Deletes all data!)
DROP TABLE IF EXISTS vendor_applications CASCADE;

-- Restart the application - Hibernate will recreate the table with correct schema
```

## Verification

After running the migration, verify the change:

```sql
-- Check column constraints
SELECT 
    column_name, 
    is_nullable, 
    data_type 
FROM information_schema.columns 
WHERE table_name = 'vendor_applications' 
AND column_name = 'sub_service_id';
```

Expected result:
- `is_nullable` should be `YES`

## Additional Column: profile_photo_url

The `profile_photo_url` column should also be added automatically by Hibernate. If not, run:

```sql
-- Add profile_photo_url column if it doesn't exist
ALTER TABLE vendor_applications 
ADD COLUMN IF NOT EXISTS profile_photo_url VARCHAR(500);
```

## Complete Migration Script

```sql
-- Make sub_service_id nullable
ALTER TABLE vendor_applications 
ALTER COLUMN sub_service_id DROP NOT NULL;

-- Add profile_photo_url column if it doesn't exist
ALTER TABLE vendor_applications 
ADD COLUMN IF NOT EXISTS profile_photo_url VARCHAR(500);

-- Verify changes
SELECT 
    column_name, 
    is_nullable, 
    data_type 
FROM information_schema.columns 
WHERE table_name = 'vendor_applications' 
AND column_name IN ('sub_service_id', 'profile_photo_url');
```

## After Migration

1. Restart your Spring Boot application
2. Try submitting a aVendor application without sub-service ID
3. The error should be resolved

