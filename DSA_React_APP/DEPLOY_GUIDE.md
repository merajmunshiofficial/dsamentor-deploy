# 🚀 Deploy DSA Mentor to GitHub Pages

## Your Repository Details
- **Repository**: https://github.com/merajmunshiofficial/dsamentor.git
- **GitHub Pages URL**: https://merajmunshiofficial.github.io/dsamentor/
- **Local Development**: http://localhost:5173/

## 📋 Pre-Deployment Checklist

### ✅ Auth0 Configuration
Make sure your Auth0 application settings include:

**Allowed Callback URLs:**
```
http://localhost:5173/, https://merajmunshiofficial.github.io/dsamentor/
```

**Allowed Logout URLs:**
```
http://localhost:5173/, https://merajmunshiofficial.github.io/dsamentor/
```

**Allowed Web Origins:**
```
http://localhost:5173, https://merajmunshiofficial.github.io/dsamentor
```

## 🚀 Deployment Steps

### Step 1: Build and Test Locally
```bash
# Build the app
npm run build

# Preview the production build
npm run preview
```

### Step 2: Deploy to GitHub Pages
```bash
# Deploy using gh-pages
npm run deploy
```

### Step 3: Enable GitHub Pages
1. Go to your repository: https://github.com/merajmunshiofficial/dsamentor
2. Click on **Settings** tab
3. Scroll down to **Pages** section
4. Under **Source**, select **Deploy from a branch**
5. Choose **gh-pages** branch
6. Choose **/ (root)** folder
7. Click **Save**

### Step 4: Access Your App
After deployment (may take a few minutes):
- **Your Live App**: https://merajmunshiofficial.github.io/dsamentor/

## 🔧 Repository Setup (if needed)

If you haven't connected your local project to the repository yet:

```bash
# Initialize git (if not already done)
git init

# Add the remote repository
git remote add origin https://github.com/merajmunshiofficial/dsamentor.git

# Add all files
git add .

# Commit changes
git commit -m "Initial commit with Auth0 authentication"

# Push to main branch
git push -u origin main

# Deploy to GitHub Pages
npm run deploy
```

## 🔒 Security Notes

### Environment Variables
Your `.env` file contains:
```
VITE_AUTH0_DOMAIN=merajmunshi.us.auth0.com
VITE_AUTH0_CLIENT_ID=wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd
```

**Important**: 
- ✅ `.env` is in `.gitignore` (secure)
- ✅ These variables are safe to use in client-side apps
- ✅ No sensitive data is exposed

### GitHub Pages Deployment
- Your app will be publicly accessible at the GitHub Pages URL
- Only authenticated users (via Auth0) can access the actual content
- The Auth0 authentication protects your DSA practice interface

## 📱 User Experience

1. **User visits**: https://merajmunshiofficial.github.io/dsamentor/
2. **Sees login screen**: Professional Auth0 login interface
3. **Authenticates**: Via Auth0 (secure)
4. **Accesses app**: Your DSA practice interface

## 🎯 Testing

### Local Testing:
```bash
npm run dev
# Visit: http://localhost:5173/
```

### Production Testing:
```bash
npm run build
npm run preview
# Visit: http://localhost:4173/dsamentor/
```

## 🆘 Troubleshooting

### Common Issues:
1. **404 Error**: Check if GitHub Pages is enabled and gh-pages branch exists
2. **Auth0 Error**: Verify callback URLs in Auth0 dashboard
3. **Build Error**: Run `npm run build` locally to check for errors

### Support:
- Repository: https://github.com/merajmunshiofficial/dsamentor
- Auth0 Dashboard: https://manage.auth0.com/
- GitHub Pages: https://docs.github.com/en/pages

---

**Your DSA Mentor app is ready to deploy! 🎉**

Run `npm run deploy` to deploy your app to GitHub Pages!
