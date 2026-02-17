# Frontend Options Guide

You have **TWO frontend options** available:

## 📄 Option 1: HTML/CSS/JavaScript Frontend (Static)

**Location:** `src/main/resources/static/`

### Files:
- `index.html` - Home page
- `services.html` - Services listing
- `aVendor-application.html` - Vendor application form
- `css/style.css` - All styling
- `js/app.js` - Common utilities
- `js/services.js` - Services functionality
- `js/aVendor-application.js` - Form handling

### How to Access:
1. Start Spring Boot backend:
   ```bash
   cd servicepage
   mvn spring-boot:run
   ```

2. Open browser:
   - `http://localhost:8080/index.html`
   - `http://localhost:8080/services.html`
   - `http://localhost:8080/aVendor-application.html`

### Features:
✅ Simple HTML/CSS/JavaScript  
✅ No build process needed  
✅ Served directly by Spring Boot  
✅ Works immediately after backend starts  

---

## ⚛️ Option 2: React.js Frontend (Modern SPA)

**Location:** `Servicepage_frontend/`

### Files Structure:
```
Servicepage_frontend/
├── src/
│   ├── components/     # React components
│   ├── pages/          # Page components
│   ├── services/       # API service layer
│   └── App.jsx         # Main app
├── package.json
└── vite.config.js
```

### How to Run:
1. Start Spring Boot backend (Terminal 1):
   ```bash
   cd servicepage
   mvn spring-boot:run
   ```

2. Start React frontend (Terminal 2):
   ```bash
   cd Servicepage_frontend
   npm install  # First time only
   npm run dev
   ```

3. Open browser:
   - `http://localhost:3000`

### Features:
✅ Modern React.js with hooks  
✅ Component-based architecture  
✅ React Router for navigation  
✅ Vite for fast development  
✅ Hot module replacement  
✅ Better state management  

---

## 🎯 Which One to Use?

### Use HTML/CSS/JS if:
- You want simplicity
- No build process needed
- Quick prototyping
- Learning web fundamentals

### Use React.js if:
- You want modern development
- Component reusability
- Better state management
- Scalable application
- Professional development

## 📝 Both Are Available!

You can use **both** frontends:
- **HTML version:** Access via Spring Boot at `http://localhost:8080`
- **React version:** Access via Vite at `http://localhost:3000`

Both connect to the same backend API at `http://localhost:8080/api`

## 🔄 Switching Between Them

- **HTML Frontend:** Just start backend, no frontend server needed
- **React Frontend:** Start both backend and frontend servers

Both frontends are ready to use! 🎉

