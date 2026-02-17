# Database Fix Guide for Vendor Forms

## Issue
Vendor forms may not be saving to the database due to schema changes (ID changed from Long to String).

## Solution

### Option 1: Auto-Update Schema (Recommended for Development)
The application is configured to automatically update the database schema. If you're still having issues:

1. **Stop the backend application**
2. **Drop and recreate the database** (if you don't have important data):
   ```sql
   DROP DATABASE servicepage;
   CREATE DATABASE servicepage;
   ```
3. **Restart the backend application** - Hibernate will automatically create the correct schema

### Option 2: Manual Schema Update (If you have existing data)

If you have existing aVendor data that you want to keep, you'll need to migrate:

1. **Backup your database first!**
2. **Update the vendors table**:
   ```sql
   -- Add a temporary column
   ALTER TABLE vendors ADD COLUMN id_new VARCHAR(20);
   
   -- Generate new IDs for existing records
   UPDATE vendors 
   SET id_new = 'EIS' || EXTRACT(YEAR FROM created_at) || 'V' || 
                LPAD(EXTRACT(MONTH FROM created_at)::TEXT, 2, '0') || 
                LPAD(ROW_NUMBER() OVER (ORDER BY created_at)::TEXT, 4, '0');
   
   -- Update foreign keys in child tables (if needed)
   -- For each child table (photography_vendors, catering_vendors, etc.):
   ALTER TABLE photography_vendors ADD COLUMN vendor_id_new VARCHAR(20);
   UPDATE photography_vendors pv
   SET vendor_id_new = v.id_new
   FROM vendors v
   WHERE pv.vendor_id = v.id::TEXT;
   
   -- Drop old foreign keys
   ALTER TABLE photography_vendors DROP CONSTRAINT IF EXISTS photography_vendors_vendor_id_fkey;
   -- Repeat for other child tables
   
   -- Drop old ID column and rename new one
   ALTER TABLE vendors DROP CONSTRAINT vendors_pkey;
   ALTER TABLE vendors DROP COLUMN id;
   ALTER TABLE vendors RENAME COLUMN id_new TO id;
   ALTER TABLE vendors ADD PRIMARY KEY (id);
   ALTER TABLE vendors ALTER COLUMN id SET NOT NULL;
   
   -- Update child tables
   ALTER TABLE photography_vendors DROP COLUMN vendor_id;
   ALTER TABLE photography_vendors RENAME COLUMN vendor_id_new TO vendor_id;
   ALTER TABLE photography_vendors ALTER COLUMN vendor_id SET NOT NULL;
   ALTER TABLE photography_vendors ADD CONSTRAINT photography_vendors_vendor_id_fkey 
       FOREIGN KEY (vendor_id) REFERENCES vendors(id);
   -- Repeat for other child tables
   ```

### Option 3: Fresh Start (Easiest - Development Only)

If you're in development and don't need existing data:

1. **Stop the backend**
2. **Delete the database**:
   ```sql
   DROP DATABASE servicepage;
   CREATE DATABASE servicepage;
   ```
3. **Change `application.properties`** temporarily to:
   ```properties
   spring.jpa.hibernate.ddl-auto=create-drop
   ```
4. **Start the backend** - it will create fresh tables
5. **Change back to**:
   ```properties
   spring.jpa.hibernate.ddl-auto=update
   ```

## Verification

After fixing, test by:
1. Submitting a aVendor form from the frontend
2. Check the database:
   ```sql
   SELECT id, vendor_name, email, service_type, created_at 
   FROM vendors 
   ORDER BY created_at DESC 
   LIMIT 5;
   ```
3. The `id` should be in format: `EIS2026V020001`, `EIS2026V020002`, etc.

## Common Issues

### Issue: "Cannot compare left expression of type 'java.lang.String' with right expression of type 'java.lang.Long'"
**Solution**: The database schema still has Long ID. Use Option 1 or 2 above.

### Issue: "Duplicate key value violates unique constraint"
**Solution**: The aVendor ID generation had a race condition (now fixed). Try submitting again.

### Issue: "Column 'id' cannot be null"
**Solution**: The ID generation failed. Check database connectivity and ensure `created_at` column exists.

## Current Configuration

- **ID Format**: `EIS{YYYY}V{MM}{NNNN}` (e.g., EIS2026V020001)
- **ID Type**: VARCHAR(20)
- **Auto-generation**: Yes, based on year/month and sequence number
- **Thread-safe**: Yes, with synchronized method and duplicate checking

