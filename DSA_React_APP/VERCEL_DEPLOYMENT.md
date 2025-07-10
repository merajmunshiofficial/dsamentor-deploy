# 🚀 Deploy to Vercel (Alternative to GitHub Pages)

## Why Vercel?
- ✅ **Works with private repositories**
- ✅ **Free tier available**
- ✅ **Automatic deployments**
- ✅ **Optimized for React/Vite**
- ✅ **Fast global CDN**

## 🔧 Setup Steps

### 1. **Create Vercel Account**
1. Go to https://vercel.com
2. Sign up with your GitHub account
3. Authorize Vercel to access your repositories

### 2. **Deploy Your App**
1. Click **New Project**
2. Import your repository: `merajmunshiofficial/dsamentor`
3. Configure project:
   - **Framework Preset**: Vite
   - **Build Command**: `npm run build`
   - **Output Directory**: `dist`
   - **Install Command**: `npm install`

### 3. **Add Environment Variables**
In Vercel dashboard → Settings → Environment Variables:
- `VITE_AUTH0_DOMAIN`: `merajmunshi.us.auth0.com`
- `VITE_AUTH0_CLIENT_ID`: `wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd`

### 4. **Update Auth0 Settings**
Add your Vercel URL to Auth0 settings:
- **Callback URLs**: `https://your-app-name.vercel.app/`
- **Logout URLs**: `https://your-app-name.vercel.app/`
- **Web Origins**: `https://your-app-name.vercel.app`

## 🎯 **Your App Will Be Live At:**
**https://your-project-name.vercel.app/**

## 🔄 **Automatic Deployments**
- Every push to main branch triggers automatic deployment
- Preview deployments for pull requests
- Real-time build logs

## 🔒 **Security**
- Repository remains private
- Auth0 authentication protects content
- Fast global deployment

---

**Vercel is excellent for React apps! 🎉**
