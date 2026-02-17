# Database Fix Instructions - sub_service_id NULL Constraint Error

## Error Message
```
null value in column "sub_service_id" of relation "vendor_applications" violates not-null constraint
```

## Problem
The database schema still has a NOT NULL constraint on `sub_service_id`, but the application code now allows NULL values (since we removed the requirement for sub-service ID).

## Solution

### Quick Fix: Run SQL Migration

**Option 1: Using psql (PostgreSQL command line)**
```bash
psql -U postgres -d servicepage -f migrations/001_make_sub_service_id_nullable.sql
```

**Option 2: Using pgAdmin or any PostgreSQL client**
1. Connect to your database
2. Open SQL query window
3. Run the following SQL:

```sql
-- Make sub_service_id nullable
ALTER TABLE vendor_applications 
ALTER COLUMN sub_service_id DROP NOT NULL;

-- Add profile_photo_url column if it doesn't exist
ALTER TABLE vendor_applications 
ADD COLUMN IF NOT EXISTS profile_photo_url VARCHAR(500);
```

**Option 3: Using Spring Boot with Flyway/Liquibase (if configured)**
The migration file is located at: `servicepage/migrations/001_make_sub_service_id_nullable.sql`

### Verify the Fix

After running the migration, verify the changes:

```sql
SELECT 
    column_name, 
    is_nullable, 
    data_type 
FROM information_schema.columns 
WHERE table_name = 'vendor_applications' 
AND column_name IN ('sub_service_id', 'profile_photo_url');
```

Expected results:
- `sub_service_id`: `is_nullable = YES`
- `profile_photo_url`: Column exists with `VARCHAR(500)`

## Why This Happened

1. We changed the Java entity to make `subService` nullable (`nullable = true`)
2. We removed the `@NotNull` validation from the DTO
3. However, Hibernate's `ddl-auto=update` doesn't always remove NOT NULL constraints from existing columns
4. The database schema still had the old constraint

## After Running Migration

1. **Restart your Spring Boot application** (if it's running)
2. **Try submitting a aVendor application again** - it should work now
3. The application will accept aVendor applications with or without sub-service ID

## Notes

- This migration is **safe** - it only removes a constraint, it doesn't delete any data
- Existing records with `sub_service_id` values will remain unchanged
- New records can have `NULL` for `sub_service_id`

