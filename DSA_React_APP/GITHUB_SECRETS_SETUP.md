# GitHub Secrets Setup Guide for Two-Repository Deployment

## Overview
This guide explains how to set up GitHub secrets for deploying your **private** DSA React App to a **public** repository for GitHub Pages hosting.

## Architecture
- **Private Repository**: `DSA_React_APP` (your source code)
- **Public Repository**: `dsamentor-deploy` (only contains built files)
- **GitHub Actions**: Automatically builds and deploys from private to public repo

## Required GitHub Secrets

### 1. Auth0 Credentials (Private Repository)
Add these secrets to your **private repository** (`DSA_React_APP`):

#### Go to: https://github.com/merajmunshiofficial/DSA_React_APP/settings/secrets/actions

**Required Secrets:**
- `VITE_AUTH0_DOMAIN` = `merajmunshi.us.auth0.com`
- `VITE_AUTH0_CLIENT_ID` = `wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd`

**Optional Secret:**
- `VITE_AUTH0_AUDIENCE` = (your Auth0 API audience, if you have one)

### 2. GitHub Personal Access Token (Private Repository)
You need a Personal Access Token to allow the private repo to push to the public repo.

#### Create a Personal Access Token:
1. Go to: https://github.com/settings/tokens
2. Click "Generate new token" > "Generate new token (classic)"
3. **Name**: `Deploy to dsamentor-deploy`
4. **Expiration**: Choose your preferred expiration
5. **Scopes**: Check the following:
   - `repo` (Full control of private repositories)
   - `workflow` (Update GitHub Action workflows)

6. Click "Generate token"
7. **Copy the token** (you won't see it again!)

#### Add the token as a secret:
1. Go to: https://github.com/merajmunshiofficial/DSA_React_APP/settings/secrets/actions
2. Click "New repository secret"
3. **Name**: `DEPLOY_TOKEN`
4. **Value**: Paste your Personal Access Token
5. Click "Add secret"

## Summary of Secrets Needed

In your **private repository** (`DSA_React_APP`), add these 3-4 secrets:

```
VITE_AUTH0_DOMAIN = merajmunshi.us.auth0.com
VITE_AUTH0_CLIENT_ID = wetVbccRWFxGMtiWEfAI9XGFZnWRj4Gd
VITE_AUTH0_AUDIENCE = (optional)
DEPLOY_TOKEN = (your GitHub Personal Access Token)
```

## How It Works

1. **When you push to main branch** in your private repo
2. **GitHub Actions triggers** the deployment workflow
3. **Secrets are injected** into environment variables during build
4. **App is built** with your real Auth0 credentials
5. **Built files are pushed** to the public repository
6. **GitHub Pages serves** the app from the public repo

## Auth0 Configuration

Make sure your Auth0 application has these URLs configured:

**Callback URLs:**
```
http://localhost:5173/, https://merajmunshiofficial.github.io/dsamentor-deploy/
```

**Logout URLs:**
```
http://localhost:5173/, https://merajmunshiofficial.github.io/dsamentor-deploy/
```

**Web Origins:**
```
http://localhost:5173, https://merajmunshiofficial.github.io/dsamentor-deploy
```

## Testing

After setting up the secrets:
1. Make a small change to your code
2. Push to the main branch
3. Check the Actions tab to see the deployment
4. Your app should be live at: https://merajmunshiofficial.github.io/dsamentor-deploy/

## Security Notes

- ✅ **Auth0 credentials are secure** - stored as GitHub secrets
- ✅ **Source code remains private** - only built files are public
- ✅ **Automatic deployment** - no manual steps needed
- ✅ **No credentials in public repo** - everything is handled securely

## Troubleshooting

If deployment fails:
1. Check that all secrets are set correctly
2. Verify the Personal Access Token has the right permissions
3. Check the Actions tab for error messages
4. Ensure Auth0 URLs are configured properly
name: Deploy to GitHub Pages

on:
  push:
    branches: [ main ]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    steps:
    - name: Checkout
      uses: actions/checkout@v4
      
    - name: Setup Node.js
      uses: actions/setup-node@v4
      with:
        node-version: '18'
        cache: 'npm'
        
    - name: Install dependencies
      run: npm ci

    - name: Create .env file from secrets
      run: |
        echo "VITE_AUTH0_DOMAIN=${{ secrets.VITE_AUTH0_DOMAIN }}" > .env
        echo "VITE_AUTH0_CLIENT_ID=${{ secrets.VITE_AUTH0_CLIENT_ID }}" >> .env
        echo "VITE_AUTH0_AUDIENCE=${{ secrets.VITE_AUTH0_AUDIENCE }}" >> .env
      
    - name: Build
      run: npm run build
      
    - name: Deploy to GitHub Pages
      uses: peaceiris/actions-gh-pages@v3
      if: github.ref == 'refs/heads/main'
      with:
        github_token: ${{ secrets.GITHUB_TOKEN }}
        publish_dir: ./dist
        external_repository: merajmunshiofficial/dsamentor-deploy
        publish_branch: main
        force_orphan: true
```

## 🔧 Testing the Setup

After adding the secrets:
1. Make any small change to your code
2. Commit and push to the main branch
3. Check the **Actions** tab in your repository
4. Watch the workflow run automatically
5. Your app will be deployed to: https://merajmunshiofficial.github.io/dsamentor-deploy/

## 🎉 Final Result

Once set up, every time you push code to your private repository, it will:
- ✅ Build with your Auth0 credentials
- ✅ Deploy to your public GitHub Pages
- ✅ Keep your source code private
- ✅ Make your app accessible to users

No more manual deployment needed! 🚀
