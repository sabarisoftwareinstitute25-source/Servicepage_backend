# Request Parameter Name Fix

## Issue
```
java.lang.IllegalArgumentException: Name for argument of type [java.lang.String] not specified, 
and parameter name information not found in class file either.
```

## Root Cause
Spring Framework requires explicit parameter names for `@RequestParam` annotations when Java bytecode doesn't include parameter name information. This happens when:
- Code is compiled without debug information
- Using certain compiler settings
- Parameter names are stripped during compilation

## Solution
Added explicit `value` attribute to all `@RequestParam` annotations that were missing it.

## Fixed Locations

### VendorController.java

1. **getAllVendors method** (line 113-114):
   ```java
   // Before:
   @RequestParam(required = false) Vendor.VendorStatus status
   @RequestParam(required = false) String city
   
   // After:
   @RequestParam(value = "status", required = false) Vendor.VendorStatus status
   @RequestParam(value = "city", required = false) String city
   ```

2. **updateVendorStatus method** (line 177):
   ```java
   // Before:
   @RequestParam Vendor.VendorStatus status
   
   // After:
   @RequestParam(value = "status") Vendor.VendorStatus status
   ```

3. **getPublicVendors method** (line 262):
   ```java
   // Before:
   @RequestParam(required = false) String city
   
   // After:
   @RequestParam(value = "city", required = false) String city
   ```

### VendorApplicationController.java

1. **getAllApplications method** (line 201):
   ```java
   // Before:
   @RequestParam(required = false) com.matrimony.servicepage.entity.VendorApplication.ApplicationStatus status
   
   // After:
   @RequestParam(value = "status", required = false) com.matrimony.servicepage.entity.VendorApplication.ApplicationStatus status
   ```

## Verification
- ✅ Compilation successful
- ✅ All @RequestParam annotations now have explicit names
- ✅ No linter errors

## Best Practice
Always specify the `value` or `name` attribute in `@RequestParam` annotations:
```java
@RequestParam(value = "parameterName", required = false) String parameterName
```

This ensures compatibility regardless of compiler settings or debug information availability.

