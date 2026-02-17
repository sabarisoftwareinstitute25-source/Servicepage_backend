# Complete Frontend Guide - HTML/CSS/JS + React.js

## ✅ You Have TWO Frontend Options!

Both frontends are available and connected to your Spring Boot backend.

---

## 📄 Option 1: HTML/CSS/JavaScript Frontend

### 📁 Location
`src/main/resources/static/`

### 📂 Files Structure
```
static/
├── index.html                    # Home page
├── services.html                 # Services listing
├── aVendor-application.html      # Vendor application form
├── css/
│   └── style.css                # All styling
└── js/
    ├── app.js                   # Common utilities & API config
    ├── services.js              # Services functionality
    └── aVendor-application.js    # Form handling
```

### 🚀 How to Run

**Step 1:** Start Spring Boot backend
```bash
cd servicepage
mvn spring-boot:run
```

**Step 2:** Open browser
- Home: `http://localhost:8080/index.html`
- Services: `http://localhost:8080/services.html`
- Vendor App: `http://localhost:8080/aVendor-application.html`

### ✨ Features
- ✅ Pure HTML/CSS/JavaScript
- ✅ No build process needed
- ✅ Served directly by Spring Boot
- ✅ Works immediately
- ✅ Simple and lightweight

---

## ⚛️ Option 2: React.js Frontend (SPA)

### 📁 Location
`Servicepage_frontend/`

### 📂 Files Structure
```
Servicepage_frontend/
├── src/
│   ├── components/              # Navbar, Footer, ConnectionStatus
│   ├── pages/                   # Home, Services, VendorApplication
│   ├── services/                # API service layer
│   ├── utils/                   # Utilities
│   ├── App.jsx                  # Main app component
│   └── main.jsx                 # Entry point
├── index.html
├── package.json
└── vite.config.js
```

### 🚀 How to Run

**Step 1:** Start Spring Boot backend (Terminal 1)
```bash
cd servicepage
mvn spring-boot:run
```

**Step 2:** Start React frontend (Terminal 2)
```bash
cd Servicepage_frontend
npm install  # First time only
npm run dev
```

**Step 3:** Open browser
- `http://localhost:3000`

### ✨ Features
- ✅ Modern React.js with hooks
- ✅ Component-based architecture
- ✅ React Router for navigation
- ✅ Vite for fast development
- ✅ Hot module replacement
- ✅ Better state management
- ✅ Connection status indicator

---

## 🔌 API Connection

### HTML/CSS/JS Frontend
- **API URL:** `http://localhost:8080/api` (configured in `js/app.js`)
- **Connection:** Direct API calls from browser
- **CORS:** Configured in backend to allow requests

### React.js Frontend
- **API URL:** Uses Vite proxy (`/api` → `http://localhost:8080/api`)
- **Connection:** Proxied through Vite dev server
- **CORS:** Configured in backend

---

## 📊 Comparison

| Feature | HTML/CSS/JS | React.js |
|---------|-------------|----------|
| **Setup** | No build needed | npm install + npm run dev |
| **Port** | 8080 (same as backend) | 3000 (separate) |
| **Build** | None | Vite build |
| **Hot Reload** | Manual refresh | Automatic |
| **Complexity** | Simple | Moderate |
| **Best For** | Quick prototypes | Production apps |

---

## 🎯 Usage Recommendations

### Use HTML/CSS/JS When:
- Quick testing/prototyping
- Simple static pages
- Learning web fundamentals
- No build process needed

### Use React.js When:
- Building production application
- Need component reusability
- Complex state management
- Modern development workflow
- Team collaboration

---

## 📝 Both Frontends Include:

### ✅ Pages
- Home page
- Services listing page
- Vendor application form

### ✅ API Integration
- Services API
- Vendor Application API
- Vendor Profile API (React only)

### ✅ Features
- Form validation
- Error handling
- Success messages
- Responsive design

---

## 🚀 Quick Start Commands

### HTML Frontend (Simplest)
```bash
# Terminal 1
cd servicepage
mvn spring-boot:run
# Then open http://localhost:8080/index.html
```

### React Frontend (Modern)
```bash
# Terminal 1 - Backend
cd servicepage
mvn spring-boot:run

# Terminal 2 - Frontend
cd Servicepage_frontend
npm run dev
# Then open http://localhost:3000
```

---

## 📚 File Locations Summary

### HTML/CSS/JS Files:
- `src/main/resources/static/index.html`
- `src/main/resources/static/services.html`
- `src/main/resources/static/aVendor-application.html`
- `src/main/resources/static/css/style.css`
- `src/main/resources/static/js/app.js`
- `src/main/resources/static/js/services.js`
- `src/main/resources/static/js/aVendor-application.js`

### React.js Files:
- `Servicepage_frontend/src/pages/Home.jsx`
- `Servicepage_frontend/src/pages/Services.jsx`
- `Servicepage_frontend/src/pages/VendorApplication.jsx`
- `Servicepage_frontend/src/components/Navbar.jsx`
- `Servicepage_frontend/src/components/Footer.jsx`
- `Servicepage_frontend/src/services/api.js`

---

## ✅ Both Are Ready!

You can use **either** or **both** frontends:
- **HTML version:** Access at `http://localhost:8080` (when backend is running)
- **React version:** Access at `http://localhost:3000` (when both servers are running)

Both connect to the same backend API! 🎉

