# 🔧 Fix Auth0 Callback URL Mismatch

## Problem
You're getting a "Callback URL mismatch" error because your Auth0 application settings don't include the correct callback URLs.

## ✅ Solution

### Step 1: Go to Auth0 Dashboard
1. Open https://manage.auth0.com/
2. Go to **Applications** → **Applications**
3. Click on your **DSA Practice App** application

### Step 2: Update Application Settings
Scroll down to **Application URIs** and update these fields:

#### **Allowed Callback URLs** (copy and paste this exactly):
```
http://localhost:5173/, http://localhost:5174/, https://merajmunshiofficial.github.io/dsamentor/
```

#### **Allowed Logout URLs** (copy and paste this exactly):
```
http://localhost:5173/, http://localhost:5174/, https://merajmunshiofficial.github.io/dsamentor/
```

#### **Allowed Web Origins** (copy and paste this exactly):
```
http://localhost:5173, http://localhost:5174, https://merajmunshiofficial.github.io/dsamentor
```

### Step 3: Save Changes
Click **Save Changes** at the bottom of the page.

### Step 4: Test Again
1. Go back to your app: http://localhost:5173/
2. Click "Sign In with Auth0"
3. It should work now! 🎉

## 📝 What I Fixed

1. **Vite Config**: Updated to use different base paths for development vs production
2. **Auth0 Config**: Updated to use the correct redirect URI for development
3. **Development URL**: Now uses `http://localhost:5173/` instead of `http://localhost:5173/your-repo-name/`

## 🎯 Current URLs

- **Development**: http://localhost:5174/ (or http://localhost:5173/)
- **Production**: https://merajmunshiofficial.github.io/dsamentor/

Both are now configured to work with your Auth0 application!

## 🚀 After This Fix

Your app will work seamlessly in both:
- ✅ **Local development** (localhost:5173)
- ✅ **Production deployment** (GitHub Pages)

The Auth0 configuration will automatically detect the environment and use the correct callback URLs.

---

**Try logging in again - it should work now! 🎉**
